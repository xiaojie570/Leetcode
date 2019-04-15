package leetcode.dp.palindromic_substrings;

/**
 * Created by lenovo on 2019/4/15.
 * 给定字符串的回文串个数。
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 这里有一个条件比较重要：只要回文串的下标不一样即使包含的是相同的元素也可以认为回文串那不一样，所以上面的输出会有三个'a'
 */
public class _647_Palindromic_Substrings {
    public int countSubstrings(String s) {
        int ret = 0;
        if(s == null || s.length() == 0) return 0;
        for(int i = 0; i < s.length(); i++){
            ret += isPalindromeRange(s,i,i);  // 这个是中间有一个元素向左右两边走
            ret += isPalindromeRange(s,i,i + 1); // 这个是中间有两个元素，向左右两边走
        }
        return ret;
    }
    // 计算当前元素的左右两边构成回文串的个数
    private int isPalindromeRange(String s, int start, int end) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        while(start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            count ++; start --; end ++;
        }
        return count;
    }
}
