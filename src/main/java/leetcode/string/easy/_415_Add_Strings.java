package leetcode.string.easy;

/**
 * Created by lenovo on 2019/4/24.
 * 大数相加
 */
public class _415_Add_Strings {
    public String addStrings(String num1, String num2) {
        int length1 = num1.length() - 1, length2 = num2.length() - 1;
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        while(length1 >= 0 || length2 >= 0 || temp > 0) {
            int a = length1 >= 0 ? num1.charAt(length1--) - '0' : 0;
            int b = length2 >= 0 ? num2.charAt(length2--) - '0' : 0;
            int left = ( a + b + temp) % 10;
            temp = (a + b + temp) / 10;
            sb.insert(0,String.valueOf((char)(left + '0')));
        }
        return sb.toString();
    }
}
