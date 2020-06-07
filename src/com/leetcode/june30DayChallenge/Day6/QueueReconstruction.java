package com.leetcode.june30DayChallenge.Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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