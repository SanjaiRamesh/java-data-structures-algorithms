package Hashing;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr. If there are duplicates in arr, count them separately.



Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there is no 2, 4, 6, or 8 in arr.
 */
public class CountingElements {

    /*
    O(N)
    Space O(U)
     */
    public int countElements(int[] arr) {
        Set<Integer> hashSet = new HashSet<>();
        for (int x : arr) {
            hashSet.add(x);
        }
        int count = 0;
        for (int x : arr) {
            if (hashSet.contains(x + 1)) {
                count++;
            }
        }
        return count;
    }


    /*
    O(N LongN)
     */
    public int countElements1(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int runLength = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                if (arr[i - 1] + 1 == arr[i]) {
                    count += runLength;
                }
                runLength = 0;
            }
            runLength++;
        }
        return count;
    }

    static void main(String[] args) {
        CountingElements obj = new CountingElements();
        System.out.println(obj.countElements(new int[]{1,1,3,3,5,5,7,7}));
        System.out.println(obj.countElements1(new int[]{1,2,3}));
    }
}
