package leetcode.string.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/19.
 * 产生所有的配对括号
 * 【解题思路】
 *      采用回溯法
 */
public class _22_Generate_Parentheses {
    List<String> ret = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        String s = "";
        help(s,n,n);
        return ret;
    }

    private void help(String s, int left, int right) {
        if(left == 0 && right == 0) {
            ret.add(s);
            return;
        }
        if(left > 0) {
            s += "(";  // 先加上
            help(s, left - 1, right);
            s = s.substring(0,s.length() - 1); // 回溯一下 。 回来之后再减去
        }
        if(right > 0 && right > left) {
            s += ")";
            help(s,left,right - 1);
            s = s.substring(0,s.length() - 1);
        }
    }
}
