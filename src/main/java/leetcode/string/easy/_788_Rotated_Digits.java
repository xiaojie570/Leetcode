package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/6.
 * 【解题思路】
 *      如果该数包含2.5.6.9在家拍卖行的一个数，而不包含3.4.7中的任意一个数，就算符合条件
 */
public class _788_Rotated_Digits {
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1; i <= N; i++ ) {
            if(isValid(i))
                count++;
        }
        return count;
    }

    public boolean isValid(int i) {
        boolean valid = false;

        while(i > 0) {
            if(i % 10 == 2 || i % 10 == 5 || i % 10 == 6 || i % 10 == 9)
                valid = true;
            if(i% 10 == 3 || i% 10 == 4 || i% 10 == 7)
                return false;
            i = i / 10;
        }
        return valid;
    }
}
