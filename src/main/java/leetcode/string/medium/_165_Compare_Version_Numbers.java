package leetcode.string.medium;

/**
 * Created by lenovo on 2019/4/21.
 * 数字的版本
 * 【解题思路】
 *      1. 每个点.是一个分隔符，计算每个点对应的数值，两个字符串算完的每个间隔进行比较。
 *
 */
public class _165_Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        int length1 = version1.length(), length2 = version2.length();
        int i = 0, j = 0;
        while(i < length1 || j < length2) {
            int temp1 = 0, temp2 = 0;
            while(i < length1 && version1.charAt(i) != '.') { // 计算一个点间隔对应的值
                temp1 = temp1 * 10 + version1.charAt(i ++) - '0';
            }
            while(j < length2 && version2.charAt(j) != '.')
                temp2 = temp2 * 10 + version2.charAt(j ++) - '0';
            if(temp1 > temp2)
                return 1;
            else if(temp1 < temp2) return -1;
            else {
                i++; j++;
            }
        }
        return 0;
    }
}
