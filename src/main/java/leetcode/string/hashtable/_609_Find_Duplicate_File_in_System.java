package leetcode.string.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lenovo on 2019/5/19.
 * 这道题给了我们一堆字符串数组，每个字符串中包含了文件路径，文件名称和内容，让我们找到重复的文件，这里只要文件内容相同即可，不管文件名是否相同，而且返回结果中药带上文件的路径。不带文件的内容
 * 【解题思路】
 *      1. 把路径、文件名和文件内容从一个字符串中拆出来。建立一个 文件内容 和  文件路径+文件名 组成的数组的映射，因为可能会有多个文件有相同的内容，所以这里需要数组。
 *      2. 然后把分离出的路径和文件名拼接在一起，最后我们只要找到哪些映射的数组元素个数多于1个，这就说明有重复的文件，我们把整个数组加入结果 ret中即可。
 */
public class _609_Find_Duplicate_File_in_System {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ret = new ArrayList<List<String>>();
        HashMap<String,List<String>> hashMap = new HashMap<String, List<String>>();  // key: 文件的内容 ； value：文件的路径+文件名
        for(String path : paths) {
            String[] p = path.split(" ");  // 按照空格将不同的文件放到字符串数组里面
            String dir = null; //存放字符串的主路径
            for(int i = 0; i < p.length; i++) {
                if(i == 0) {
                    dir = p[i]; // 字符串的主路径；
                } else {  // 每个字符串名字和内容
                    String file = p[i];
                    String content = file.substring(file.indexOf("(") + 1, file.indexOf(")")); // 每个字符串的内容
                    String contentPath = dir + "/" + file.substring(0,file.indexOf("(")); // 字符串的路径
                    if(hashMap.containsKey(content)) // 如果文件的内容是一样的，那么将文件的路径放到对应文件内容的value中
                        hashMap.get(content).add(contentPath);
                    else { // 如果之前没有这个内容的文件，则就新new一个位置给这个内容
                        List<String> list = new ArrayList<String>();
                        list.add(contentPath);
                        hashMap.put(content,list);
                    }
                }
            }
        }
        for(String content : hashMap.keySet()) {
            List<String> list = hashMap.get(content);
            if (list.size() > 1)
                ret.add(list);
        }
        return ret;
    }
}
