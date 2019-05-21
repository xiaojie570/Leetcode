package leetcode.string.math;

/**
 * Created by lenovo on 2019/5/21
 * 整型数转换为罗马数字.
 * 【解题思路】
 *      1. 首先定义一个整型数组，数组中的值为所有的罗马数字的组合对应的整型  从大到小
 *      2. 其次定义一个字符串数组，数组中的值为所有的罗马罗马数字的组合
 *      3. 从头开始找整形数组中的值如果大于等于当前元素的值，就将这个整形数组对应的位置的字符串添加到返回的字符串中。然后将这个数 - 罗马字符串
 */
public class _12_Integer_to_Roman {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String ret = "";
        for(int i = 0; i < values.length; i++) {  //从大向小的减少
            while(num >= values[i]) {
                ret += chars[i];
                num -= values[i];
            }
        }
        return ret;
    }
}
