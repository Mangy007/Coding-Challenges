package com.company.learnCode.codeChef;

import java.util.Scanner;

public class ATM
{
	public static void main(String[] args)
	{
		double x, y;
		
		Scanner scn = new Scanner(System.in);
		x = scn.nextInt();
		y = scn.nextInt();
		
		if (x % 5 != 0)
		{
			System.out.println(y);
		}
		else if (x > y)
		{
			System.out.println(y);
		}
		else {
			System.out.println(y-x-0.50);
		}

	}
}
