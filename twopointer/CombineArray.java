package twopointer;

import java.util.ArrayList;
import java.util.List;

/*
Given two sorted integer arrays arr1 and arr2, return a new array that combines both of them and is also sorted.
 */
public class CombineArray {
    public List<Integer> combine(int[] arr1, int[] arr2) {
        List<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;

        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                ans.add(arr1[i]);
                i++;
            } else {
                ans.add(arr2[j]);
                j++;
            }
        }

        while(i<arr1.length){
            ans.add(arr1[i]);
            i++;
        }

        while(j<arr2.length){
            ans.add(arr2[j]);
            j++;
        }

        return ans;
    }

    static void main(String[] args) {
        CombineArray obj = new CombineArray();
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {2,4,6,8};
        List<Integer> ans = obj.combine(arr1, arr2);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}
