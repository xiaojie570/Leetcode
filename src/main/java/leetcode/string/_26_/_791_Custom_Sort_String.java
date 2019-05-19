package leetcode.string._26_;

/**
 * Created by lenovo on 2019/5/19.
 * 给你字符的顺序，让你排序另一个字符串
 */
public class _791_Custom_Sort_String {
    public String customSortString(String S, String T) {
        int[] countarray = new int[26];
        for(char c : T.toCharArray()){
            countarray[c-'a']++;
        }
        StringBuilder s = new StringBuilder();
        for(char c : S.toCharArray()) {
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
