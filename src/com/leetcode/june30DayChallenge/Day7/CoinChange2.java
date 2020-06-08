package com.leetcode.june30DayChallenge.Day7;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given coins of different denominations and a total amount of money. 
 * Write a function to compute the number of combinations that make up that amount. 
 * You may assume that you have infinite number of each kind of coin.
 * 
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 *  5=5
 *  5=2+2+1
 *  5=2+1+1+1
 *  5=1+1+1+1+1
 * 
 */
public class CoinChange2 {
    
    public static void main(String[] args) {
        int[] coins = {1,5,2,5,1};
        int amount = 5;
        
        Arrays.sort(coins);
        int j=0;

        for (int i = 0; i < coins.length-1; i++) {
            if(coins[i]!=coins[i+1]) {
                coins[j++]=coins[i];
            }
        }
        coins[j++] = coins[coins.length-1];

        int[] newCoins = Arrays.copyOf(coins, j);

        CoinChange2 cc = new CoinChange2();
        List<List<Integer>> result = cc.combinationSum(newCoins, amount);

        System.out.println(result.size());
    }

    private List<List<Integer>> combinationSum(int[] coins, int amount)
    {
        List<List<Integer>> results = new ArrayList<>();

        if(coins==null || coins.length==0)
            return results;
        
        List<Integer> combination = new ArrayList<>();
        combinationsEqualToAmount(results, combination, coins, amount, 0);

        return results;
    }

    private void combinationsEqualToAmount(List<List<Integer>> results, List<Integer> combination, int[] coins,
            int amount, int startIndex)
    {
        if(amount==0)
        {
            results.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < coins.length; i++) 
        {
            if(coins[i] > amount)
                break;

            combination.add(coins[i]);
            combinationsEqualToAmount(results, combination, coins, amount-coins[i], i);
            combination.remove(combination.size()-1);
        }
    }
}