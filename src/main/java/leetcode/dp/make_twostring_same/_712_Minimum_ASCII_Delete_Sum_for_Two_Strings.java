package leetcode.dp.make_twostring_same;

/**
 * Created by lenovo on 2019/4/17.
 Input: s1 = "delete", s2 = "leet"
 Output: 403
 Explanation: Deleting "dee" from "delete" to turn the string into "let",
 adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
 At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
 If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 【题目大意】 给定两个字符串，使得删除最少的ASCII，使得两个字符串相等
 【解题思路】 首先将两个字符串中所有字符的ASCII求和，然后求每次遍历相同的元素的ASCII的和。
 */
public class _712_Minimum_ASCII_Delete_Sum_for_Two_Strings {
    public int minimumDeleteSum(String s1, String s2) {
        if(s1.length() < s2.length()) minimumDeleteSum(s2,s1);
        int length1 = s1.length(), length2 = s2.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int sum = 0;
        for(char c:arr1) sum += c;
        for(char c: arr2) sum += c;
        int[] dp = new int[length2 + 1];
        for(int i = 1; i <= length1; i ++) {
            int prev = 0;
            for(int j = 1; j <= length2; j++) {
                int temp = arr1[i - 1] == arr2[j - 1] ? prev + arr1[i - 1] + arr2[j - 1] : Math.max(dp[j],dp[j - 1]);
                prev = dp[j];
                dp[j] = temp;
            }
        }
        return sum - dp[length2];
    }

    public static void main(String[] args) {
        _712_Minimum_ASCII_Delete_Sum_for_Two_Strings test = new _712_Minimum_ASCII_Delete_Sum_for_Two_Strings();
        String s1 = "delete";
        String s2 = "leet";
        test.minimumDeleteSum(s1,s2);
    }
}
