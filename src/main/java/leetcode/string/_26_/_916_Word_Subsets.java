package leetcode.string._26_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/20.
 * 给定字符串数组A和B，如果字符串b中每个字符的出现次数都<=该字符在a中的出现次数，则称b是a的子集。
 * 如果对于B中的每个字符串b，b都是a的子集，则称a为“universal”。问A中有多少个字符串是“universal”的。
 */
public class _916_Word_Subsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ret = new ArrayList<String>();
        int b[] = new int[26];
        for(String s: B) {
            b = combine(s, b);  // 返回给定的B中的所有元素，每个元素都要是最大的个数。
        }
        for(String a: A) {
            if(contain(a,b)) ret.add(a);
        }
        return ret;
    }

    private boolean contain(String a, int[] b) {  // 判断这个字符串是否包含B中所有的字符
        int[] temp = new int[26];
        for(char c: a.toCharArray())
            temp[c - 'a'] ++;
        for(int i = 0; i < 26; i ++) {
            if(temp[i] < b[i])
                return false;
        }
        return true;
    }

    private int[] combine(String s, int[] b) {
        int[] temp = new int[26];
        for(char c: s.toCharArray()) {
            temp[c - 'a'] ++;
        }
        for(int i = 0; i < 26; i++) {
            b[i] = Math.max(b[i],temp[i]);
        }
        return b;
    }
}
