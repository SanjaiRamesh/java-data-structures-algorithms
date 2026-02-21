package array;
/**
 * Problem: Remove Duplicates from Sorted Array
 * Pattern: Two Pointers
 * Time Complexity: O(n2)
 * Space Complexity: O(1)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DeleteKeyFromArrayAndShift {

    public static void deleteKeyFromArrayList(List<Integer> input, int key) {
        if(Objects.isNull(input) || input.isEmpty()) {
            return;
        }
        int writerIdx = 0;
        int n = input.size();

        for(int i=0;i<n;i++) {

            if(input.get(i).equals(key)) {
                input.remove(writerIdx);
                i--;n--;
            } else {
                writerIdx++;
            }

        }
    }

    public static int deleteFromArray(int[] input, int key) {
        int n = input.length;
        int writeIdx = 0;
        for(int i = 0;i<n;i++) {
            if( key != input[i]) {
                input[writeIdx++] = input[i];
            }
        }

        for(int i = 0; i<writeIdx; i++) {
            System.out.print(" "+ input[i]);

        }
        return writeIdx;
    }
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(List.of(2,3,5,5,7,11,11,11,13));
        System.out.println(input);
        deleteKeyFromArrayList(input, 11);
        System.out.println(input);
        int[] input1 = {2,3,5,5,7,11,11,11,13,13,13,12};
        System.out.println(Arrays.toString(input1));
        deleteFromArray(input1, 13);

    }
}
