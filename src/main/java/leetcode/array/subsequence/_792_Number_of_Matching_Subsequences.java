package leetcode.array.subsequence;

/**
 * Created by lenovo on 2019/5/15.
 * 给一个字符串，一个字符串数组，找到字符串可以有几个字符串数组中的单词。
 */
public class _792_Number_of_Matching_Subsequences {
    public int numMatchingSubseq(String S, String[] words) {
        int ret = 0;
        for(String word: words) {
            char[] arr = word.toCharArray();
            int i = 0; // world
            int index = 0; // S
            while(i < S.length() && index < word.length()) {
                if(arr[index] == S.charAt(i)){
                    i++; index ++;
                } else {
                    i++;
                }
            }
            if( index == word.length())
                ret ++;
        }
        return ret;
    }

    public static void main(String[] args) {
        String S = "abcde";
        String[] words = {"a","bb","acd","ace"};
        _792_Number_of_Matching_Subsequences test = new _792_Number_of_Matching_Subsequences();
        test.numMatchingSubseq(S,words);
    }
}
