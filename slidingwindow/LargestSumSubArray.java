package slidingwindow;


/*
Given an integer array nums and an integer k,
find the sum of the subarray with the largest sum whose length is k.
 */
public class LargestSumSubArray {

    public int findBestSubarray(int[] nums, int k) {
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        int ans = curr;
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            ans = Math.max(ans, curr);
        }

        return ans;
    }
    public static void main(String[] args) {
        LargestSumSubArray ls = new LargestSumSubArray();
        System.out.println(ls.findBestSubarray(new int[]{3,-1,4,12,-8,5,6}, 4));
    }
}
