package com.geeksForGeeks.algorithms;

public class LinearSearch
{

    public static void main(String[] args)
    {
        int[] arr = { 10, 20, 80, 30, 60, 50, 110, 100, 130, 170 };
        int numberToSearch = 110;
        int elementIndex = -1;

        for (int i = 0; i < arr.length; i++)
        {
            if (numberToSearch == arr[i])
                elementIndex = i;
        }
        System.out.println(elementIndex);

    }

}