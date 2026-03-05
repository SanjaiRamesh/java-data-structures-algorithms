package Hashing;


import java.util.*;

/*
You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions. If no such pair of indices exists, return -1.



Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
Example 2:

Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 */
public class MaxSumPairWithEqualSumofDigits {

    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> dic = new HashMap<>();
        for (int num: nums) {
            int digitSum = getDigitSum(num);
            if (!dic.containsKey(digitSum)) {
                dic.put(digitSum, new ArrayList<>());
            }

            dic.get(digitSum).add(num);
        }

        int ans = -1;
        for (int key: dic.keySet()) {
            List<Integer> curr = dic.get(key);
            if (curr.size() > 1) {
                Collections.sort(curr, Collections.reverseOrder());
                ans = Math.max(ans, curr.get(0) + curr.get(1));
            }
        }

        return ans;

    }

    public int getDigitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }

        return digitSum;
    }


    public int maximumSum1(int[] nums) {
        Map<Integer, Integer> dic = new HashMap<>();
        int ans = -1;
        for (int num: nums) {
            int digitSum = getDigitSum(num);
            if (dic.containsKey(digitSum)) {
                ans = Math.max(ans, num + dic.get(digitSum));
            }

            dic.put(digitSum, Math.max(dic.getOrDefault(digitSum, 0), num));
        }

        return ans;
    }

    static void main(String[] args) {
        MaxSumPairWithEqualSumofDigits obj = new MaxSumPairWithEqualSumofDigits();
        System.out.println(obj.maximumSum(new int[]{18,43,36,13,7}));
        System.out.println(obj.maximumSum1(new int[]{18,43,36,13,7}));
    }
}
