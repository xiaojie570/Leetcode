package leetcode.string._26_;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/4/21.
 * 奇数位置字母相同（顺序可以不同），偶数位置字母相同（顺序可以不同），即认为是special-equivalent string。
 */
public class _893_Groups_of_Special_Equivalent_Strings {
    public int numSpecialEquivGroups(String[] A) {
        int length = A.length;
        Set<String> str = new HashSet<String>();
        for(String s : A) {
            str.add(order(s));
        }
        return str.size();

    }
    private String order(String s) {
        if(s.length() == 1) return s;
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[52];
        // 这个是将字符串中的字符放到对应的数组中，而且题目要求可以奇数位置的数位置不一样，偶数位置的数位置不一样，
        // 所以这里使用了 52 位数组，这样的话，就可以让奇数放到前面26位，偶数位放到后面的26位
        // 使用下标记录对应的字符，就是0和26 都对应a，使用数组的值记录每个字符出现的个数。
        int odd = 0;
        for(char c: s.toCharArray()) {
            arr[(odd ++ % 2 == 0 ? 26 : 0) + c - 'a'] ++;
        }
        for(int i: arr) {
            sb.append(i);
        }
        return sb.toString();
    }
}
