package prefixsum;

import java.util.Arrays;

/*
Given an integer array nums, an array queries where queries[i] = [x, y] and an integer limit, return a boolean array that represents the answer to each query. A query is true if the sum of the subarray from x to y is less than limit, or false otherwise.

For example, given nums = [1, 6, 3, 2, 7, 2], queries = [[0, 3], [2, 5], [2, 4]], and limit = 13, the answer is [true, false, true]. For each query, the subarray sums are [12, 14, 12].
 */
public class AnswerQueries {

    public boolean[] answerQueries(int[] nums, int[][] queries, int limit){
        boolean[] answer = new boolean[queries.length];
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        for(int i =1; i< nums.length;i++){
            prefixSum[i] = prefixSum[i - 1]+ nums[i];
        }

        for(int i =0; i< queries.length; i++){
            int x = queries[i][0];
            int y = queries[i][1];

            answer[i] = (prefixSum[y] - prefixSum[x] +nums[i] ) <= limit;
        }

        return answer;
    }

    public static void main(String[] args){
        AnswerQueries q = new AnswerQueries();
        boolean[] ans = q.answerQueries(new int[]{1, 6, 3, 2, 7, 2}, new int[][]{{0, 3}, {2, 5}, {2, 4}},13);
        System.out.println(Arrays.toString(ans));
    }
}
