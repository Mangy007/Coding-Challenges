package com.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tournament
{
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		int testCases = Integer.parseInt(scn.nextLine());
		List<String> aTeam = new ArrayList<>();
		List<String> bTeam = new ArrayList<>();
		for (int i = 0; i < testCases; i++)
		{
			String rounds = scn.nextLine();
			String teamA = scn.nextLine();
			String teamB = scn.nextLine();
			aTeam.add(teamA);
			bTeam.add(teamB);
		}
		scn.close();
		for (int i = 0; i < aTeam.size(); i++)
		{
			System.out.println(getMaximumDraws(aTeam.get(i),bTeam.get(i)));
		}
	}

	private static int getMaximumDraws(String teamA, String teamB)
	{
		int countDraw = 0;
		for (int i = 0; i < teamA.length(); i++)
		{
	    	if (!teamB.replaceFirst(teamA.charAt(i)+"", "").equals(teamB))
				countDraw++;
		}
	    
		return countDraw;
	}

}
