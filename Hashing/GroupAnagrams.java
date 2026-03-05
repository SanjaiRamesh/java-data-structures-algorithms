package Hashing;

import java.util.*;
/*
Time complexity: O(n⋅m⋅logm)
Space complexity: O(n.m)

Given an array of strings strs, group the anagrams together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

 */
public class GroupAnagrams {

    /*
    Time complexity: O(n⋅m⋅logm)
Space complexity: O(n.m)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<String>());
            }

            groups.get(key).add(s);
        }

        return new ArrayList(groups.values());
    }

    /*
    Time complexity: O(n⋅m) --> because avoiding sorting
Space complexity: O(n.m)
     */
    public List<List<String>> groupAnagrams1(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];

            for (char c : s.toCharArray())
                count[c - 'a']++;

            String key = Arrays.toString(count);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<Long,List<String>> map=new HashMap<>();
        for(String str:strs){
            long key=getUniqueKey(str);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
    public Long getUniqueKey(String str){
        int[] primes={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101,103};
        long mul=1;
        for(char ch:str.toCharArray()){
            mul=mul*primes[ch-'a'+1];
        }
        return mul;
    }
}
