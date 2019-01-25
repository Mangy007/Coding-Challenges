package com.projectEuler;

public class SmallestMultiple
{
	public static void main(String[] args)
	{
		int i=1;
		int n=1;
		while (i<=20)
		{
			if (n%i==0) i++;
			else 
			{
				i=1;
				n++;
			}
		}
		System.out.println("smallest : "+n);
	}

}
