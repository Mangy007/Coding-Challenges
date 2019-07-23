package com.dailyCodingProblem;

import java.util.Scanner;

//TODO: This problem was asked by Airbnb.
/**
 * Given a list of integers, 
 * Write a function that returns the largest sum of non-adjacent numbers.
 * Numbers can be 0 or negative.
 * For example, 
 * 		[2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5.
 *		[5, 1, 1, 5] should return 10, since we pick 5 and 5.
 **/
public class LargestNonAdjacentNumber
{
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		int[] arr = new int[str.split(" ").length];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Integer.parseInt(str.split(" ")[i]);
		}
		System.out.println(getLargestSum(arr));
		scn.close();
	}

	private static int getLargestSum(int[] arr)
	{
		int incl = 0;
		int excl = 0;
		for (int i : arr)
		{
			int temp = incl;
			incl = Math.max(excl+i, incl);
			excl = temp;
		}
		return incl;
	}

}
