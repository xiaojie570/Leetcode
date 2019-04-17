package leetcode.dp.make_twostring_same;

/**
 * Created by lenovo on 2019/4/17.
 * 给定2个字符串，删除多少个元素可以两个字符串相等
 */
public class _583_Delete_Operation_for_Two_Strings {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length(), length2 = word2.length();
        int[] dp = new int[length2 + 1];
        for(int i = 1; i <= length1; i++) {
            int[] next = new int[length2 + 1];
            for(int j = 1; j <= length2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    next[j] = dp[j - 1] + 1;
                else
                    next[j] = Math.max(next[j - 1], dp[j]);
            }
            dp = next;
        }
        return length1 + length2 - 2*dp[length2];
    }

    public static void main(String[] args) {
        _583_Delete_Operation_for_Two_Strings test = new _583_Delete_Operation_for_Two_Strings();
        String s1 = "sea";
        String s2 = "eeat";
        int ret = test.minDistance(s1,s2);
        System.out.println(ret);
    }
}
