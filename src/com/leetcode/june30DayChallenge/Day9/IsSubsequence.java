package com.leetcode.june30DayChallenge.Day9;

public class IsSubsequence 
{
    public static void main(String[] args) 
    {
        String s = "aaaaaa";
        String t = "bbaaaa";

        IsSubsequence sub = new IsSubsequence();
        boolean result = sub.isSubsequence(s, t);
        System.out.println(result);
    }
    
    private boolean isSubsequence(String s, String t) {
       
        int prevMatchedIndex = -1;
        boolean flag = true;
        for(int i=0;i<s.length();i++) {
            flag = false;
            int j=prevMatchedIndex+1;
            while(j<t.length()){
                if(s.charAt(i)==t.charAt(j)) {
                    if(prevMatchedIndex>j && prevMatchedIndex!=-1) {
                        flag = false;
                    }
                    else {
                        prevMatchedIndex = j;
                        flag = true;
                    }
                    break;
                }
                j++;
            }
            if(!flag)
                break;
        }
        return flag;
    }
}