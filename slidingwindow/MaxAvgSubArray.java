package slidingwindow;


/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
Any answer with a calculation error less than 10-5 will be accepted.
 */
public class MaxAvgSubArray {


    public double findMaxAverage(int[] nums, int k) {

        double sum = 0;
        double avg = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        avg = sum;

        for(int i = k; i < nums.length; i++){
            sum -=nums[i-k];
            sum += nums[i];
            avg = Math.max(avg,sum);
        }
        return avg/k;
    }

    public static void main(String[] args) {
        MaxAvgSubArray obj = new MaxAvgSubArray();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(obj.findMaxAverage(nums, k));
    }
}
