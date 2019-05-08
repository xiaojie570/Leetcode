package leetcode.string.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/5/8.
 * Input: A = "ab", B = "ba"
 * Output: true
 * 给两个字符串，判断是否是兄弟字符串，兄弟字符串的定义：交换某个字符串中的2个字符可以和另外一个字符串相同。
 * 注意各种特殊的情况
 */
public class _859_Buddy_Strings {
    public boolean buddyStrings(String A, String B) {
        if (null == A || null == B || A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) { // 如果两个字符串相同，就将字符添加到 set中，如果添加的字符在set中已经有了就直接返回true
            Set<Character> record = new HashSet<Character>();
            for ( Character ch : A.toCharArray()) {
                if (record.contains(ch)) {
                    return true;
                } else {
                    record.add(ch);
                }
            }
        } else {
            char[] differs = new char[2];
            boolean finished = false;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (finished) {
                        return false;
                    }
                    if ('\u0000' == differs[0]) {
                        differs[0] = A.charAt(i);
                        differs[1] = B.charAt(i);
                    } else {
                        if (differs[1] == A.charAt(i) && differs[0] == B.charAt(i)) {
                            finished = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
            return finished;
        }
        return false;
    }

    public static void main(String[] args) {
        _859_Buddy_Strings test = new _859_Buddy_Strings();
        boolean ret = test.buddyStrings("aaab","aaab");
        System.out.println(ret);
    }
}
