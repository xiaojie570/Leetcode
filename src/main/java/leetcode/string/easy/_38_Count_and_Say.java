package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/7.
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 将相同的连续的数改为有多少个这个数+这个数的值
 *
 * CSDN:  https://blog.csdn.net/xiaojie_570/article/details/91978844
 */
public class _38_Count_and_Say {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++)
            s = count(s);
        return s;
    }

    private String count(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;  // 初始每个数出现的频率都是 1
        char c = s.charAt(0);  // 读取每一行字符串的第一个元素
        for(int i = 1; i < s.length(); i++) {  // 循环遍历每一行字符串
            if(s.charAt(i) == c)  //  如果遍历到的字符串和之前的字符相同，则将count统计 自增
                count ++;
            else {
                sb.append(count); // 将之前统计的字符频率存储
                sb.append(c); // 将之前的字符存储
                count = 1;
                c = s.charAt(i);
            }
        }
        sb.append(count); // 将最后的一类字符存储起来
        sb.append(c);
        return sb.toString();
    }
}
