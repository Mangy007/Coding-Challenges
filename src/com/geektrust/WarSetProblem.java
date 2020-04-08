package com.geektrust;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarSetProblem
{
	public static final List<Integer> LENGABURU_TROOPS_SIZE = new ArrayList<Integer>()
	{
		{
			add(100);
			add(50);
			add(10);
			add(5);
		}
	};
	public static final List<Integer> FALICORNIA_TROOPS_SIZE = new ArrayList<Integer>()
	{
		{
			add(300);
			add(200);
			add(40);
			add(20);
		}
	};

	public static void main(String[] args) throws Exception
	{
		Scanner scn = new Scanner(System.in);
		String falicorniaTroops = scn.nextLine();
		List<Integer> falicorniaTroopsQuantity = getFalicorniaAttackingTroopsDetails(falicorniaTroops);

		if (isAttackingTroopsValid(falicorniaTroopsQuantity))
		{
			List<Integer> troopsRequired = getTroopsRequiredToWin(falicorniaTroopsQuantity);
			List<Integer> lengaburuTroopsLeftForBorrow = getExtraTroopsLeftAfterDeployed(troopsRequired);
			String warStats = getWarStats(troopsRequired, lengaburuTroopsLeftForBorrow);
			System.out.println(warStats);
		}
		else
		{
			System.out.println("Falicornia can't deploy all their troops");
		}
	}

	private static String getWarStats(List<Integer> troopsRequired, List<Integer> lengaburuTroopsLeftForBorrow)
	{
		String warStatus = "WINS";
		for (int i = 0; i < troopsRequired.size(); i++)
		{
			int troopCategoryRequired = troopsRequired.get(i) - LENGABURU_TROOPS_SIZE.get(i);
			if (troopCategoryRequired <= 0)
				continue;
			else
			{
				troopsRequired.set(i, LENGABURU_TROOPS_SIZE.get(i));
				if (i > 0 && i < troopsRequired.size() - 1)
				{
					int required = Math.abs(troopCategoryRequired);
					int prevTroopCategoryLeft = lengaburuTroopsLeftForBorrow.get(i - 1);
					int nextTroopCategoryLeft = lengaburuTroopsLeftForBorrow.get(i + 1);
					int troopsToBorrow = getPrevTroopsToBeBorrowed(required, prevTroopCategoryLeft);
					troopsRequired.set(i - 1, troopsRequired.get(i - 1) + troopsToBorrow);
					required -= troopsToBorrow / 2;
					troopsToBorrow = getNextTroopsToBeBorrowed(required, nextTroopCategoryLeft);
					troopsRequired.set(i + 1, troopsRequired.get(i + 1) + troopsToBorrow);
					required -= troopsToBorrow * 2;
					if (required > 0)
						warStatus = "LOSES";
				}
				else if (i == 0)
				{
					int nextTroopCategoryLeft = lengaburuTroopsLeftForBorrow.get(i + 1);
					int required = Math.abs(troopCategoryRequired);
					int troopsToBorrow = getNextTroopsToBeBorrowed(required, nextTroopCategoryLeft);
					required -= troopsToBorrow * 2;
					if (required > 0)
						warStatus = "LOSES";
					troopsRequired.set(i + 1, troopsRequired.get(i + 1) + troopsToBorrow);
				}
				else if (i == troopsRequired.size() - 1)
				{
					int prevTroopCategoryLeft = lengaburuTroopsLeftForBorrow.get(i - 1);
					int required = Math.abs(troopCategoryRequired);
					int troopsToBorrow = getPrevTroopsToBeBorrowed(required, prevTroopCategoryLeft);
					required -= troopsToBorrow / 2;
					if (required > 0)
						warStatus = "LOSES";
					troopsRequired.set(i - 1, troopsRequired.get(i - 1) + troopsToBorrow);
				}
			}
		}
		return warStatus + " " + troopsRequired.get(0) + "H " + troopsRequired.get(1) + "E " + troopsRequired.get(2)
				+ "AT " + troopsRequired.get(3) + "SG ";
	}

	private static int getNextTroopsToBeBorrowed(int required, int nextTroopCategoryLeft)
	{
		if (required <= 0)
			return 0;

		if (required % 2 == 0)
		{
			if (nextTroopCategoryLeft < required / 2)
				return nextTroopCategoryLeft;
			else
				return required / 2;
		}
		else
		{
			if (nextTroopCategoryLeft < (required + 1) / 2)
				return nextTroopCategoryLeft;
			else
				return (required + 1) / 2;
		}
	}

	private static int getPrevTroopsToBeBorrowed(int required, int prevTroopCategoryLeft)
	{
		if (required <= 0)
			return 0;

		if (prevTroopCategoryLeft < required * 2)
			return prevTroopCategoryLeft;
		else
			return required * 2;
	}

	private static List<Integer> getExtraTroopsLeftAfterDeployed(List<Integer> troopsRequired)
	{
		List<Integer> lengaburuExtraTroopsLeft = new ArrayList<>();
		for (int i = 0; i < troopsRequired.size(); i++)
		{
			int difference = LENGABURU_TROOPS_SIZE.get(i) - troopsRequired.get(i);
			if (difference > 0)
				lengaburuExtraTroopsLeft.add(difference);
			else
				lengaburuExtraTroopsLeft.add(0);
		}
		return lengaburuExtraTroopsLeft;
	}

	private static List<Integer> getTroopsRequiredToWin(List<Integer> falicorniaTroopsQuantity)
	{
		List<Integer> troopsRequired = new ArrayList<>();
		for (int i = 0; i < falicorniaTroopsQuantity.size(); i++)
		{
			if (falicorniaTroopsQuantity.get(i) % 2 == 0)
				troopsRequired.add(falicorniaTroopsQuantity.get(i) / 2);
			else
				troopsRequired.add(falicorniaTroopsQuantity.get(i) / 2 + 1);
		}
		return troopsRequired;
	}

	private static List<Integer> getFalicorniaAttackingTroopsDetails(String falicorniaTroops)
	{
		List<Integer> troops = new ArrayList<>();
		troops.add(Integer.parseInt(falicorniaTroops.split(" ")[1].split("H")[0]));
		troops.add(Integer.parseInt(falicorniaTroops.split(" ")[2].split("E")[0]));
		troops.add(Integer.parseInt(falicorniaTroops.split(" ")[3].split("AT")[0]));
		troops.add(Integer.parseInt(falicorniaTroops.split(" ")[4].split("SG")[0]));
		return troops;
	}

	private static boolean isAttackingTroopsValid(List<Integer> falicorniaTroopsQuantity)
	{
		int deployedTroopsSum = falicorniaTroopsQuantity.stream().mapToInt(Integer::intValue).sum();
		int troopsSizeSum = FALICORNIA_TROOPS_SIZE.stream().mapToInt(Integer::intValue).sum();
		if (falicorniaTroopsQuantity.get(0) > FALICORNIA_TROOPS_SIZE.get(0)
				|| falicorniaTroopsQuantity.get(1) > FALICORNIA_TROOPS_SIZE.get(1)
				|| falicorniaTroopsQuantity.get(2) > FALICORNIA_TROOPS_SIZE.get(2)
				|| falicorniaTroopsQuantity.get(3) > FALICORNIA_TROOPS_SIZE.get(3)
				|| deployedTroopsSum >= troopsSizeSum)
			return false;
		else
			return true;
	}
}