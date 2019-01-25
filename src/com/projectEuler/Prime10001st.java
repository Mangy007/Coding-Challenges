package com.projectEuler;

import java.util.ArrayList;
import java.util.List;

public class Prime10001st
{
	public static void main(String[] args)
	{
		List<Integer> prime = new ArrayList<>();
		int n=2;
		while (prime.size()<10002)
		{
			int i=2;
			boolean flag = false;
			while (i<n/2)
			{
				if (n%i==0)
				{
					flag=true;break;
				}
				i++;
			}
			if (!flag) prime.add(n);
			n++;
		}
		System.out.println("prime : "+prime.get(prime.size()-1));
	}

}
