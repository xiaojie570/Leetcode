package leetcode.string.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/20.
 * 找到并且使用targets字符串数组中的元素替换原字符串中对应位置的元素
 * 给定一个字符串，要求如果在指定位置出现了指定的source字符串，我们就用相应的target字符串进行替换。
 * 【解题思路】
 *      1. 首先找到需要替换的元素的下标，将它的下标记录到整形数组中
 *      2. 然后根据整型数组中的值向 StringBuilder 的元素中天健字符。
 */
public class _833_Find_And_Replace_in_String {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        if(S.length() < indexes[indexes.length - 1])
            return S;
        int[] replace = new int[S.length()];
        Arrays.fill(replace, - 1);
        for(int i = 0; i < indexes.length; i++) {
            int s1 = indexes[i]; // 找到想要替换掉的对应的元素的下标
            int len = sources[i].length(); // 找到需要替换的长度
            String s = S.substring(s1, s1 + len); // 找到需要替换的原数组的元素
            if(s.equals(sources[i])) {
                replace[s1] = i; // 找到满足条件的需要替换掉的对应元素的下标
            }
        }
        int i = 0;
        while(i < S.length()) {
            if(replace[i] == -1) { // 不需要替换，则直接放到 StringBuilder中即可
                sb.append(S.charAt(i));
                i++;
            } else {  // 需要替换
                sb.append(targets[replace[i]]);  // 替换一下
                i += sources[replace[i]].length(); // 这个地方需要将原来替换掉的元素下标向后移动
            }
        }
        return sb.toString();
    }
}
