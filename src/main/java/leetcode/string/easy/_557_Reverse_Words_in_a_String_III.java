package leetcode.string.easy;

/**
 * Created by lenovo on 2019/4/16.
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class _557_Reverse_Words_in_a_String_III {
    public String reverseWords(String s) {
        char[] arr =s.toCharArray();
        int index = s.indexOf(' ');
        int start = 0;
        while(index != -1) {
            reverse(arr,start,index - start); // 传递过去的是起始下标和应该反转的元素的个数
            start = index + 1;
            index = s.indexOf(' ',start);
        }
        if(start < s.length() - 1) {  // 这个是反转最后一个单词或者整个字符串就一个单词的情况
            reverse(arr,start,s.length() - start);
        }
        return new String(arr);
    }

    private void reverse(char[] chars, int start, int k) {
        for(int i = 0; i < k / 2; i++) {
            if(i == start + k - 1 - i) continue;
            char tmp = chars[start + i];
            chars[start + i] = chars[start + k - 1 - i];
            chars[start + k - 1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        int index = s.indexOf(' ',20);
        System.out.println(index);
    }
}
