package leetcode.string.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lenovo on 2019/5/6.
 */
public class _522_Longest_Uncommon_Subsequence_II {
    public int findLUSlength(String[] strs) {
        if(strs == null || strs.length == 0)  return 0;
        Comparator<String> mycomparator = new Comparator<String>(){  //  写一个比较器，比较两个字符串的长度
            public int compare(String a,String b){
                return a.length() - b.length();
            }
        };
        Arrays.sort(strs,mycomparator); // 对字符串进行排序，将长度小的放在前面
        int maxLen = -1;
        for(int i = strs.length-1; i >= 0; i--){  // 从字符串数组的最后一个字符开始比较
            boolean isUs = true;
            if(maxLen != -1)  // 剪枝法 ，这个很重要。之前把字符串由长到短排序，所以如果当前maxLen不为 -1 ，说明之前的串已经找到了最长的非公共子串了。
                break;
            for(int j = strs.length-1; j >= 0; j--){ //
                if(strs[j].length() < strs[i].length())
                    break;
                if(i != j && isSubsequence(strs[i],strs[j])){
                    isUs = false;
                    break;
                }
            }
            if(isUs)
                maxLen = Math.max(maxLen,strs[i].length());
        }
        return maxLen;
    }
    // 判断串a是不是串b的子串
    private boolean isSubsequence(String a, String b){
        int start = 0;
        for(int i = 0; i < a.length(); i++){
            int index = b.indexOf(a.charAt(i),start); // 找到字符串a对应的字符在字符串b中的位置
            if(index == -1) // 如果等于-1 ，说明没有匹配上
                return false;
            else{  // 如果不等于-1 说明前面的字符已经匹配上了
                start = index + 1;
            }
        }
        return true;
    }
}
