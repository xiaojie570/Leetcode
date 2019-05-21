package leetcode.string.medium;

/**
 * Created by lenovo on 2019/5/21.
 * 实现一个迷你解析器用来把一个字符串解析成NestedInteger类。
 * 【解题思路】
 *      1. 首先判断s是否为空，为空直接返回，不为空的话看首字符是否是 '['，不是的话说明s是一个整数，我们直接返回结果。
 *      2. 如果首字符是'[',且s的长度小于等于2，说明没有内容，那我们就直接返回结果。
 *      3. 反之，如果s长度大于2，我们从 i = 1开始遍历，我们需要一个变量start来记录某一层的起始位置，用 cnt 来记录其起始位置是否是同一个深度，cnt = 0 表示在同一深度。
 *      4. 因为中间每段字符都是用逗号分割开的，所以当我们判断当 cnt = 0的时候，且当前字符是逗号或者已经到字符串末尾了，我们就把这一段字符拿出来，放到返回的 ret 中
 *      5. 如果遇到'['，计数器cnt自增1，若遇到']'，计数器cnt自减1
 *
 */

class  NestedInteger{
    public NestedInteger(){}
    public NestedInteger(int value){};
    public void add(NestedInteger ni){}
    public void setInteger(int value){}
}
public class _385_Mini_Parser {

    public NestedInteger deserialize(String s) {
        NestedInteger res = new NestedInteger();
        if(s == null || s.length() == 0) {
            return res;
        }

        if (s.charAt(0) != '[') {
            res.setInteger(Integer.parseInt(s));
        } else if (s.length() > 2){
            int start = 1; // start 表示的是起始位置
            int cnt = 0;  // 当cnt = 0说明在同一深度
            for(int i = 1; i < s.length(); ++i) {
                char c = s.charAt(i); // 当前的元素的值
                if(cnt == 0 && (c == ',' || i == s.length() - 1)) {
                    res.add(deserialize(s.substring(start, i)));
                    start = i + 1;
                } else if(c == '[') {
                    ++cnt;
                } else if(c == ']'){
                    --cnt;
                }
            }
        }
        return res;
    }
}
