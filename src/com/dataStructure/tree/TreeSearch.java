package com.dataStructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeSearch
{
	@SuppressWarnings("serial")
	private static Map<String, List<String>> similarPrepositionList = new HashMap<String, List<String>>() {{
		
		put("under", new ArrayList<String>(){{ add("below"); add("inside"); add("by"); }});
		put("in", new ArrayList<String>(){{ add("into"); add("by"); }});
	}};
	
	public static void main(String[] args)
	{
		if (process("in", "on")) System.out.println("contains 1"); else System.out.println("not contains 1");
		if (process("in", "by")) System.out.println("contains 2"); else System.out.println("not contains 2");
		if (process("by", "under")) System.out.println("contains 3"); else System.out.println("not contains 3");
		if (process("under", "in")) System.out.println("contains 4"); else System.out.println("not contains 4");
		if (process("under", "by")) System.out.println("contains 5"); else System.out.println("not contains 5");

	}
	
	
	public static boolean process(String prep1, String prep2)
	{
		for (String prepKey : similarPrepositionList.keySet())
		{
			if ((prepKey.equals(prep1) || prepKey.equals(prep2) || similarPrepositionList.get(prepKey).contains(prep1)) 
					&& (similarPrepositionList.get(prepKey).contains(prep2) || similarPrepositionList.get(prepKey).contains(prep1)))
			{
				return true;
			}
		}
		return false;
	}

}
