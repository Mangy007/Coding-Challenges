package com.learnCode.validator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test
{

	public static void main(String[] args)
	{
	       System.out.println("Hello World");
	       
	       String pattern = "dd-M-yyyy hh:mm:ss";
	       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	       String date = simpleDateFormat.format(new Date());
	       System.out.println(date);
	}

}
