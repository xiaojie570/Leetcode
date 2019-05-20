package leetcode.string.medium;

/**
 * Created by lenovo on 2019/5/20.
 * 给出一个长字符串S， 以及一个words list。 Words 里面每个word，可以通过扩展当前的char，来尝试构造S。
 * extend的规则是，S中的char，必须连续出现>=3 才可以extend。问，words里面会有几个word 能够extend到S中。
 */
public class _809_Expressive_Words {
    public int expressiveWords(String S, String[] words) {
        int ret = 0;
        for(String word : words) {
            if(check(S,word))
                ret ++;
        }
        return ret;
    }
    // 1. s -> 给定的字符串，   word -> 需要匹配的字符串
    private boolean check(String s, String word) {
        int j = 0; // word 字符串的下标
        int lengthS = s.length(); // 要匹配的元素的长度
        int lengthW = word.length();
        for(int i = 0; i < s.length(); i++) { // 这个字符是不是连续出现三次。如果是就进入下一次循环。不是，返回false
            if(j < lengthW && s.charAt(i) == word.charAt(j))
                j++;
            else if(i > 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2));  // 如果当前字符是三个连续字符的最后一个字符，那么就需要这个方式判断
            else if(i > 0 && i + 1 < lengthS && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i + 1));  // 如果当前字符是三个连续字符的中间字符就要这么判断这个字符是不是连续出现三次
            else
                return false;
        }
        // // 如果最后第二个字符串走到了末尾，就说明这个字符串是满足条件的
        return j == lengthW;
    }
}
