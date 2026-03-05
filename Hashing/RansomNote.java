package Hashing;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch: magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char ch: ransomNote.toCharArray()){
            int available = map.getOrDefault(ch, 0);
            if( available > 0){
                map.put(ch, available-1);
            } else {
                return false;
            }
        }
        return true;

    }
}
