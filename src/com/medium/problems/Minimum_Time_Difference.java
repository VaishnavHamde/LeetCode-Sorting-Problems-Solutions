// https://leetcode.com/problems/minimum-time-difference/description/

/*
	Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
	 
	
	Example 1:
	
	Input: timePoints = ["23:59","00:00"]
	Output: 1
	
	Example 2:
	
	Input: timePoints = ["00:00","23:59","00:00"]
	Output: 0
	 
	
	Constraints:
	
	2 <= timePoints.length <= 2 * 104
	timePoints[i] is in the format "HH:MM".
*/

package com.medium.problems;
import java.util.*;

public class Minimum_Time_Difference {
	public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int[] mins = new int[timePoints.size()];
        int j = 0;
        int minDiff = Integer.MAX_VALUE;

        for(String s : timePoints){
            mins[j] = ((s.charAt(0) - '0')*10 + s.charAt(1) - '0')*60 + (s.charAt(3) - '0')*10 + s.charAt(4) - '0';
            j++;
        }

        for(int i = 1; i < mins.length; i++)
            minDiff = Math.min(minDiff, Math.min(Math.abs(mins[i] - mins[i-1]), Math.abs(mins[i] - mins[i-1] - 1440)));

        minDiff = Math.min(minDiff, Math.min(Math.abs(mins[mins.length-1] - mins[0]), Math.abs(mins[mins.length-1] - mins[0] - 1440)));

        return minDiff;
    }
}
