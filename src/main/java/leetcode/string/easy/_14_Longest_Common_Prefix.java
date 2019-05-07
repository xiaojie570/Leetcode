package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/7.
 * 找到给定字符串数组的最长公共前缀
 */
public class _14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return new String();
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) { // 只有从头匹配的才算
                prefix = prefix.substring(0,prefix.length() - 1);
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println("abcde".indexOf("bcddd"));
        System.out.println("asss".substring(0,0));
        System.out.println("as");
    }
}
