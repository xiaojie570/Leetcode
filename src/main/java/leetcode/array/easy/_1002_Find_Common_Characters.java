package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2019/4/14.
 * 找出给定字符串中所有字符串都出现的元素，重复元素也要取出来
 */
public class _1002_Find_Common_Characters {
    int[] arr = new int[26];
    public List<String> commonChars(String[] A) {
        if(A == null || A.length == 0) return null;
        List<String> list = new ArrayList<String>();
        Arrays.fill(arr,Integer.MAX_VALUE);
        for(String str : A) {
            common(arr,str);
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                list.add("" + (char)(i + 'a'));
                arr[i]--;
            }
        }
        return list;
    }

    private void common(int[] arr, String str) {
        int[] temp = new int[26];
        for(char c: str.toCharArray())
            temp[c - 'a'] ++;
        for(int i = 0; i < 26; i++)
            arr[i] = Math.min(temp[i],arr[i]); // 这一步骤非常重要
    }

    public static void main(String[] args) {
        _1002_Find_Common_Characters test = new _1002_Find_Common_Characters();
        String[] A = {"bella","label","roller"};
        test.commonChars(A);
        System.out.println('l' - 'a');
    }
}
