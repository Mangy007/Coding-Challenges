package com.dailyCodingProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//TODO: This problem was asked by Amazon.

/**
 * Given an integer k and a string s, find the length of the 
 * longest substring that contains at most k distinct characters.
 * For example, 
 * given s = "abcba" and k = 2, 
 * 	the longest substring with k distinct characters is "bcb".
 * given s = "abcba" and k = 3, 
 * 	the longest substring with k distinct characters is ["abcba"]
 */
public class DistinctLongestSubstring
{
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		Map<Integer, List<String>> result = new HashMap<>();
		Set<String> dict = new HashSet<>();
		int index=0;
		System.out.print("Enter k:");
		int k = scn.nextInt();
		System.out.print("Enter String:");
		String word = scn.next();
		result = getSubstring(word, 0, dict, "", result, index, k);
		System.out.println("output: "+result.get(Collections.max(result.keySet())));
		scn.close();
	}

	private static Map<Integer, List<String>> getSubstring(String word, int i, Set<String> dict, String str, 
																Map<Integer, List<String>> result, int index, int k)
	{
		if(i==word.length()) 
		{
			if(dict.size()>=k)
			{
				result = addSubstringToMap(str, result);
			}
			return result;
		}
		dict.add(word.charAt(i)+"");
		if(dict.size()>k)
		{
			i=++index;
			result = addSubstringToMap(str, result);
			dict.clear();
			result = getSubstring(word, i, dict, "", result, index, k);
		}
		else 
		{
			str+=word.charAt(i);
			i++;
			result = getSubstring(word, i, dict, str, result, index, k);	
		}
		return result;
	}

	private static Map<Integer, List<String>> addSubstringToMap(String str, Map<Integer, List<String>> result)
	{
		if (result.containsKey(str.length())) result.get(str.length()).add(str);
		else 
		{
			List<String> listOfSubstrings = new ArrayList<>();
			listOfSubstrings.add(str);
			result.put(str.length(), listOfSubstrings);
		}
		return result;
	}

}
