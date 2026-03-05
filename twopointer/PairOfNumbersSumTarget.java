package twopointer;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.



Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 */
public class PairOfNumbersSumTarget {

    public int[] towSubArraySum(int[] numbers, int target){
        int left =0;
        int right = numbers.length-1;

        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            } else if(sum>target){
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        PairOfNumbersSumTarget obj = new PairOfNumbersSumTarget();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 10;
        int[] ans = obj.towSubArraySum(arr, target);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
