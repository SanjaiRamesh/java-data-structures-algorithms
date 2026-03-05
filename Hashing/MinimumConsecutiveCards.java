package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
You are given an integer array cards where cards[i] represents the value of the ith card. A pair of cards are matching if the cards have the same value.

Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards. If it is impossible to have matching cards, return -1.



Example 1:

Input: cards = [3,4,2,3,4,7]
Output: 4
Explanation: We can pick up the cards [3,4,2,3] which contain a matching pair of cards with value 3. Note that picking up the cards [4,2,3,4] is also optimal.
Example 2:

Input: cards = [1,0,5,3]
Output: -1
Explanation: There is no way to pick up a set of consecutive cards that contain a pair of matching cards.
 */
public class MinimumConsecutiveCards {

    /*
    Sliding window solution
     */

    public int minimumCardPickup(int[] cards) {

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < cards.length; right++) {

            map.put(cards[right], map.getOrDefault(cards[right], 0) + 1);

            while (map.get(cards[right]) > 1) {

                min = Math.min(min, right - left + 1);

                map.put(cards[left], map.get(cards[left]) - 1);
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /*
    HashMap solution

     */

    public int minimumCardPickup1(int[] cards) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int min = Integer.MAX_VALUE;

        for(int i=0;i< cards.length;i++) {
            map.putIfAbsent(cards[i], new ArrayList<>());
            map.get(cards[i]).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> list = entry.getValue();
            for(int i=1;i<list.size();i++) {

                min = Math.min(min, list.get(i) -list.get(i-1)+1);

            }

        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }
/*
We can actually improve this algorithm slightly by observing that we don't need to store all the indices,
but only the most recent one that we saw for each number.
This improves the average space complexity. The current algorithm has O(n)
O(n) space complexity always, but with the improvement, it is only O(n)
O(n) in the worst case, when there are no duplicates.
 */
    public int minimumCardPickup2(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;

        for(int i=0;i< cards.length;i++) {

            if(map.containsKey(cards[i])) {
                int left = map.get(cards[i]);

                min = Math.min(min, i-left+1);
            }
            map.put(cards[i], i);
        }


        return min == Integer.MAX_VALUE ? -1 : min;

    }

    static void main(String[] args) {
        MinimumConsecutiveCards mc = new MinimumConsecutiveCards();
        System.out.println(mc.minimumCardPickup(new int[]{1, 2, 6, 2, 1}));
        System.out.println(mc.minimumCardPickup1(new int[]{1, 2, 6, 2, 1}));
        System.out.println(mc.minimumCardPickup2(new int[]{1, 2, 6, 2, 1}));
        System.out.println(mc.minimumCardPickup2(new int[]{3, 4, 2, 3, 4,7}));
    }
}
