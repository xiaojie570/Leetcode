package leetcode.string.math;

/**
 * Created by lenovo on 2019/5/6.
 */
public class _13_Roman_to_Integer {
    public int romanToInt(String s) {
        int[] arr = new int[s.length()];
        int ret = 0;
        for(int i = 0 ; i < s.length();i++) {
            switch (s.charAt(i)) {
                case 'M' : arr[i] = 1000;
                    break;
                case 'D' : arr[i] = 500;
                    break;
                case 'C' : arr[i]  = 100;
                    break;
                case 'L' : arr[i] = 50;
                    break;
                case 'X' : arr[i] = 10;
                    break;
                case 'V' : arr[i] = 5;
                    break;
                case 'I' : arr[i] = 1;
            }
        }
        for(int i = 0; i < s.length() - 1; i++) {
            if(arr[i] < arr[i + 1])
                ret -= arr[i];
            else
                ret += arr[i];
        }
        return ret += arr[s.length() - 1];
    }
}
