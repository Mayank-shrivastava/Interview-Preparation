package dsa.linkedlist;

public class SinglyLinkedList {

    ListNode head = null; // head node of the linked-list;
    // Node class 
    private static class ListNode {
        private int data;
        private ListNode next;
        
        // constructor for the node class
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        } 
    }

    // 1.Method to display the Linked-List
    private void display() {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 2.Method to calculate the length of the Linked-List
    private int length() {
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    // 3. Insert node at the begining of the Linked-List
    private void insertAtFirst(int data) {
        // create a node
        ListNode newNode = new ListNode(data);
        // if head == null head = newNode;
        if(head == null) {
            head = newNode;
        }

        newNode.next = head;
        head = newNode;
    }

    // 4. Insert node at the last of the Linked-List
    private void insertAtLast(int data) {
        // create a node
        ListNode newNode = new ListNode(data);
        // if head == null head = newNode;
        if(head == null) head = newNode;
        
        // if we want to insert node at the last of the linked-list we need to traverse 
        // through the list to get the last node
        ListNode current = head;
        while(current.next != null) {
            current = current.next;
        }
        // after the compelition of the while loop pointer current will point to the last node of the linked-list
        current.next = newNode;
        newNode.next = null; // trivial 
    }

    // 5. Delete the begining node of the Linked-List
    private ListNode deleteAtFirst() {
        if(head == null) {
            System.out.println("Empty List");
            return null;
        }
        ListNode newNode = head;
        head = head.next;
        newNode.next = null;
        return newNode;
    }

    // 6. Delete the last node 
    private ListNode deleteAtLast() {
        // if list is empty no node will be deleted
        if(head == null || head.next == null) {
            System.out.println("Empty-List");
            return head;
        }

        // for deleting the last node we need to traverse the list to get the last node and the node 
        // previous to the current node
        ListNode current = head;
        ListNode previous = null;
        while(current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    // 7. Insert node at the given position
    private void insertAt(int position, int data) {
        ListNode previous = head;
        for(int k = 0; k < position - 1; k++) {
            previous = previous.next;
        }
        ListNode current = previous.next;
        ListNode newNode = new ListNode(data);
        newNode.next = current;
        previous.next = newNode;
    }

    // 8. Delete node from the given position
    private ListNode deleteAt(int position) {
        if(head == null) {
            return null;
        }
        ListNode previous = head;
        for(int k = 0; k < position - 1; k++) previous = previous.next;
        ListNode current = previous.next; // node to be deleted
        previous.next = current;
        return current;
    }

    // 9. Delete the node when no head pointer is given only the node which is to be deleted is given
    // private void deleteGivenNode(ListNode nodeToBeDeleted) {
    //     ListNode temp = nodeToBeDeleted.next;
    //     nodeToBeDeleted.data = temp.data;
    //     nodeToBeDeleted.next = temp.next;
    // }

    // 10. Find the middle node of the linked-list
    private ListNode getMiddle() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    // 11. Find the nth node from the end of the linked-list
     private ListNode nthNodeFromEnd(int n) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for(int count = 0; count < n; count++) {
            fast = fast.next;
        }
        while(fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
     }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList(); // object of the singly-linked-list class

        // create the node
        sll.head = new ListNode(10);
        ListNode node1 = new ListNode(11);
        ListNode node2 = new ListNode(12);
        ListNode node3 = new ListNode(13);

        // creating the connection between the nodes
        sll.head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null; // trivial-no need to specify it
        sll.display(); // 10->11->12->13-null
        System.out.println("Length of the LinkedList is " + sll.length());// length of the linkedlist -> 4

        // insert-first
        sll.insertAtFirst(14); 
        sll.insertAtFirst(15);
        sll.display(); //15->14->10->11->12->13->null
        sll.insertAtLast(20);
        sll.insertAtLast(50);
        sll.display(); // 15->14->10->11->12->13->20->50->null;
        System.out.println(sll.deleteAtFirst().data); // 15
        sll.display(); // 14->10->12->13->20->50->null;
        System.out.println(sll.deleteAtLast().data); // 50
        sll.display(); // 14->10->12->13->20->null;
        sll.insertAt(2, 25);
        sll.display(); // 14->25->10->12->13->20->null
        //sll.insertAt(8, 30); this will give null ptr exception
        sll.insertAt(3, 30);
        sll.display(); 
        System.out.println(sll.deleteAt(2).data); //25
        //  sll.deleteGivenNode(10);
        // sll.display();
        System.out.println(sll.getMiddle().data); // 12
        System.out.println(sll.nthNodeFromEnd(4).data);

    }    
}

