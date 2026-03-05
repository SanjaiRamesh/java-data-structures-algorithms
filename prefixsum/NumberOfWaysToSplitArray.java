package prefixsum;

public class NumberOfWaysToSplitArray {

    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            long leftSection = prefix[i];
            long rightSection = prefix[n - 1] - prefix[i];
            if (leftSection >= rightSection) {
                ans++;
            }
        }

        return ans;
    }

    public int waysToSplitArray1(int[] nums) {
        int ans = 0;
        long leftSection = 0;
        long total = 0;

        for (int num: nums) {
            total += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            leftSection += nums[i];
            long rightSection = total - leftSection;
            if (leftSection >= rightSection) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        NumberOfWaysToSplitArray obj = new NumberOfWaysToSplitArray();
        System.out.println(obj.waysToSplitArray(new int[] {10,4,-8,7}));
        System.out.println(obj.waysToSplitArray1(new int[] {10,4,-8,7}));
    }

}
