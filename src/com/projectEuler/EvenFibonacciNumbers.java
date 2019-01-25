package com.projectEuler;

public class EvenFibonacciNumbers
{
	public static void main(String[] args)
	{
		int a=1,b=2,c=a+b;
		int sum=b;
		while (c<4000000)
		{
			a=b;
			b=c;
			c=a+b;
			if (c%2==0) sum+=c;
		}
		System.out.println("sum : "+sum);
	}
}
