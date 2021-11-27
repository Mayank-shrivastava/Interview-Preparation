package daalab;

import java.util.*;

public class BinaryTree {

    // Root of the binary tree
    Node root;
    // constructor for Binary Tree
    public BinaryTree() {
        this.root = null;
    }

    // method for computing the height of the tree
    int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            // compute the height of each subtree
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            // use the larger one
            if(leftHeight > rightHeight) {
                return (leftHeight + 1);
            } else {
                return (rightHeight + 1);
            }
        }
    }

    // Print the nodes at the current level
    void printCurrentLevel(Node root, int level) {
        if(root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if(level > 1) {
            printCurrentLevel(root.left , level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    // bfs traversal
    void bfs() {
        int height = height(root); // height of the tree
        for(int i = 1; i <= height; i++) {
            printCurrentLevel(root, i);
        }
    }

    void bfsUsingQueue() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            // enqueue left child
            if(tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // enqueue right child
            if(tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    
    void dfsInorder() {
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        // traverse the tree
        while(curr != null || stack.size() > 0) {
            // reach the left most node of the current node
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            //current must be null at this point
            curr = stack.pop();
            System.out.println(curr.data);

            // we have visited the node and its subtree
            // now, it's right subtree's turn
            curr = curr.right;
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // System.out.print("bfs traversal using recursion" + " :");
        // tree.bfs();
        // System.out.println("bfs traversal using queue" + " :");
        // tree.bfsUsingQueue();
        System.out.println("Inorder DFS traversal" + " :");
        tree.dfsInorder();

    }
}
// Node class 
class Node {
    int data;
    Node left;
    Node right;
    // constructor 
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
