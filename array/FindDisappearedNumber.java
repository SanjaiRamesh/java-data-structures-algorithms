package array;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 */
public class FindDisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int count[]=new int[nums.length+1];
        for(int n:nums){
            count[n]++;
        }
        List<Integer> res= new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if(count[i]==0){
                res.add(i);
            }
        }
        return res;

    }
}
