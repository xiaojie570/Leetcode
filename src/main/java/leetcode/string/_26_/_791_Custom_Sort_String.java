package leetcode.string._26_;

/**
 * Created by lenovo on 2019/5/19.
 * 给你字符的顺序，让你排序另一个字符串
 * S是给定的已知字符的顺序，T 是排序的另一个字符串
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/92587676
 */
public class _791_Custom_Sort_String {
    public String customSortString(String S, String T) {
        int[] countarray = new int[26];
        for(char c : T.toCharArray()){  // T 要排序的字符串
            countarray[c-'a']++;
        }
        StringBuilder s = new StringBuilder();
        for(char c : S.toCharArray()) {  // S 已知顺序的字符串
            while(countarray[c-'a']-- >0) {
                s.append(c);
            }
        }
        for(int i=0;i<countarray.length;i++) {
            while(countarray[i]-- >0 ) {
                char ch = (char)('a'+i);
                s.append(ch);
            }
        }

        return s.toString();
    }
}
