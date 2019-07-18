package com.geektrust;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.util.Scanner;

public class WarSetProblem1
{
	public static final Map<String,Integer> LENGABURU_TROOPS_DETAILS = new LinkedHashMap<String,Integer>(){{
		put("horses", 100);
		put("elephants", 50);
		put("armouredTanks", 10);
		put("slingGuns", 5);
	}};
	public static final Map<String,Integer> FALICORNIA_TROOPS_DETAILS = new LinkedHashMap<String,Integer>(){{
		put("horses", 300);
		put("elephants", 200);
		put("armouredTanks", 40);
		put("slingGuns", 20);
	}};
	public static final List<String> TROOPS_ORDER = new LinkedList<String>(){{
		add("horses");
		add("elephants");
		add("armouredTanks");
		add("slingGuns");
	}};
	
	public static void main(String[] args)
	{
		Map<String,Integer> falicorniaAttackTroopsDetails = getFalicorniaAttackingTroopsDetails();;
		Map<String,Integer> requiredLengaburuTroopsDetails = new LinkedHashMap<>();
		
		if (isAttackingTroopsValid(falicorniaAttackTroopsDetails)) 
		{
			for (String troopType : falicorniaAttackTroopsDetails.keySet()) 
			{
				int falocorniaAttackTroopSize = falicorniaAttackTroopsDetails.get(troopType);
				if (falocorniaAttackTroopSize%2==0)
					requiredLengaburuTroopsDetails.put(troopType, falocorniaAttackTroopSize/2);
				else
					requiredLengaburuTroopsDetails.put(troopType, falocorniaAttackTroopSize/2 + 1);
			}
			for (String troopType : requiredLengaburuTroopsDetails.keySet())
			{
				if (requiredLengaburuTroopsDetails.get(troopType) > LENGABURU_TROOPS_DETAILS.get(troopType))
				{
					int requiredTroop = requiredLengaburuTroopsDetails.get(troopType)-LENGABURU_TROOPS_DETAILS.get(troopType);
					requiredLengaburuTroopsDetails.put(troopType, LENGABURU_TROOPS_DETAILS.get(troopType));
					requiredLengaburuTroopsDetails = borrowTroops(troopType, requiredTroop, requiredLengaburuTroopsDetails);
					
				}
			}
			int falicorniaTroopSize = 0;
			int expectedLengaburuTroopSize = 0;
			for (String troop : falicorniaAttackTroopsDetails.keySet())
			{
				falicorniaTroopSize+=falicorniaAttackTroopsDetails.get(troop);
				expectedLengaburuTroopSize+=requiredLengaburuTroopsDetails.get(troop);
			}
			if(falicorniaTroopSize/2>expectedLengaburuTroopSize)
				System.out.println("LOSES");
			else
				System.out.println("WINS");
		}
		else 
		{
			System.out.println("Falicornia can't deploy all their troops");
		}
	}

