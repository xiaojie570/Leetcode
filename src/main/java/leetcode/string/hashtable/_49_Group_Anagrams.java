package leetcode.string.hashtable;

import java.util.*;

/**
 * Created by lenovo on 2019/5/20.
 *  将给定的字符串数组按照相同的字母分组。
 *  【解题思路】
 *         使用hashmap来实现该题。
 *         1. 首先将每个单词按照字典顺序排序，然后以这个顺序作为hash的键，以真正的顺序作为hash的值
 *         2. 然后将再从hash中获取所有的字符串集合。
 */
public class _49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            List<String> list = hashMap.get(String.valueOf(arr));
            if(list == null)
                list = new ArrayList<String>();
            list.add(str);
            hashMap.put(String.valueOf(arr),list);
        }
        for(List<String> s : hashMap.values()) {
            Collections.sort(s);
            ret.add(s);
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "cba";
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for(char c: arr) {
            System.out.println(c);
        }
    }
}
