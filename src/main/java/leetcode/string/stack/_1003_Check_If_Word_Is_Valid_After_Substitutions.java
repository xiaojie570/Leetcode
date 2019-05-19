package leetcode.string.stack;

import java.util.Stack;

/**
 * Created by lenovo on 2019/5/19.
 * 我们认定有效的字符串是 “abc”，现在给一个字符串，判断是否是有效字符串。
 * Input: "aabcbc"
 * Output: true
 * Explanation:
 * We start with the valid string "abc".
 * Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is "aabcbc".
 *
 * 【解题思路】
 *      本来本题应该是一个stack题，但是我们可以使用数组来代替堆结构
 *      1. 首先我们判断当前元素是否是 “c” 如果是，就判断它前面的元素和大前面的元素 分别是否是"b" 和 “a” 如果不是则返回false
 *      2. 如果当前元素不是 “c”，则将当前元素放到数组里面即可。
 */
public class _1003_Check_If_Word_Is_Valid_After_Substitutions {
    public boolean isValid(String S) {
        if(S == null || S.length() == 0 || S.length() % 3 != 0)
            return false;
        int index = 0;
        char[] arr = S.toCharArray();
        for(char c: arr) {
            if(c == 'c') {
                if(index < 1 || arr[--index] != 'b')
                    return false;
                if(index == 0 || arr[-- index] != 'a')
                    return false;
            } else
                arr[index ++] = c;
        }
        return true;
    }
}
