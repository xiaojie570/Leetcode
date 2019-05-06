package leetcode.string.substring;

/**
 * Created by lenovo on 2019/5/6.
 * 【问题描述】
 *      找到所有子串，其中 0 和 1 的数目相同，且0和1要求连续
 * 【解题思路】
 *      使用两个变量来记录1 和 0 的个数，如果当前元素和前一个元素不同，则将count ++，如果相同就累加对应的元素的个数
 */
public class _696_Count_Binary_Substrings {
    public int countBinarySubstrings(String s) {
        char arr[] = s.toCharArray();
        int zero = 0, one = 0;
        if(arr[0] == '0')
            zero = 1;
        else
            one = 1;
        int count = 0;
        for(int i = 1; i < s.length(); i++) {
            if(arr[i] != arr[i - 1]) {
                count ++;
                if(arr[i] == '0')
                    zero = 1;
                else
                    one = 1;
            } else {
                if(arr[i] == '0') {
                    zero ++;
                    if(one >= zero)
                        count ++;
                } else {
                    one ++;
                    if(zero >= one)
                        count ++;
                }
            }
        }
        return count;
    }
}
