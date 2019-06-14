package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/7.
 * 给一个非空的字符串，你可以删除最多一个字符，判断之后这个字符串是否是回文串。
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/91983225
 */
public class _680_Valid_Palindrome_II {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        return isValid(s,0,s.length() - 1,0,1);
    }

    private boolean isValid(String s, int left, int right, int delCount, int N) {  // delCount表示当前已经删除了多少个元素；N 表示可以删除的个数
        if(delCount > N)
            return false;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                delCount++;
                return isValid(s, left + 1, right, delCount, N)
                        || isValid(s, left, right - 1, delCount, N);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ebcbbececabbacecbbcbe";
    }
}
