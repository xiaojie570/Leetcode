package leetcode.string.medium;

/**
 * Created by lenovo on 2019/5/20.
 * 将数组的数值，根据题意叠加，之后改变字符串。
 */
public class _848_Shifting_Letters {
    public String shiftingLetters(String S, int[] shifts) {
        if(S.length() != shifts.length)
            return S;
        char[] arr = S.toCharArray();
        for(int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;  // 可能超过 26，所以要对26取余数
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (char) ((arr[i] - 'a' + shifts[i]) % 26 + 'a');
        }
        return new String(arr);
    }
}
