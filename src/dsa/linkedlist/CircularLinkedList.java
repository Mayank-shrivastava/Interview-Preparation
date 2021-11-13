package dsa.linkedlist;

import java.util.NoSuchElementException;

// circular ll -> similar to sll but the last node points to the first node and not null
// in csll we keep track of the last node and not the head node
public class CircularLinkedList {
    private ListNode last;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        } 
    }

    public CircularLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    public void createCircularLL() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }   
    
    public void display() {
        if(last == null) return;

        ListNode first = last.next;
        while(first!=last) {
            System.out.print(first.data + "->");
            first = first.next;
        }
        System.out.println(first.data);
    }

    // 1.insert a node at the beginning of the circular linkedlist
    public void insertAtFirst(int data) {
        ListNode temp = new ListNode(data);
        if(last == null) {
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    } 

    // leaders vs followers
    // thoughts on #me-too campaign
    // hardwork vs smart work
    // women are hardworker
    // self motivation

    // 2.insert node at the end of circular linkedlist
    public void insertAtLast(int data) {
        ListNode temp = new ListNode(data);
        if(last == null) {
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    // 3. remove the first node from the cll
    public ListNode deleteAtFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty cll");
        }

        ListNode temp = last.next;
        if(last.next == last)  {
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCircularLL();
        cll.display();
        cll.insertAtFirst(13);
        cll.display();
        cll.insertAtLast(50);
        cll.display();
        System.out.println(cll.deleteAtFirst().data);
        cll.display();
    }
}
