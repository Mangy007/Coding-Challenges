package com.geeksForGeeks.algorithms.search;

import java.util.Arrays;

public class JumpSearch
{
    // Time complexity: between O(n) to O(logn)
    public static void main(String[] args)
    {
        int[] arr = { 10, 20, 80, 30, 60, 50, 110, 100, 130, 170 };
        int numberToSearch = 5;
        int jumpSize = (int) Math.round(Math.sqrt(arr.length));
        Arrays.sort(arr);
        int elementIndex = jumpSearch(arr, 0, arr.length, jumpSize, numberToSearch);
        System.out.println(elementIndex);
    }

    private static int jumpSearch(int[] arr, int start, int end, int jumpSize, int numberToSearch)
    {
        if (start + jumpSize < end)
        {
            int jumpRange = start + jumpSize;
            if (arr[jumpRange] >= numberToSearch)
                return linearSearch(arr, start, jumpRange, numberToSearch);
            else
                return jumpSearch(arr, start + jumpSize, end, jumpSize, numberToSearch);
        }
        return -1;
    }

    private static int linearSearch(int[] arr, int start, int end, int numberToSearch)
    {
        int elementIndex = -1;

        for (int i = start; i <= end; i++)
        {
            if (numberToSearch == arr[i])
                elementIndex = i;
        }
        return elementIndex;
    }
}