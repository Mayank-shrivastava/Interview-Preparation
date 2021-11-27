package dsa.stack;

import java.util.EmptyStackException;

public class StackUsingLL {

    private ListNode top;
    private int length;

    private static class ListNode {
        private int data;
        private ListNode next;

        //constructor
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() {
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }
    
    // 1.Reverse the string using the stack

    public static void main(String[] args) {
        
    }

}
