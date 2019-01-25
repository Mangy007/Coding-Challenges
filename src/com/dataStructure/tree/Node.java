package com.dataStructure.tree;

public class Node
{
	int value;
	Node left, right;
	
	public Node(int value)
	{
		this.value = value;
		left = right = null;
	}
	@Override
	public String toString()
	{
		return value+"";
	}
	
}
