package slidingwindow;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */
public class LongestOnes {

    public int longestOnes(int[] nums, int k) {
        int left=0, right =0;
        int count=0, ans=Integer.MIN_VALUE;

        while(right<nums.length){

            if(nums[right] == 0){
                count++;
            }

            while(count > k) {
                if(nums[left] == 0) {
                    count--;
                }
                left++;
            }

            ans = Math.max(ans, right-left+1);

            right++;
        }

        return ans;
    }

    public  static void main(String[] args) {
        LongestOnes ls = new LongestOnes();
        System.out.println(ls.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
}
