package leetcode.dp.subarray;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/5/27.
 * 有一个无限长的封装字符串，然后又给了我们另一个字符串p，问我们p有多少非空子字符串在封装字符串中
 * 【解题思路】
 *      可以观察到，封装字符串是26个字符按照顺序无限循环组成的，那么满足题意的p字符串要么是单一的字符，要么是按照字母顺序的子字符串。
 *      我们可以观察 abcd这个字符串，以d结尾的字符串有abcd, bcd, cd ,d ，那么我们可以发现 bcd或者cd这些以 d 结尾的子字符串都包含在abcd中，那么我们只需要知道以某个字符结束的最大字符串包含其他以
 *      该字符结束的字符串的所有子字符串。
 */
public class _467_Unique_Substrings_in_Wraparound_String {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int maxLength = 0;
        for(int i = 0; i < p.length(); i++) {
            if(i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) // 找到最大的那个连续的子字符串
                maxLength ++;
            else
                maxLength = 1;
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index],maxLength);
        }
        int sum = 0;
        for (int a : count) {
            sum += a;
        }
        return sum;
    }
}
