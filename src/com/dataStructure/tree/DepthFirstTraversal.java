package com.dataStructure.tree;

public class DepthFirstTraversal
{
	Node root;
	
	public DepthFirstTraversal()
	{
		root = null;
	}
	
	public static void main(String[] args)
	{
		DepthFirstTraversal dfs = new DepthFirstTraversal();
		
		dfs.inOrderTraversal(root);
		
	}
}
