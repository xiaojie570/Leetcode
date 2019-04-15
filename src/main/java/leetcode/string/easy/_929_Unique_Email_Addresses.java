package leetcode.string.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/4/15.
 * 判断有多少个不重复的email.
 * 邮箱的规则是这样的：
 *      1. 域名部分不用管，只管用户名部分，
 *       1.1. 用户名中如果包含有'.'，那么把这个'.'给去掉；
 *       1.2. 如果用户名中有'+'，那么把加号以及后面的用户名部分全部去掉。
 */
public class _929_Unique_Email_Addresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> hashset = new HashSet<String>();
        for(String email: emails)
            hashset.add(process(email));
        return hashset.size();
    }

    private String process(String email) {
        int length = email.length();
        char[] process = new char[length];
        int index = 0,i = 0;
        while(i < length && (email.charAt(i) != '+') && email.charAt(i) != '@') {
            if(email.charAt(i) != '.')
                process[index ++] = email.charAt(i);
            i++;
        }

        while(i < length && email.charAt(i) != '@') i++; // 找到域名位置

        while(i < length)
            process[index++] = email.charAt(i++);
        return new String(process, 0, index);
    }
}
