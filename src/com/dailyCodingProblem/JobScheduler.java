package com.dailyCodingProblem;

import java.util.Scanner;

//TODO: This problem was asked by Apple.
/**
 * Implement a job scheduler which takes in a function f and an integer n,
 * and calls f after n milliseconds.
 * */
public class JobScheduler
{
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter time (in milliseconds) for job scheduler: ");
		int n  = scn.nextInt();
		jobScheduler(performSomeAction(),n);
		scn.close();
	}

	private static void jobScheduler(Object func1, int n)
	{
		int i=0;
		int seconds = n/1000;
		while(i<=seconds)
		{
			if(i==seconds)
			{
				i=0;
				System.out.println(performSomeAction());
			}
			i++;
		}
	}

	private static String performSomeAction()
	{
		return "entered";
	}

}
