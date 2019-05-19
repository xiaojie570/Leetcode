package leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/19.
 * 模式匹配。
 * 现在有一个单词列表 words 和一个模式 pattern， 现在要返回哪些words 中的哪些单词和模式匹配
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 */
public class _890_Find_and_Replace_Pattern {
    public List<String> findAndReplacePattern(String[] words, String  pattern) {
        List<String> result=new ArrayList<String>();
        if(pattern==null||pattern.isEmpty()){
            return result;
        }
        for(String word:words){
            if(word.length()!=pattern.length()||word==null||word.isEmpty()){
                continue;
            }
            if(is_PatternMatch(word.toCharArray(),pattern.toCharArray())){
                result.add(word);
            }
        }
        return result;
    }

    private boolean is_PatternMatch(char[] word,char[] pattern){
        int[] word_lis=new int[26];
        int[] pattern_lis=new int[26];
        for(int i=0;i<word.length;i++){
            int w_idx = word[i] - 97;
            int p_idx=  pattern[i] - 97;
            if(word_lis[w_idx] != pattern_lis[p_idx]){
                return false;
            }
            word_lis[w_idx]=i+1;  // 当前的元素应该是在原数组中的第几个
            pattern_lis[p_idx]=i+1;  //  当前的元素应该是在原数组中的第几个
        }
        return true;
    }

    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a - 97);
        System.out.println('c' - 97);
    }
}
