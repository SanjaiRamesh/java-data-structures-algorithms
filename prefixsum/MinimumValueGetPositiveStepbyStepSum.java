package prefixsum;

/*


Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.



Example 1:

Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
step by step sum
startValue = 4 | startValue = 5 | nums
  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
Example 2:

the minimum startValue is the value that makes the minimum element in the step-by-step sums equal to exactly 1.

Why exactly 1?

If the minimum element is smaller than 1, this means that the current startValue is invalid since a valid startValue is supposed to make every step-by-step total greater than or equal to 1.
If the minimum element is strictly larger than 1, this means that the current startValue is too large since the startValue - 1 is valid as well.
Proof complete!

Therefore, we just need to iterate over the array using startValue = 0, find the minimum step-by-step total in this iteration (say minVal), according to the previous proof, we should have minVal + startValue = 1, which is exactly startValue = 1 - minVal.

 */

public class MinimumValueGetPositiveStepbyStepSum {

    public int minStartValue(int[] nums) {
        // We use "total" for current step-by-step total, "minVal" for minimum
        // step-by-step total among all sums. Since we always start with
        // startValue = 0, therefore the initial current step-by-step total is 0,
        // thus we set "total" and "minVal" be 0.
        int minVal = 0;
        int total = 0;

        // Iterate over the array and get the minimum step-by-step total.
        for (int num : nums) {

            total += num;
            minVal = Math.min(minVal, total);
        }

        // We have to let the minimum step-by-step total equals to 1,
        // by increasing the startValue from 0 to -minVal + 1,
        // which is just the minimum startValue we want.
        return -minVal + 1;
    }

    public static void main(String[] args) {
        MinimumValueGetPositiveStepbyStepSum s = new MinimumValueGetPositiveStepbyStepSum();
        System.out.println(s.minStartValue(new int[]{1,2,2,4,2}));
        System.out.println(s.minStartValue(new int[]{-3,2,-3,4,2}));
    }
}
