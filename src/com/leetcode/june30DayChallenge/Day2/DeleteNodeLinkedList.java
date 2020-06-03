package com.leetcode.june30DayChallenge.Day2;

class Node {

    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        next = null;
    }
}
public class DeleteNodeLinkedList {

    Node head;

    private void push(int val) {

        Node node = new Node(val);
        node.next = head;

        head = node;
    }

    private void deleteNode(Node node) {

        Node currNode = head;

        while(currNode!=null) {
            if(currNode.next!=null && currNode.next.val==node.val)
                currNode.next = currNode.next.next;
            
            currNode = currNode.next;
        }
    }

    private void deleteNodeWithoutUsingHead(Node node) {
        if(node.next==null)
            return;

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public String toString() {
        String result = "";
        Node node = head;

        while(node!=null) {
            result+=node.val;
            node = node.next;
        }

        return result;
    }

    private Node getElementByIndex(int n) {
        int count = 0;
        Node node = head;

        while(node!=null) {
            if(count==n)
                return node;
            count++;
            node = node.next;
        }
        return node;
    }
    
    public static void main(String[] args) {

        DeleteNodeLinkedList linkedList = new DeleteNodeLinkedList();

        linkedList.push(4);
        linkedList.push(5);
        linkedList.push(1);
        linkedList.push(9);

        System.out.println(linkedList);
        Node n = linkedList.getElementByIndex(2);

        // linkedList.deleteNode(n);
        linkedList.deleteNodeWithoutUsingHead(n);

        System.out.println(linkedList);

    }
}