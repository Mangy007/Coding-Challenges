package com.geeksForGeeks.algorithms.search;

import java.util.Arrays;

public class BinarySearch
{
    // Time complexity: O(logn)
    public static void main(String[] args)
    {
        int[] arr = { 10, 20, 80, 30, 60, 50, 110, 100, 130, 170 };
        int numberToSearch = 110;
        Arrays.sort(arr);
        int elementIndex = binarySearch(arr, 0, arr.length, numberToSearch);
        System.out.println(elementIndex);
    }

    private static int binarySearch(int[] arr, int start, int end, int numberToSearch)
    {
        if (start < end)
        {
            int mid = (start + end - 1) / 2;
            if (arr[mid] == numberToSearch)
                return mid;
            if (arr[mid] > numberToSearch)
                return binarySearch(arr, start, mid - 1, numberToSearch);
            else
                return binarySearch(arr, mid + 1, end, numberToSearch);
        }
        return -1;
    }
}