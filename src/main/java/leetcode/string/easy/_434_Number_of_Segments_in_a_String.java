package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/7.
 * 返回给定字符串有多少个单词。单词是由空格分割的。
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/92606859
 */
public class _434_Number_of_Segments_in_a_String {
    public int countSegments(String s) {
        String[] strs = s.split(" ");
        int count = 0;
        for (String str : strs){
            if (str.length() != 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        _434_Number_of_Segments_in_a_String test = new _434_Number_of_Segments_in_a_String();
        test.countSegments("a,  as  sad");
    }
}
