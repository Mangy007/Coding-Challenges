package com.projectEuler;

public class LargestPalindromeProduct
{
	public static void main(String[] args)
	{
		int max=0;
		int i=999;
		
		while (i>99 && i<1000)
		{
			for (int j = 999; j >= i; j--)
			{
				if (isPalindrome(j*i) && max<j*i) max=j*i;
			}
			i--;
		}
		System.out.println("max : "+max);
	}

	private static boolean isPalindrome(int n)
	{
		String str = Integer.toString(n);
		for (int i = 0, j=str.length()-1; i < str.length()/2; i++,j--)
		{
			if (str.charAt(i)!=str.charAt(j)) return false;
		}
		return true;
	}

}
