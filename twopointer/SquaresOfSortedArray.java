package twopointer;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 */
public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left =0;
        int right = nums.length-1;
        int k = nums.length-1;

        while(left<=right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];

            if(leftSquare>rightSquare){
                ans[k] = leftSquare;
                left++;
            } else {
                ans[k] = rightSquare;
                right--;
            }
            k--;
        }
        return ans;
    }
    public static void main(String[] args) {
        SquaresOfSortedArray obj = new SquaresOfSortedArray();
        int[] nums = {-4,-1,0,3,10};
        int[] ans = obj.sortedSquares(nums);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}
