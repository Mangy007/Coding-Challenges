package com.leetcode.june30DayChallenge.Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. 
 * Each person is described by a pair of integers (h, k), 
 * where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. 
 * Write an algorithm to reconstruct the queue.
 * 
 * Note:
 *  The number of people is less than 1,100.
 * 
 *  Input:
 *      [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *  Output:
 *      [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

public class QueueReconstruction {
    
    public static void main(String[] args) {
        
        int[][] peopleHeights = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        Arrays.sort(peopleHeights, (p1,p2)-> p1[0]==p2[0]?p1[1]-p2[1]:p2[0]-p1[0]);

        List<int[]> reconstructedQueue = new ArrayList<>();

        for (int i = 0; i < peopleHeights.length; i++) {
            reconstructedQueue.add(peopleHeights[i][1], peopleHeights[i]);
        }
        for (int[] person : reconstructedQueue) {
            System.out.println(Arrays.toString(person));
        }
    }
}