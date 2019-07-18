package com.testCodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1
{

	public static void main(String[] args)
	{
		long weight = 25;
		Map<String,Integer> weightsDict = getWeights();
        String result = "";
        while(weight!=0)
        {
        	String output = getMinimum(weight,weightsDict);
            weight = Long.parseLong(output.split(" ")[0]);
            result += output.split(" ")[1];
        }
        char[] chars = result.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        System.out.println(sorted);
	}
	
	private static String getMinimum(long weight, Map<String, Integer> weightsDict)
	{
		String result = "";
		long min = weight;
		for (String key : weightsDict.keySet())
		{
			if((weight-weightsDict.get(key))>=0 && min>=(weight-weightsDict.get(key)))
			{
				min = weight-weightsDict.get(key);
				result=key;
			}
		}
		return min+" "+result;
	}

	public static Map<String,Integer> getWeights()
    {
        Map<String,Integer> dict = new HashMap<>();
        int count=1;
        for(char i='A'; i<='Z'; i++)
        {
            if(i=='A')
                dict.put(i+"",1);
            else
            {
                char character = (char) (i-1);
                int prevWeight = dict.get(character+"");
                int currWeight = (count*prevWeight)+prevWeight;
                dict.put(i+"",currWeight);
            }
            count++;
        }
        return dict;
    }

}
