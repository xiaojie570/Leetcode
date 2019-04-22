package leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/4/22.
 * 删除评论
 */
public class _722_Remove_Comments {
    public List<String> removeComments(String[] source) {
        if(source == null || source.length == 0) return null;
        List<String> ret = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        boolean ignore = false;
        for(String line : source) {
            final int N = line.length();
            for(int i = 0 ; i < N; i++) {
                char ch = line.charAt(i);
                if(ignore) {
                    if(ch == '*' && i < N - 1 && line.charAt(i + 1) == '/'){ // 找到评论结束的文职
                        ignore = false;
                        i ++;
                    }
                } else {
                    if(ch == '/' && i < N - 1) { // 如果从这开始有了 注释的开始符号，要分两种注释，一种是 // 另一种是 /**/
                        char nextChar = line.charAt(i + 1);
                        if(nextChar == '/')
                            break;
                        else if(nextChar == '*'){
                            ignore = true;
                            i ++;
                            continue;
                        }
                    }
                    sb.append(line.charAt(i)); // 这一部分是没有被注释掉的内容
                }
            }
            if(!ignore && sb.length() > 0) { // 如果当前行没有被注释，并且当前行有内容，则将当前行放到list中
                ret.add(sb.toString()); // 将当前行放到返回的list中
                sb = new StringBuilder();
            }
        }
        return ret;
    }
}
