package slidingwindow;

/*
Given an array of positive integers nums and an integer k, return the number of subarrays where the product of all the elements in the subarray is strictly less than k.

For example, given the input nums = [10, 5, 2, 6], k = 100, the answer is 8. The subarrays with products less than k are:

[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans =0;
        int product = 1;
        int left=0,right=0;
        while(right<nums.length){
            product *= nums[right];

            while(product >= k){
                product /= nums[left];
                left++;
            }

            ans += right-left+1;
            right++;

        }
        return ans;
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanK obj = new NumSubarrayProductLessThanK();
        System.out.println(obj.numSubarrayProductLessThanK(new int[]{1,2,3,4,5,6,7,8,9}, 10));
        System.out.println(obj.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));

    }
}
