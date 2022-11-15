// https://leetcode.com/problems/sort-colors/description/

/*
	Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, 
	with the colors in the order red, white, and blue.
	
	We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
	
	You must solve this problem without using the library's sort function.
	
	 
	
	Example 1:
	
	Input: nums = [2,0,2,1,1,0]
	Output: [0,0,1,1,2,2]
	Example 2:
	
	Input: nums = [2,0,1]
	Output: [0,1,2]
	 
	
	Constraints:
	
	n == nums.length
	1 <= n <= 300
	nums[i] is either 0, 1, or 2.
 
*/

package com.medium.problems;

public class Sort_Colors {
	public void sortColors(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
}
