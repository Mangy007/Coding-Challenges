package com.projectEuler;

public class SumSquareDifference
{
	public static void main(String[] args)
	{
		long sumOfSquare = 0;
		long squareOfSum = 0;
		int n=100;
		sumOfSquare=n*(n+1)*(2*n+1)/6;
		squareOfSum= (long) Math.pow(n*(n+1)/2, 2);
		System.out.println(squareOfSum-sumOfSquare);
	}

}
