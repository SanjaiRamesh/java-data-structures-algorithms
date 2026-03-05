package string;

/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 */
public class ReverseString {

    public void reverseString(char[] s) {

        int i=0;
        int j = s.length-1;

        while(i<j){
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }

        System.out.println(s);
    }

     public static void main(String[] args) {
         ReverseString obj = new ReverseString();
         char[] s = {'h','e','l','l','o'};
         obj.reverseString(s);
     }
}
