package com.leetcode.june30DayChallenge.Day5;

import java.util.Arrays;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i, 
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 * 
 * Note:
 *  1 <= w.length <= 10000
 *  1 <= w[i] <= 10^5
 *  pickIndex will be called at most 10000 times.
 */

public class RandomPick
{
    
    private double[] probabilities;
    
    public RandomPick(int[] w)
    {
        double sum = 0;
        this.probabilities = new double[w.length];
        for(int weight : w)
            sum += weight;
        for(int i = 0; i < w.length; i++){
            w[i] += (i == 0) ? 0 : w[i - 1];
            probabilities[i] = w[i]/sum; 
        }
    }
     
    public int pickIndex() {
        return Math.abs(Arrays.binarySearch(this.probabilities, Math.random())) - 1;
    }

    public static void main(String[] args) {
        
        int[] w = {1};
        RandomPick obj = new RandomPick(w);
        int param_1 = obj.pickIndex();
        System.out.println(param_1);
    }
}