package com.projectEuler;

public class LargestPrimeFactor
{
	public static void main(String[] args)
	{
		long n=600851475143L;
		int i=2;
		int max=0;
		while (i<=n)
		{
			if (n%i==0)
			{
				n=n/i;
				if (max<i)
				{
					max=i;
				}
				i=2;
			}
			else i++;
		}
		System.out.println("max : "+max);
	}

}
