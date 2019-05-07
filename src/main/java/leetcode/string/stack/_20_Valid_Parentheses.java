package leetcode.string.stack;

import java.util.Stack;

/**
 * Created by lenovo on 2019/5/7.
 * 判断给定的括号 ({[ 能否匹配上。
 * 【解题思路】
 *      通过stack 来匹配括号。
 */
public class _20_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else {
                if(!stack.isEmpty()) {
                    if(s.charAt(i) == ')' && stack.peek() == '(')
                        stack.pop();
                    else if(s.charAt(i) == ']' && stack.peek() == '[')
                        stack.pop();
                    else if(s.charAt(i) == '}' && stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                } else {
                    return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
