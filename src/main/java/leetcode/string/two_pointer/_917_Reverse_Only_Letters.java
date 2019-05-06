package leetcode.string.two_pointer;

/**
 * Created by lenovo on 2019/5/6.
 * 只反转字符串中的字母字符
 */
public class _917_Reverse_Only_Letters {
    public String reverseOnlyLetters(String S) {
        if(S == null || S.length() == 0)
            return S;
        char[] arr = S.toCharArray();
        int first = 0, last = S.length() - 1;
        while(first < last) {
            while(first < S.length() && first < last && !(arr[first] >= 'a' && arr[first] <= 'z' || arr[first] >= 'A' && arr[first] <= 'Z' )) {
                first ++;
            }
            while(last >= 0 && first < last &&  !(arr[last] >= 'a' && arr[last] <= 'z' || arr[last] >= 'A' && arr[last] <= 'Z' )) {
                last --;
            }
            if(first < S.length() && last >= 0) {
                char temp = arr[first];
                arr[first] = arr[last];
                arr[last] = temp;

            }
            first ++; last --;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        _917_Reverse_Only_Letters test = new _917_Reverse_Only_Letters();
        test.reverseOnlyLetters("?6C40E");
    }
}
