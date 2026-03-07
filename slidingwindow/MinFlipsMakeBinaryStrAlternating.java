package slidingwindow;


/*
You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:

Type-1: Remove the character at the start of the string s and append it to the end of the string.
Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
Return the minimum number of type-2 operations you need to perform such that s becomes alternating.

The string is called alternating if no two adjacent characters are equal.

For example, the strings "010" and "1010" are alternating, while the string "0100" is not.


Example 1:

Input: s = "111000"
Output: 2
Explanation: Use the first operation two times to make s = "100011".
Then, use the second operation on the third and sixth elements to make s = "101010".
Example 2:

Input: s = "010"
Output: 0
Explanation: The string is already alternating.
Example 3:

Input: s = "1110"
Output: 1
 */
public class MinFlipsMakeBinaryStrAlternating {


    public int minFlip(String s) {

        int n = s.length();
        String temp = s+s;

        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        for(int i=0;i<n*2;i++){
            alt1.append(i%2 == 0? '0': '1');
            alt2.append(i%2 == 0? '1': '0');
        }

        int ans = Integer.MAX_VALUE;
        int dif1=0, dif2=0,l=0;
        for(int r=0;r<2*n;r++) {
            if(temp.charAt(r) != alt1.charAt(r))dif1++;
            if(temp.charAt(r) != alt2.charAt(r))dif2++;

            if( r-l+1>n){
                if(temp.charAt(r) != alt1.charAt(r))dif1--;
                if(temp.charAt(r) != alt2.charAt(r))dif2--;
                l++;
            }

            if(r-l+1 == n){
                ans = Math.min(dif1,dif2);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        MinFlipsMakeBinaryStrAlternating obj = new MinFlipsMakeBinaryStrAlternating();
        System.out.println(obj.minFlip("111000"));
    }
}
