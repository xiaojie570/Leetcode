package leetcode.string.easy;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/8.
 * 整型数组加1
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
