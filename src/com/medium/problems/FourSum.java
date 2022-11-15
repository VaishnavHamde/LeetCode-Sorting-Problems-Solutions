// https://leetcode.com/problems/4sum/solutions/

/*
	Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
	
	0 <= a, b, c, d < n
	a, b, c, and d are distinct.
	nums[a] + nums[b] + nums[c] + nums[d] == target
	You may return the answer in any order.
	
	 
	
	Example 1:
	
	Input: nums = [1,0,-1,0,-2,2], target = 0
	Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
	Example 2:
	
	Input: nums = [2,2,2,2,2], target = 8
	Output: [[2,2,2,2]]
	 
	
	Constraints:
	
	1 <= nums.length <= 200
	-109 <= nums[i] <= 109
	-109 <= target <= 109
*/

package com.medium.problems;
import java.util.*;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4){
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            return lists;
        }
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                long temp = nums[i]+nums[j];

                int k = j+1;
                int l = nums.length-1;

                while(k < l){
                    if(nums[k]+nums[l]+temp > target){
                        l--;
                    }
                    else if(nums[k]+nums[l]+temp < target){
                        k++;
                    }
                    else{
                        lists.add(List.of(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                    }
                }
            }
        }

        if(lists.isEmpty()){
            List<List<Integer>> listss = new ArrayList<List<Integer>>();
            return listss;
        }

        List<List<Integer>> lists2 = new ArrayList<List<Integer>>();
        List<Integer> li = new ArrayList<Integer>();

        for(int i = 0; i < 4; i++){
            li.add(lists.get(0).get(i));
        }

        lists2.add(li);

        for(int i = 0; i < lists.size(); i++){
            boolean bool2 = true;
            for(int k = 0; k < lists2.size(); k++){
                boolean bool = true;
                for(int j = 0; j < 4; j++){
                    if((int)lists.get(i).get(j) != (int)lists2.get(k).get(j)){
                        bool = false;
                        break;
                    }
                }
                if(bool){
                    bool2 = false;
                    break;
                }
            }
            
            if(bool2){
                lists2.add(lists.get(i));
            }
        }

        return lists2;
    }
}
