package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/6.
 * 给两个字符串，最长子序列是其中一个字符串的子序列而不是另一个字符串的子序列。
 * 【解题思路】
 *  如果两个字符相同，就返回 -1， 如果不相同，则返回字符串长度大的那个字符串的长度即可
 *  CSDN: https://blog.csdn.net/xiaojie_570/article/details/92767618
 */
public class _521_Longest_Uncommon_Subsequence_I {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(),b.length());
    }
}
