package com.learnCode.validator;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.UrlValidator;

public class ApacheCommonsUrlValidator
{
	// REVIEW : Not Good
	public static void main(final String[] args) throws IOException {

		UrlValidator urlValidator = UrlValidator.getInstance();

		Scanner scn = new Scanner(System.in);
		System.out.print("String Input : ");
		String url = scn.nextLine();
		boolean valid = urlValidator.isValid(url);
		if (valid) 
		{
			System.out.println(url + ": YES");
		}
		else
		{
			System.out.println(url + ": NO");
		}
		scn.close();
	}
}
