package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/6.
 * 字符串中最后一个单词的长度
 */
public class _58_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        s = s.trim();
        int length = s.length();
        int index = s.lastIndexOf(' ');
        int count = 0;
        if(index != -1) {
            while(index ++ < length)
                count++;
        }else {
            index = 0;
            while(index ++ < length)
                count++;
            count ++;
        }
        return count - 1;
    }

    public static void main(String[] args) {
        _58_Length_of_Last_Word test = new _58_Length_of_Last_Word();
        int ret = test.lengthOfLastWord("a ");
        System.out.println(ret);
    }
}
