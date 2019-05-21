package leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by lenovo on 2019/5/21.
 * 匹配字符，给定一个字符串 pattern 喝一个字符串数组 quires。对于 queries 中的每个字符串，判断是不是pattern字符串各个字符间插入小写字母后的结果。
 * 当然，可以不插入字母，如果能够匹配上就返回true，否则返回false
 * 【解题思路】
 *      解法一：使用正则的方式
 *      解法二：正常的方式。使用下标的方式。
 */
public class _1023_Camelcase_Matching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
/*        List<Boolean> ret = new ArrayList<Boolean>();
        StringBuilder sb = new StringBuilder();
        for(char c: pattern.toCharArray())
            sb.append("[a-z]*").append(c).append("[a-z]*");
        String reg = "^" + sb.toString() + "$";
        for(String s : queries) {
            ret.add(s.matches(reg));  //判断是否相同。
        }
        return ret;*/
        List<Boolean> ret = new ArrayList<Boolean>();
        for(String query: queries) {
            ret.add(match(query,pattern));
        }
        return ret;
    }

    private Boolean match(String query, String pattern) {
        int i = 0;
        for(int j = 0; j < query.length(); j++) {
            if(i < pattern.length() && query.charAt(j) == pattern.charAt(i))
                i++;
            else if(isUpper(query.charAt(j)))
                return false;
        }
        return i == pattern.length();
    }

    private boolean isUpper(char c) {
        if(c >= 'A' && c <= 'Z')
            return true;
        return false;
    }

    public static void main(String[] args) {
        char c = '1';
        System.out.println("abs".matches("^" + "[a-z]*" + "$"));
    }

}
