// https://leetcode.com/problems/3sum-closest/

/*
	Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
	
	Return the sum of the three integers.
	
	You may assume that each input would have exactly one solution.
	
	 
	
	Example 1:
	
	Input: nums = [-1,2,1,-4], target = 1
	Output: 2
	Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	Example 2:
	
	Input: nums = [0,0,0], target = 1
	Output: 0
	Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
	 
	
	Constraints:
	
	3 <= nums.length <= 500
	-1000 <= nums[i] <= 1000
	-104 <= target <= 104
*/

package com.medium.problems;
import java.util.*;

public class ThreeSum_Closest {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int res2 = 0;
        for(int i = 0; i < nums.length-2; i++){
           
           int j = i+1;
           int k = nums.length-1;
           while(j < k){
               if(nums[i]+nums[j]+nums[k] > target){
                   int temp = nums[i]+nums[j]+nums[k];
                   res = Math.min(res, Math.abs(nums[i]+nums[j]+nums[k] - target));
                   if(res == Math.abs(nums[i]+nums[j]+nums[k] - target))
                       res2 = temp;
                   k--;
               }
               else if(nums[i]+nums[j]+nums[k] < target){
                   int temp = nums[i]+nums[j]+nums[k];
                   res = Math.min(res, Math.abs(nums[i]+nums[j]+nums[k] - target));
                   if(res == Math.abs(nums[i]+nums[j]+nums[k] - target))
                       res2 = temp;
                   j++;
               }
               else{
                   int temp = nums[i]+nums[j]+nums[k];
                   res = Math.min(res, Math.abs(nums[i]+nums[j]+nums[k] - target));
                   if(res == nums[i]+nums[j]+nums[k] - target)
                       res2 = temp;
                   j++;
               }
           }
        }

        return res2;
   }
}
