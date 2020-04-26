package com.geeksForGeeks.algorithms.search;

public class LinearSearch
{
    // Time complexity: O(n)
    public static void main(String[] args)
    {
        int[] arr = { 10, 20, 80, 30, 60, 50, 110, 100, 130, 170 };
        int numberToSearch = 110;
        int elementIndex = linearSearch(arr, numberToSearch);
        System.out.println(elementIndex);

    }

    private static int linearSearch(int[] arr, int numberToSearch)
    {
        int elementIndex = -1;

        for (int i = 0; i < arr.length; i++)
        {
            if (numberToSearch == arr[i])
                elementIndex = i;
        }
        return elementIndex;
    }

}