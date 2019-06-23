package leetcode.string.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/5/7.
 * 摩斯代码
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/93393517
 */
public class _804_Unique_Morse_Code_Words {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<String>();
        for(String str: words) {
            StringBuilder sb = new StringBuilder();
            for(char c : str.toCharArray())
                sb.append(MORSE[c - 'a']);
            set.add(sb.toString());
        }
        return set.size();
    }
}
