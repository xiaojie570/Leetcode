package leetcode.string.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/5/21.
 * 给一段文字和一个禁止的单词列表，找出文段中出现最多的单词。
 * 【解题思路】
 *      1. 首先定义一个set，用于存放禁止的单词列表
 *      2. 定义一个hashmap，用于存放每个单词，和对应的出现的次数，   key 存放单词， value存放单词出现的次数。
 *      3. 遍历文字段，首先要找到每个单词，每次遍历都找到一个单词，然后将这个单词截取出来，判断其是否是禁止单词，如果不是禁止单词记录出现的次数，如果是禁止单词就不记录出现的次数
 *      4. 记录完出现的次数后，每个单词后面都会有空格，所以再将空格移动一下。
 *      5. 最后遍历hashmap,因为这里面不存禁止单词，所以直接找到hashmap中出现频率最高的单词即可。
 */
public class _819_Most_Common_Word {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<String>();  //
        HashMap<String ,Integer> hashMap = new HashMap<String, Integer>();  // 放每个单词出现的次数的，key为单词，value为单词出现的次数
        for(String s : banned) set.add(s.toLowerCase()); // 将禁止的单词放到set集合中
        int start = 0, end = 0, length = paragraph.length();
        while(end < length) {
            while(end < length && Character.isAlphabetic(paragraph.charAt(end))) end ++;  // 找到单词
            String temp = paragraph.substring(start,end).toLowerCase();
            if(!set.contains(temp)) {  // 如果不是禁止的单词，就将该单词的次数累加
                hashMap.put(temp,hashMap.getOrDefault(temp,0) + 1);
            }
            while(end < length && ! Character.isAlphabetic(paragraph.charAt(end))) end ++; // 不是字符，所以要向后移动，找到是字符的位置。
            start = end; // 下一个字符是 字母
            end = end + 1; // 新的单词的第一个字母
        }
        String ret ="";
        int count = 0;
        for(String temp : hashMap.keySet()) {  // 找到出现的最多的次数的单词，然后返回即可。
            if(count < hashMap.get(temp)) {
                ret = temp;
                count = hashMap.get(temp);
            }
        }
        return ret;
    }
}
