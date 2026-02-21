package array;

/**
 * Problem: Remove Duplicates from Sorted Array
 * Pattern: Two Pointers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeleteDuplicateFromArray {

    public static void deleteDuplicate(List<Integer> input) {
        if(Objects.isNull(input) || input.isEmpty()) {
            return ;
        }

        int n = input.size();
        Integer current = input.get(0);
        int j = 1;
        for(int i = 1; i<n; i++) {
            if(!current.equals(input.get(i))) {
                input.set(j, input.get(i));
                current = input.get(i);
                j++;
            }
        }

        for(int k=j-1;k<n-1;k++) {
            input.remove(j);
        }
    }

    public static int solution2(List<Integer> input) {

        int writeIndex = 1;
        int n = input.size();
        for( int i = 1; i<n;i++) {
            if(!input.get(writeIndex-1).equals(input.get(i))) {
                input.set(writeIndex++, input.get(i));
            }
        }

        return writeIndex;

//        for(int i = writeIndex; i<n;i++) {
//            input.remove(writeIndex);
//        }

    }
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(List.of(2,3,5,5,7,11,11,11,13));
        System.out.println(input);
        deleteDuplicate(input);
        System.out.println(input);
        List<Integer> input1 = new ArrayList<>(List.of(2,2,2,3,5,5,7,11,11,11,13,14,14,14));
        System.out.println(input1);
        System.out.println(input1.subList(0,solution2(input1)));
    }
}
