package leetcode.string.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lenovo on 2019/5/20.
 * 在给定单词列表 wordlist 的情况下，我们希望实现一个拼写检查器，将查询单词转换为正确的单词。
 对于给定的查询单词 query，拼写检查器将会处理两类拼写错误：
 大小写：如果查询匹配单词列表中的某个单词（不区分大小写），则返回的正确单词与单词列表中的大小写相同。
 例如：wordlist = ["yellow"], query = "YellOw": correct = "yellow"
 例如：wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
 例如：wordlist = ["yellow"], query = "yellow": correct = "yellow"
 元音错误：如果在将查询单词中的元音（‘a’、‘e’、‘i’、‘o’、‘u’）分别替换为任何元音后，能与单词列表中的单词匹配（不区分大小写），则返回的正确单词与单词列表中的匹配项大小写相同。
 例如：wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
 例如：wordlist = ["YellOw"], query = "yeellow": correct = "" （无匹配项）
 例如：wordlist = ["YellOw"], query = "yllw": correct = "" （无匹配项）
 此外，拼写检查器还按照以下优先级规则操作：
 当查询完全匹配单词列表中的某个单词（区分大小写）时，应返回相同的单词。
 当查询匹配到大小写问题的单词时，您应该返回单词列表中的第一个这样的匹配项。
 当查询匹配到元音错误的单词时，您应该返回单词列表中的第一个这样的匹配项。
 如果该查询在单词列表中没有匹配项，则应返回空字符串。
 给出一些查询 queries，返回一个单词答案列表 answer，其中 answer[i] 是由查询 query = queries[i] 得到的正确单词。
 ---------------------
 作者：GQxxxxxl
 来源：CSDN
 原文：https://blog.csdn.net/GQxxxxxl/article/details/85719175
 版权声明：本文为博主原创文章，转载请附上博文链接！


 【解题思路】
        1. 使用 一个hashSet来存储原来的wordlist中的字符串，用set为了去重，使用 一个 hashtable来存储原来的字符串对应的小写字符串，使用一个hashtable来存储替元音的字符串
        2. 将wordlist 存储到对应的hashset\和两个 hashtable中
 */
public class _966_Vowel_Spellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String, String> map1 = new HashMap<String, String>(); // 存储字符串对应的小写字符串
        HashMap<String, String> map2 = new HashMap<String, String>();
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < wordlist.length; i++){ // 这个循环是将wordlist 中的元素放到set 和map中
            String word = wordlist[i];
            set.add(word);
            word = word.toLowerCase();
            if(!map1.containsKey(word)){
                map1.put(word, wordlist[i]);
            }
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    builder.append('*');
                }else{
                    builder.append(c);
                }
            }
            String str = builder.toString();
            if(!map2.containsKey(str)){
                map2.put(str, wordlist[i]);
            }
        }
        String[] res = new String[queries.length];
        for(int i = 0; i < queries.length; i++){  // 如果直接有重复的字符串，则直接将它放到返回的字符串数组中即可
            String word = queries[i];
            if(set.contains(word)){
                res[i] = word;
                continue;
            }
            word = word.toLowerCase();
            if(map1.containsKey(word)){  // 如果将所有元素都变为小写的，然后找到相同的字符串，则直接将原串放到返回字符串数组中
                res[i] = map1.get(word);
                continue;
            }
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    builder.append('*');
                }else{
                    builder.append(c);
                }
            }
            String str = builder.toString();
            if(map2.containsKey(str)){
                res[i] = map2.get(str);
                continue;
            }
            res[i] = ""; // 如果没有匹配的，则将这个位置的字符串设置为空。
        }
        return res;
    }
}
