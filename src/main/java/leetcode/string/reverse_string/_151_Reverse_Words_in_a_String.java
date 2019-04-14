package leetcode.string.reverse_string;

/**
 * Created by lenovo on 2019/4/14.
 * 旋转字符串
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * 【解题思路】
 *      1. 注意这里面要从后向前面找空格，没找到一个单词就使用字符串的substring方法截取字符串
 *      2. StringBuider每次增加单词之前都先增加一个空格，所以在所有字符都处理完后，要把StringBuider多加的第一个空格去掉。
 */
public class _151_Reverse_Words_in_a_String {

    public String reverseWords(String s) {
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(end >= 0){ // 从后面向前面找单词
            if(s.charAt(end) == ' '){
                end--;
                continue;
            }
            int start = s.lastIndexOf(' ',end);
            sb.append(' ');
            sb.append(s.substring(start+1,end+1));
            end = start-1;
        }
        if(sb.length() > 0){ // 把第一个多加的空格去掉
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _151_Reverse_Words_in_a_String test = new _151_Reverse_Words_in_a_String();
        String ret =test.reverseWords("the sky is blue");
        System.out.println(ret);
    }
}
