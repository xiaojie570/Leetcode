package leetcode.string.stack;

import java.util.Stack;

/**
 * Created by lenovo on 2019/4/22.
 * 题目是把一个Unix或者类Unix系统下的一个地址进行简化（找到其最精简的地址）。
 * 【解题思路】
 *      这个题需要使用一个栈，来保存当前的路径的情况，所以我们先要把给定的path地址按照“/” 进行分割，分割出不同的操作：
 *      1. 如果是空或者是“。”，那么当前的地址就不动，地址栈不需要变动。
 *      2. 如果是“.."，则需要出栈（如果栈为空则不操作），因为这是返回上级目录的符号
 *      3. 其他情况压栈。
 */
public class _71_Simplify_Path {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String >();
        StringBuilder sb = new StringBuilder();
        String[] decode = path.split("/");  // 首先将给定的地址按照"/"符号进行分割
        for(String s: decode) {
            if(s.equals("") || s.equals("."))
                continue;
            if(s.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(s);
        }
        for(String s: stack)
            sb.append("/").append(s);
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
