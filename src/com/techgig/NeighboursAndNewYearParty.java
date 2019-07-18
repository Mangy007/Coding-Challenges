package com.techgig;

import java.util.*;
public class NeighboursAndNewYearParty 
{
	public static void main(String args[] ) throws Exception 
	{
		/*Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int i=0;i<t;i++)
		{
			int houses = scn.nextInt();
		    scn.nextLine();
		    String tickets = scn.nextLine();
		}*/
		int[] arr = {1,4,-6,3,2,8,9,10,12,11};
	    System.out.println(maxSum(arr));
    }
	
	public static int maxSum(int...elements) {
		int maxsofar,maxi2,maxi1;

	    maxi1 = maxsofar = elements[0];
	    maxi2 = 0;

	    for (int i = 1; i < elements.length; i++) {
	        maxsofar =  Math.max(maxi2 + elements[i], maxi1);
	        maxi2 =  maxi1;
	        maxi1 = maxsofar;
	    }
	    return maxsofar;
	}
	
	private static String getResult(String tickets)
	{
		String[] ticketStr = tickets.split(" ");
		int[] ticketNo = new int[ticketStr.length];
		for(int i=0;i<ticketNo.length;i++)
		{
			ticketNo[i]=Integer.parseInt(ticketStr[i]);
		}
		
	   
       	return null;
	}

	private static int FindMaxSum(String tickets) 
	{
		String[] ticketStr = tickets.split(" ");
		int[] arr = new int[ticketStr.length];
		int n = arr.length;
		for(int i=0;i<n;i++)
		{
			arr[i]=Integer.parseInt(ticketStr[i]);
		}
	       
		int incl = arr[0]; 
		int excl = 0; 
		int excl_new; 
		String inc="",ex="";
		int i; 

		for (i = 1; i < n; i++) 
		{ 
			/* current max excluding i */
			excl_new = (incl > excl) ? incl : excl; 

			/* current max including i */
			incl = excl + arr[i]; inc+=arr[i];
			excl = excl_new; ex+=excl;
		} 
		
		System.out.println("inc: "+inc);
		System.out.println("exc: "+ex);
		/* return max of incl and excl */
		return ((incl > excl) ? incl : excl); 
	} 

	private static String outputResult(String tickets)
	{
       String[] ticketStr = tickets.split(" ");
       int[] ticketNo = new int[ticketStr.length];
       for(int i=0;i<ticketNo.length;i++)
       {
           ticketNo[i]=Integer.parseInt(ticketStr[i]);
       }
       int max=-1000;
       String maxSum = "";
       for(int i=0;i<ticketNo.length;i++)
       {
            if(i+2<ticketNo.length)
            {
            	int j=i+2;
            	while (j<ticketNo.length)
				{
            		if(max<(ticketNo[i]+ticketNo[j])) 
            		{
            			max=ticketNo[i]+ticketNo[j];
            			j+=2;
            		}
                    if(max<ticketNo[i]) max=ticketNo[i];
                    if(max<ticketNo[j]) max=ticketNo[j];
				}
            }
            else if(max<ticketNo[i]) max=ticketNo[i];
       }
       List<String> result = new ArrayList<>();
       for(int i=0;i<ticketNo.length;i++)
       {
         if(i+2<ticketNo.length)
         {
            for(int j=i+2;j<ticketNo.length;j++)
            {
                if(max==(ticketNo[i]+ticketNo[j]))
                {
                  if(ticketNo[i]==0) result.add(ticketNo[j]+" ");
                  else if(ticketNo[j]==0) result.add(ticketNo[i]+" ");
                  else result.add(ticketNo[j]+" "+ticketNo[i]);
                }
                if(max==ticketNo[i]) result.add(ticketNo[i]+" ");
                if(max==ticketNo[j]) result.add(ticketNo[j]+" ");
            }
         }
         else if(max==ticketNo[i]) result.add(ticketNo[i]+" ");
       }
       String res = "-1000";
       for(int i=0;i<result.size();i++)
       {
           String temp=result.get(i).split(" ")[0];
           if(Integer.parseInt(res)<Integer.parseInt(temp)) res = temp;
       }
       for(int i=0;i<result.size();i++)
        {
            if(result.get(i).startsWith(res))
            {
                res=result.get(i).replaceAll(" ", "");
                break;
            }
        }
       return res;
   }
}
