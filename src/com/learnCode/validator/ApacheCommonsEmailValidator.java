package com.learnCode.validator;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.validator.routines.EmailValidator;

public class ApacheCommonsEmailValidator 
{
	// REVIEW : average
	public static void main(final String[] args) throws IOException {

		EmailValidator emailValidator = EmailValidator.getInstance();

		Scanner scn = new Scanner(System.in);
		System.out.print("String Input : ");
		String email = scn.nextLine();
		boolean valid = emailValidator.isValid(email);
		if (valid) 
		{
			System.out.println(email + ": YES");
		}
		else
		{
			System.out.println(email + ": NO");
		}
		scn.close();
	}
}
