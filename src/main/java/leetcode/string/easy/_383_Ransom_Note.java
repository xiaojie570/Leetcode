package leetcode.string.easy;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/6.
 * 勒索信：从杂志上搜偶所各个需要的字母，组成单词来表达意思。判断杂志上的字能否组成勒索信需要的那些字符。
 * 【解题思路】
 *      将 勒索信的字符放到 26长度的整型数组中，包含这个字符就将对应位置的值 + 1， 从杂志中对应的字符对应位置的值 -1，
 *      最后判断如果整型字符中存在 大于 0 的值，则返回false。
 */
public class _383_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null && magazine == null|| ransomNote.length() == 0 && magazine.length() == 0) return true;
        if(magazine == null || magazine.length() == 0) return false;
        if(ransomNote == null || ransomNote.length() == 0) return true;
        if(ransomNote.length() > magazine.length()) return false;
        int[] arr = new int[26];
        for(char c : ransomNote.toCharArray()) {
            arr[c - 'a'] ++;
        }
        for(char c: magazine.toCharArray()) {
            arr[c - 'a'] --;
        }
        for(int c: arr) {
            if(c > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _383_Ransom_Note test = new _383_Ransom_Note();
        test.canConstruct("aa","aab");
    }
}
