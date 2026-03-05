package slidingwindow;

/*
You are given a binary string s (a string containing only "0" and "1").
You may choose up to one "0" and flip it to a "1".
What is the length of the longest substring achievable that contains only "1"?

For example, given s = "1101100111", the answer is 5.
If you perform the flip at index 2, the string becomes 1111100111.
 */
public class LongestOnesInString {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0;
        int j=0;
        int count =0;
        while(i<s.length()) {

            if(s.charAt(i) == '0'){
                count++;
            }
            while(count>1){
                if(s.charAt(j) == '0'){
                    count--;
                }
                j++;
            }

            ans = Math.max(ans,i-j+1);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestOnesInString l = new LongestOnesInString();
        System.out.println(l.lengthOfLongestSubstring("1101100111"));
    }
}
