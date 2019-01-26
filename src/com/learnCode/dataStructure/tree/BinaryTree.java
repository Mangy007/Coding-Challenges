package com.learnCode.dataStructure.tree;

public class BinaryTree
{
	Node root;
	
	public BinaryTree()
	{
		root = null;
	}

	public static void main(String[] args)
	{
		BinaryTree bTree = new BinaryTree();
		
		bTree.root = new Node(1);
		bTree.root.left = new Node(2);
		bTree.root.right = new Node(3);
		bTree.root.left.left = new Node(4);
		
		System.out.println("Binary Tree :\n "+bTree.toString());
	}
	
	@Override
	public String toString()
	{
		String result = "";
		
		result += "root : "+root+ "\n root.left : "+root.left+"\n root.right : "+ root.right +"\n root.left.left : "+root.left.left;
		return result;
	}

}
