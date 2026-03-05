package slidingwindow;

/*
Given an array of positive integers nums and an integer k,
find the length of the longest subarray whose sum is less than or equal to k.
This is the problem we have been talking about above. We will now formally solve it.
 */
public class LongestSubArraySumLess {

    public int findLength(int[] nums, int k) {
        int sum =0;
        int i =0;
        int j=0;
        int ans = Integer.MIN_VALUE;

        while(i<nums.length){
            sum+=nums[i];

            while (sum > k) {
                sum-=nums[j];
                j++;
            }

            ans = Math.max(ans, i-j+1);
            i++;


        }
        return ans;

    }

    public int findLength1(int[] nums, int k) {
        int left = 0;
        int curr = 0; // curr is the current sum of the window
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubArraySumLess ls = new LongestSubArraySumLess();
        System.out.println(ls.findLength(new int[]{1,1,1,1,1,1,1,1},2));
        System.out.println(ls.findLength(new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5},8));
        System.out.println(ls.findLength1(new int[]{1,1,1,1,1,1,1,1},2));
        System.out.println(ls.findLength1(new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5},8));

    }


}
