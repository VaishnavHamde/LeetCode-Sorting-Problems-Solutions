// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/

/*
	Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by 
	deleting some of the given string characters. If there is more than one possible result, 
	return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
	 
	
	Example 1:
	
	Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
	Output: "apple

	Example 2:
	
	Input: s = "abpcplea", dictionary = ["a","b","c"]
	Output: "a"
	 
	
	Constraints:
	
	1 <= s.length <= 1000
	1 <= dictionary.length <= 1000
	1 <= dictionary[i].length <= 1000
	s and dictionary[i] consist of lowercase English letters.
*/

package com.medium.problems;
import java.util.*;

public class Longest_Word_in_Dictionary_through_Deleting {
	 public String findLongestWord(String s, List<String> dictionary) {
	        String res = "";
	        Collections.sort(dictionary);
	        
	        for(String str : dictionary){
	            if(res.length() >= str.length())
	                continue;

	            int i = 0;
	            int j = 0;
	            int count = 0;
	            
	            while(i < s.length() && j < str.length()){
	                if(s.charAt(i) == str.charAt(j)){
	                    count++;
	                    i++;
	                    j++;
	                }
	                else
	                    i++;
	            }
	            if(count == str.length())
	                res = str;
	        }

	        return res;
	    }
}
