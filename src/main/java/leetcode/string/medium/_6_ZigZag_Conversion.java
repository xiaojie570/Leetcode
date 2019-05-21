package leetcode.string.medium;

/**
 * Created by lenovo on 2019/5/21.
 * ZigZag_Conversion按照给定的格式输出字符串
 */
public class _6_ZigZag_Conversion {
    // numRows: 行数
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if(s == null || s.length() == 0 || numRows <= 0)
            return sb.toString();
        if(numRows == 1)
            return s;
        int size = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < s.length(); j += size) {
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows - 1 && (j - i + size - i) < s.length()) {
                    sb.append(s.charAt(j + size - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}
