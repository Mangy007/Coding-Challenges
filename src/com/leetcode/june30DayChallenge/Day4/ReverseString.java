package com.leetcode.june30DayChallenge.Day4;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 */

public class ReverseString {
    
    public static void main(String[] args) {

        // char[] strArr = {'h','e','l','l','o'};
        char[] strArr = {'H','a','n','n','a','h'};
        int n = strArr.length;

        for (int i = 0; i < n/2; i++) 
        {
            char temp = strArr[i];
            strArr[i] = strArr[n-1-i];
            strArr[n-1-i] = temp;
        }

        System.out.println(strArr);
    }
}