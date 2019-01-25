package com.company.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUrlValidator
{
	
	public static List<String> extractUrls(String text)
	{
	    List<String> containedUrls = new ArrayList<String>();
	    String urlRegex = "((https?|ftp|gopher|telnet|file)( *)(:*)(( +)|(//)|(\\\\)|( +))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
	    Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
	    Matcher urlMatcher = pattern.matcher(text);

	    while (urlMatcher.find())
	    {
	    	System.out.println("Matched : "+text.substring(urlMatcher.start(0), urlMatcher.end(0)));
	        containedUrls.add(text.substring(urlMatcher.start(0),
	                urlMatcher.end(0)));
	    }

	    return containedUrls;
	}
	
	public static void main(String []args)
    {
		Scanner scn = new Scanner(System.in);
		System.out.print("String Input : ");
		String text = scn.nextLine();
		
		List<String> extractedUrls = extractUrls(text); //<iTokens>

		for (String url : extractedUrls)
		{
		    System.out.println(url);
		}
    }
}
