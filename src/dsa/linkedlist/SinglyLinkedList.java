package dsa.linkedlist;

public class SinglyLinkedList {
    // Node class
    public static class Node {
        private int data;
        private Node next;

        // constructor for initializing Node object
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Singly-Linked List class
    public static class LinkedList {
        private Node head;
        private Node tail;
        int size;

        // add to the last of the singlylinkedlist
        public void addLast(int data) {
            Node newNode = new Node(data);
            if(size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }


        // get the size of the sll
        public int size() {
            return size;
        }

        // display the sll
        public void display() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // remove first from the sll
        public void removeFirst() {
            if(size == 0) {
                System.out.println("Linkedlist is empty");
            } else if(size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                head = head.next;
                temp.next = null;
                size--;
            }
        }

        // methods to get the values of the sll
        // get the first data of the sll
        public int getFirst() {
            if(size == 0) {
                System.out.println("Linkedlist is empty");
                return -1; 
            } else {
                return head.data;
            }
        }
        
        // get the last data of the sll
        public int getTail() {
            if(size == 0) {
                System.out.println("Linkedlist is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        // get value from the particular index
        public int getAt(int idx) {
            if(size == 0) {
                System.out.println("LinkedList is empty");
                return -1;
            } else if(idx < 0 || idx >= size) {
                System.out.println("Invalid Arguments or index out of bound");
                return -1;
            } else {
                Node temp = head;
                for(int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                // now temp will point to the node at the given index
                return temp.data;
            }
        }

        // add first in the sll 
        public void addFirst(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            if(size == 0) {
                tail = newNode;
            }
            size++;
        }

        // add at particular index in a sll
        public void addAt(int data, int idx) {
            Node newNode = new Node(data);
            if(idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
                return;
            }
            else if(idx == 0) {
                // add at first concept will be used
                newNode.next = head;
                head = tail = newNode;
            } else if(idx == size) {
                // add at last concept will be used
                tail.next = newNode;
                tail = newNode;
            } else {
                Node previous = head;
                // get the node previous to the index given
                for(int i = 0; i < idx-1; i++) {
                    previous = previous.next;
                }
                newNode.next = previous.next;
                previous.next = newNode;
            }
            size++;
        }

        // remove last in the sll
        public void removeLast() {
            if(size == 0) {
                System.out.println("Linkedlist is empty");
            } else if(size == 1) {
                head = tail = null;
                size = 0;
            } else {
                // get the node previous to the tail node
                Node previous = head;
                for(int i = 0; i < size-2; i++) {
                    previous = previous.next;
                }
                tail = previous;
                previous.next = null;
                size--;
            }
        }

        public void removeAt(int idx) {
            if(idx < 0 || idx >= size) {
                System.out.println("Invalid Arguments");
            } else if(idx == 0) {
                removeFirst();
            } else if(idx == size-1) {
                removeLast();
            } else {
                Node previous = head;
                for(int i = 0; i < idx - 1; i++) {
                    previous = previous.next;
                }
                Node curr = previous.next;
                previous.next = curr.next;
                curr.next = null;
                size--;
            }
        }

        private Node getNodeAt(int idx) {
            if(size == 0) {
                System.out.println("LinkedList is empty");
                return null;
            } else if(idx < 0 || idx >= size) {
                System.out.println("Invalid Arguments or index out of bound");
                return null;
            } else {
                Node temp = head;
                for(int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                // now temp will point to the node at the given index
                return temp;
            }
        }

        // reverse a linked list : data iterative
        public void reverseDI() {
            int l = 0;
            int r = size - 1;
            while(l < r) {
                Node left = getNodeAt(l);
                Node right = getNodeAt(r);
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
                l++;
                r--;
            }
        }

        // reverse a linked list : pointer iterative
        public void reversePI() {
            if(head == null || head.next == null) return; // no reversal for 0,1 length sll
            Node previous = null;
            Node forward = null;
            Node current = head;

            while(current != null) {
                forward = current.next; // backup before distorting links

                current.next = previous; // connecting the links
                // movement of three pointers
                previous = current;
                current = forward;
            }
            tail = head;
            head = previous;
        }

        // find/return the kth node from the end
        public Node kthNodeFromLast(int k) {
            // create two pointers slow and fast
            Node slow = head;
            Node fast = head;
            // create the gap of k between slow and fast node
            for(int i = 0; i < k; i++) {
                fast = fast.next;
            }
            // maintain the same gap as above and traversal the sll when fast ptr points
            // towards the last node slow ptr will give kth node from last
            while(fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        // middle node of the sll
        public Node middle() {
            Node slow = head;
            Node fast = head;
            while(fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next; // fast always moves twice the slow 
            }
            return slow;
        }


        // remove duplicates from the sorted sll
        public void removeDuplicates() {
            Node curr = head;
            // traverse list till the last node
            while(curr != null) {
                Node temp = curr;
                // compare curr node with the next node keep on deleting until it matches the current node data
                while(temp != null && temp.data == curr.data) {
                    temp = temp.next;
                }
                curr.next = temp; // connecting link b/w temp and curr
                curr = curr.next; // move current
            }
        }

        // segregate even odd in a sll
        public void evenOdd() {
            Node dummyEven = new Node(-1);
            Node dummyOdd = new Node(-1);
            Node oddTail = dummyOdd;
            Node evenTail = dummyEven;
            Node curr = head;
            while(curr != null)  {
               if(curr.data % 2 != 0) {
                   //odd
                   oddTail.next = curr; // link
                   oddTail = oddTail.next; // move
               } else {
                   // even
                   evenTail.next = curr; // link
                   evenTail = evenTail.next; // move
               }
               curr = curr.next;
            }
            evenTail.next = dummyOdd.next;
            oddTail.next = null;
            head = dummyEven.next;
        }
    }

    // merge two sorted sll
    public static LinkedList merge(LinkedList l1, LinkedList l2) {
        // same as merger sort merge technique
        Node one = l1.head;
        Node two = l2.head;
        LinkedList result = new LinkedList();

        while(one != null && two != null) {
            if(one.data < two.data) {
                result.addLast(one.data);
                one = one.next;
            } else {
                result.addLast(two.data);
                two = two.next;
            }
        }

        while(one != null) {
            result.addLast(one.data);
            one = one.next;
        }

        while(two != null) {
            result.addLast(two.data);
            two = two.next;
        }

        return result;
    }

    public static Node midNode(Node head, Node tail) {
        Node slow = head;
        Node fast = head;
        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // merge sort the sll
    public static LinkedList mergeSort(Node head, Node tail) {

        // base-case for recursion
        // br = base-result
        if(head == tail) {
            LinkedList br = new LinkedList();
            br.addLast(head.data);
            return br;
        }

        Node mid = midNode(head, tail);
        // ffh = first sorted half
        LinkedList ffh = mergeSort(head, mid);
        // ssh = second sorted half
        LinkedList ssh = mergeSort(mid.next, tail);
        // merge the sorted arrays
        // cl = complete sll
        LinkedList cl = merge(ffh, ssh);
        return cl;
    }

    public static void main(String[] args) {

        LinkedList sll = new LinkedList();
        // sll.head = new Node(5); // head of the singlylinkedlist
        // Node node1 = new Node(10);
        // sll.head.next = node1;
        // testList(sll);
        // sll.addLast(1);
        // sll.addLast(2);
        // sll.addLast(3);
        // sll.addLast(4);
        // // testList(sll);
        // sll.removeFirst();
        // sll.display();
        // System.out.println(sll.getAt(0));
        // sll.addFirst(10);
        // sll.display();
        // sll.addAt(50, 2);
        // sll.display();
        // sll.removeLast();
        // System.out.println("Linked List after removing element");
        // sll.display();
        // sll.removeAt(2);
        // sll.display();
        // sll.addLast(1);
        // sll.addLast(2);
        // sll.addLast(3);
        // sll.addLast(4);
        // sll.addLast(5);
        // System.out.println("Linkedlist before reversal");
        // sll.display();
        // // sll.reverseDI();
        // sll.reversePI();
        // System.out.println("Linkedlist after reversal");
        // sll.display();
        // System.out.println(sll.kthNodeFromLast(3).data);
        // System.out.println(sll.middle().data);
        // LinkedList sll1 = new LinkedList();
        // sll1.addLast(10);
        // sll1.addLast(20);
        // sll1.addLast(30);
        // sll1.addLast(40);
        // sll1.addLast(50);
        // LinkedList sll2 = new LinkedList();
        // sll2.addLast(7);
        // sll2.addLast(9);
        // sll.addLast(12);
        // sll.addLast(15);
        // merge(sll1, sll2).display();
        // sll.addLast(2);
        // sll.addLast(8);
        // sll.addLast(1);
        // sll.addLast(7);
        // sll.addLast(4);
        // sll.addLast(6);
        // sll.addLast(5);
        // sll.addLast(3);
        // sll.display();
        // mergeSort(sll.head, sll.tail).display();
        // sll.addLast(2);
        // sll.addLast(2);
        // sll.addLast(2);
        // sll.addLast(3);
        // sll.addLast(3);
        // sll.addLast(4);
        // sll.addLast(5);
        // sll.addLast(5);
        // sll.display();
        // sll.removeDuplicates();
        // sll.display();
        sll.addLast(1);
        sll.addLast(3);
        sll.addLast(2);
        sll.addLast(4);
        sll.addLast(5);
        sll.addLast(6);
        sll.addLast(7);
        sll.addLast(18);
        sll.addLast(19);
        sll.display();
        sll.evenOdd();
        sll.display();
    }
}
