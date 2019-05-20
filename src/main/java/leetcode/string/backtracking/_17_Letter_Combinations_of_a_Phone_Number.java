package leetcode.string.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lenovo on 2019/5/20.
 * 通过按电话键中的数字来返回所有可能组成的字符串。
 * 【解题思路】
 *      回溯法
 */
public class _17_Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return ret;
        HashMap<Character,String> hashMap = new HashMap<Character, String>();
        hashMap.put('0',"");
        hashMap.put('1',"");
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        help(digits,ret,sb,hashMap);
        return ret;
    }

    private void help(String digits, List<String> ret, StringBuilder sb, HashMap<Character, String> hashMap) {
        if(digits == null || digits.length() == 0) {
            ret.add(sb.toString());
            return;
        }
        char curDigit = digits.charAt(0); // 当前号码的第一个元素
        String possibleLetters = hashMap.get(curDigit); // 找到第一个数字代表的所有字符
        for(int i = 0; i < possibleLetters.length(); i++) {
            sb.append(possibleLetters.charAt(i)); //
            help(digits.substring(1), ret, sb, hashMap); // 将第一个数字剔除，然后递归
            sb.replace(sb.length() - 1, sb.length(), "");  // 将最后一个元素从StringBuilder中剔除出去，然后进行循环。
        }
    }
}