	private static Map<String, Integer> borrowTroops(String iTroopType, int requiredTroop, Map<String, Integer> expectedLengaburuTroopsDetails)
	{
		int i=0;
		for (String troopType : expectedLengaburuTroopsDetails.keySet())
		{
			if (troopType.equals(iTroopType))
			{
				if (i==0 && requiredTroop>0)
				{
					int troopPresent = LENGABURU_TROOPS_DETAILS.get(TROOPS_ORDER.get(i+1))-expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i+1));
					manageTroopFromHigherRangeTroops(requiredTroop, expectedLengaburuTroopsDetails, i, troopPresent);
				}
				else if (i==expectedLengaburuTroopsDetails.size()-1 && requiredTroop>0)
				{
					int troopPresent = LENGABURU_TROOPS_DETAILS.get(TROOPS_ORDER.get(i-1))-expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i-1));
					manageTroopFromLowerRangeTroops(requiredTroop, expectedLengaburuTroopsDetails, i, troopPresent);
				}
				else 
				{
					int lowerTroopPresent = LENGABURU_TROOPS_DETAILS.get(TROOPS_ORDER.get(i-1))-expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i-1));
					int higherTroopPresent = LENGABURU_TROOPS_DETAILS.get(TROOPS_ORDER.get(i+1))-expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i+1));
					if (requiredTroop>0)
						requiredTroop = manageTroopFromLowerRangeTroops(requiredTroop, expectedLengaburuTroopsDetails, i, lowerTroopPresent);
					if (requiredTroop>0)
						requiredTroop = manageTroopFromHigherRangeTroops(requiredTroop, expectedLengaburuTroopsDetails, i, higherTroopPresent);
				}
			}
			i++;
		}
		
		return expectedLengaburuTroopsDetails;
	}

	private static int manageTroopFromHigherRangeTroops(int requiredTroop,
			Map<String, Integer> expectedLengaburuTroopsDetails, int i, int troopPresent)
	{
		if (expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i+1))!=LENGABURU_TROOPS_DETAILS.get(TROOPS_ORDER.get(i+1)))
		{
			if (requiredTroop%2==0)
			{
				if(troopPresent<requiredTroop/2)
				{
					expectedLengaburuTroopsDetails
						.put(TROOPS_ORDER.get(i+1), expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i+1))+troopPresent);
					requiredTroop=requiredTroop-troopPresent*2;
				}
				else 
				{
					expectedLengaburuTroopsDetails
						.put(TROOPS_ORDER.get(i+1), expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i+1))+requiredTroop/2);
					requiredTroop=0;
				}
			}
			else
			{
				if(troopPresent<((requiredTroop/2)+1))
				{
					expectedLengaburuTroopsDetails
						.put(TROOPS_ORDER.get(i+1), expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i+1))+troopPresent);
					requiredTroop=requiredTroop-troopPresent*2;
				}
				else 
				{
					expectedLengaburuTroopsDetails
						.put(TROOPS_ORDER.get(i+1), expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i+1))+requiredTroop/2 + 1);
					requiredTroop=0;
				}
			}
		}
		
		return requiredTroop;
	}

	private static int manageTroopFromLowerRangeTroops(int requiredTroop,
			Map<String, Integer> expectedLengaburuTroopsDetails, int i, int troopPresent)
	{
		if(expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i-1))!=LENGABURU_TROOPS_DETAILS.get(TROOPS_ORDER.get(i-1)))
		{
			if(troopPresent/2<requiredTroop)
			{
				expectedLengaburuTroopsDetails
					.put(TROOPS_ORDER.get(i-1), expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i-1))+troopPresent);
				requiredTroop=requiredTroop-troopPresent/2;
			}
			else 
			{
				expectedLengaburuTroopsDetails
					.put(TROOPS_ORDER.get(i-1), expectedLengaburuTroopsDetails.get(TROOPS_ORDER.get(i-1))+requiredTroop*2);
				requiredTroop=0;
			}
		}
		
		return requiredTroop;
	}

	private static boolean isAttackingTroopsValid(Map<String, Integer> falicorniaAttackTroopsDetails)
	{
		for (String troopType : FALICORNIA_TROOPS_DETAILS.keySet()) 
		{
			if (falicorniaAttackTroopsDetails.containsKey(troopType) 
					&& falicorniaAttackTroopsDetails.get(troopType)>=FALICORNIA_TROOPS_DETAILS.get(troopType)) 
				return false;
		}
		return true;
	}

	private static Map<String, Integer> getFalicorniaAttackingTroopsDetails() 
	{
		Map<String,Integer> falicorniaAttackTroops = new LinkedHashMap<>();
		Scanner scn = new Scanner(System.in);
		System.out.println("Falicornia attacks with ");
		updateFaliconiaAttackingTroops(falicorniaAttackTroops,scn, "horses");
		updateFaliconiaAttackingTroops(falicorniaAttackTroops,scn, "elephants");
		updateFaliconiaAttackingTroops(falicorniaAttackTroops,scn, "armouredTanks");
		updateFaliconiaAttackingTroops(falicorniaAttackTroops,scn, "slingGuns");
		
		return falicorniaAttackTroops;
	}

	private static void updateFaliconiaAttackingTroops(Map<String, Integer> falicorniaAttackTroops,Scanner scn, String troopType) 
	{
		System.out.println(troopType+" : ");
		falicorniaAttackTroops.put(troopType, scn.nextInt());
	}
	
}
