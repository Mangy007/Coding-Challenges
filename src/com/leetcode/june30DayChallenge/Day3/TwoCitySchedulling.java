package com.leetcode.june30DayChallenge.Day3;

import java.util.Arrays;

/** 
 * There are 2N people a company is planning to interview. 
 * The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * 
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
*/
public class TwoCitySchedulling {
    public static void main(String[] args) {
        int[][] cityCostsForPerson = {{10,20},{30,200},{400,50},{5,20}};
        int n = cityCostsForPerson.length/2;
        int[] refund = new int[cityCostsForPerson.length];
        int minCost = 0;

        for (int i = 0; i < cityCostsForPerson.length; i++) {
            refund[i] = cityCostsForPerson[i][1]-cityCostsForPerson[i][0];
            minCost+=cityCostsForPerson[i][0];
        }
        Arrays.sort(refund);

        for (int i = 0; i < n; i++) {
            minCost+=refund[i];
        }

        System.out.println(minCost);
    }
}