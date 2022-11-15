// https://leetcode.com/problems/3sum/description/

/*
	Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
	and nums[i] + nums[j] + nums[k] == 0.
	
	Notice that the solution set must not contain duplicate triplets.
	
	 
	Example 1:
	
	Input: nums = [-1,0,1,2,-1,-4]
	Output: [[-1,-1,2],[-1,0,1]]
	Explanation: 
	nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
	nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
	nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
	The distinct triplets are [-1,0,1] and [-1,-1,2].
	Notice that the order of the output and the order of the triplets does not matter.
	
	Example 2:
	
	Input: nums = [0,1,1]
	Output: []
	Explanation: The only possible triplet does not sum up to 0.
	
	Example 3:
	
	Input: nums = [0,0,0]
	Output: [[0,0,0]]
	Explanation: The only possible triplet sums up to 0.
	 
	
	Constraints:
	
	3 <= nums.length <= 3000
	-105 <= nums[i] <= 105
*/

package com.medium.problems;
import java.util.*;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        boolean bool4 = true;
        for(int i = 0; i < nums.length-2; i++){
            while(i < nums.length-2 && i > 0 && nums[i] == nums[i-1]){
                i++;
            }
            if(nums[i] > 0){
               break;
           }
           if(!bool4)
               break;
           if(nums[i] == 0)
               bool4 = false;
           
           int j = i+1;
           int k = nums.length-1;
           while(j < k){
               boolean bool1 = false;
               boolean bool2 = false;
               boolean bool3 = false;
               boolean bool5 = false;
               if(nums[j]+nums[k] > -1*nums[i]){
                   while(j < k && k < nums.length-1 && nums[k] == nums[k+1]){
                       k--;
                       bool1 = true;    
                   }
                   if(!bool1)
                       k--;
               }
               else if(nums[j]+nums[k] < -1*nums[i]){
                   while(j < k && j > i+1 && nums[j] == nums[j-1]){
                       j++;
                       bool2 = true;
                   }
                   if(!bool2)
                       j++;
               }
               else{
                   lists.add(List.of(nums[i], nums[j], nums[k]));
                   j++;
                   k--;
                   while(j < k && j > i+1 && nums[j] == nums[j-1]){
                       j++;
                       bool3 = true;
                   }
                   while(j < k && k < nums.length-1 && nums[k] == nums[k+1]){
                       k--;
                       bool5 = true;    
                   }
               }
           }
        }

        return lists;
   }
}
