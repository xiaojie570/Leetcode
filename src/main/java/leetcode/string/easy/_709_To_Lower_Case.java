package leetcode.string.easy;

/**
 * Created by lenovo on 2019/4/12.
 * 将给定的字符串大写字母都变为小写字母（签到题）
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/90692047
 */
public class _709_To_Lower_Case {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if(temp >= 'a' && temp <= 'z') {
                sb.append(temp);
            } else if(temp >= 'A' && temp <= 'Z'){
                sb.append((char)(temp - 'A' + 'a'));
            } else {
                sb.append(temp);
            }
        }
        return new String(sb);
    }
}
