package com.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EasyMatrix
{
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		String size = scn.nextLine();
		int n = Integer.parseInt(size.split(" ")[0]);
		int m = Integer.parseInt(size.split(" ")[1]);
		char[][] matrix = new char[n][m];
		for (int i = 0; i < matrix.length; i++)
		{
			String row = scn.nextLine();
			String[] columns = row.split(" ");
			for (int j = 0; j < columns.length; j++)
			{
				matrix[i][j] = columns[j].charAt(0);
			}
		}
		scn.close();
		List<String> paths = new ArrayList<>();
		paths = getAllPaths(paths,matrix,0,0,"");
		Map<Integer, String> pathValue = new HashMap<>();
		int min=0;
		for (String str : paths)
		{
			int temp = 0;
			for (int i = 0; i < str.length(); i++)
			{
				temp += str.charAt(i);
			}
			System.out.println(temp+" "+str);
			pathValue.put(temp, str);
			if(min==0||min>temp) min=temp;
		}
		System.out.println(pathValue.get(min));
	}

	private static List<String> getAllPaths(List<String> paths, char[][] matrix, int i, int j, String str)
	{
		if(i==matrix.length-1 && j==matrix[0].length-1)
		{
			str+=matrix[i][j];
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			paths.add(String.valueOf(arr));
			return paths;
		}
		if(i==matrix.length-1) return getAllPaths(paths,matrix, i, j+1,str+=matrix[i][j]);
		if(j==matrix[0].length-1) return getAllPaths(paths, matrix, i+1, j,str+=matrix[i][j]);
		if (i<matrix.length && j<matrix[0].length)
		{
			str+=matrix[i][j];
			getAllPaths(paths, matrix, i+1, j, str);
			getAllPaths(paths, matrix, i, j+1, str);
		}
		
		return paths;
	}
	

}
