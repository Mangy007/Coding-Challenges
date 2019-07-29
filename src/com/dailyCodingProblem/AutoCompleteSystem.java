package com.dailyCodingProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//TODO: This problem was asked by Twitter.
/**
 * Implement an autocomplete system.
 *  That is, given a query string s 
 *  	and a set of all possible query strings,
 *  	return all strings in the set that have s as a prefix.
 *  For example, given the query string de 
 *  	and the set of strings [dog, deer, deal],
 *  	return [deer, deal].
 *  
 *  Hint: Try preprocessing the dictionary into a 
 *  	  more efficient data structure to speed up queries.
 */

public class AutoCompleteSystem
{
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter keyword to search: ");
		String str = scn.nextLine();
		Set<String> dict = new HashSet<>();
		List<String> result = new ArrayList<>();
		System.out.print("\nEnter Total Inputs in dictionary:");
		int totalInputs = scn.nextInt();
		scn.next();
		for(int i=0;i<totalInputs;i++)
		{
			dict.add(scn.nextLine());
		}
		for (String string : dict)
		{
			if(string.startsWith(str))
				result.add(string);
		}
		System.out.println("Output: "+result);
		scn.close();
	}

}
