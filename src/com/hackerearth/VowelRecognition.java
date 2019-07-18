package com.hackerearth;

import java.util.*;

public class VowelRecognition
{
	public static void main(String[] args)
	{
		String text = "baceb".toLowerCase();
        System.out.println(vowelsCount(text));
	}
	
	public static int vowelsCount(String txt)
    {
        String text = txt.toLowerCase();
        String vowel = "aeiou";
		Set<String> variation = new HashSet<>();
		for (int i = 0; i < text.length(); i++)
		{
			for (int j = i+1; j < text.length(); j++)
			{
				variation.add(text.substring(i, j));
			}
			variation.add(text.substring(i));
		}
		int count=0;
		for (String str : variation)
		{
			for (int i = 0; i < str.length(); i++)
			{
				if (vowel.contains(str.charAt(i)+"")) count+=1;
			}
		}
		return count;
    }

}
