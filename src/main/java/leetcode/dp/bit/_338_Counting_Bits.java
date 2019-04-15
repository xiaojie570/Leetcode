package leetcode.dp.bit;

/**
 * Created by lenovo on 2019/4/15.
 * 给一个数num。写出从0到num数中每一个数的二进制中的1的个数
 * Input: 5
 * Output: [0,1,1,2,1,2]
 */
public class _338_Counting_Bits {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            ret[i] = ret[i / 2] + (i & 1);
        }
        return ret;
    }
}
