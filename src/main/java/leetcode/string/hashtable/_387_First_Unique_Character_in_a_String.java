package leetcode.string.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到字符串中第一个出现的非重复的元素的下标
 * 【解题思路】
 *      使用26个英文字符去找对应的元素的下标
 *      然后从后面找到这个元素的下标，如果从前往后和从后往前找到的元素下标一样，就说明是第一次出现过的
 */
public class _387_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        int ret = s.length();
        for(char a = 'a'; a <= 'z'; a++) {
            int index = s.indexOf(a);
            if(index != -1 && s.lastIndexOf(a) == index)
                ret = Math.min(ret,index);
        }
        return ret < s.length() ? ret : -1;
    }
}
