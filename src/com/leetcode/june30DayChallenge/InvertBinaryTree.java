package com.leetcode.june30DayChallenge;

class Node {
    int val;
    Node left;
    Node right;

    public Node() {}

    public Node (int val) {
        this.val = val;
        left = right = null;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InvertBinaryTree 
{
    Node root;

    private void orderedTraversal() {
        orderedTraversal(root);
    }

    private void orderedTraversal(Node node) {

        if(node==null)
            return;
        
        orderedTraversal(node.left);
        System.out.print(node.val+" ");
        orderedTraversal(node.right);
    }

    private void invertTree() {
        root = invertTree(root);
    }

    private Node invertTree(Node node) {

        if(node==null)
            return node;
        
        Node left = invertTree(node.right);
        Node right = invertTree(node.left);

        node.left = right;
        node.right = left;

        return node;
    }


    public static void main(String[] args) {

        InvertBinaryTree tree = new InvertBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 

        System.out.println("Ordered Traversal");
        tree.orderedTraversal();
        System.out.println("\nInverted ordered");
        tree.invertTree();
        tree.orderedTraversal();

    }
    
}