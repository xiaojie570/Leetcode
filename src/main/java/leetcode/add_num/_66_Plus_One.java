package leetcode.add_num;

/**
 * 将数组中的元素变为整数，然后给整数 + 1 再转换为数组返回
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/91876593
 */
public class _66_Plus_One {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int temp = 0;
        for(int i = digits.length - 1; i >= 0; i-- ) {
            if(digits[i] < 9) {
                if(i == digits.length - 1)
                    digits[i]++;
                if(carry == 1) {
                    if(digits[i] < 9) {
                        digits[i] ++;
                        carry = 0;
                    } else{
                        digits[i] = 0;
                        carry = 1;
                    }
                }
                if(i >= 0 && carry != 1) {
                    return digits;
                }
            }
            else{
                digits[i]=0;
                carry=1;
            }
        }


        if(carry != 0) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            for(int i = 0; i < digits.length;i++)
                ret[i + 1] = digits[i];
            return ret;
        }
        return digits;
    }
}
