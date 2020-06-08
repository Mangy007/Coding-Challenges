package com.leetcode.june30DayChallenge.Day8;

public class PowerOfTwo 
{
    public static void main(String[] args) {
        
        int n = 24;
        int i=0;

        while(i>=0) 
        {
            int val = (int) Math.pow(2, i);
            if(val==n)
            {
                System.out.println("True");
                return;
            }
            if(val>n)
            {
                System.out.println("False");
                return;
            }
            i++;
        }
    }
}