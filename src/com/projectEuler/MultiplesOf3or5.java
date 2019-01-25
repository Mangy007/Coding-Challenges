package com.projectEuler;

public class MultiplesOf3or5
{
	public static void main(String[] args)
	{
		int i=1;
		int sum=0;
		while (i>0 && i<1000)
		{
			if (i%3==0 || i%5==0)
			{
				sum+=i;
			}
			i++;
		}
		System.out.println("sum : "+sum);
	}
}
