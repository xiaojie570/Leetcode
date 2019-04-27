package leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/4/27.
 * 存储IP地址，将所有可能的IP地址都存储起来
 */
public class _93_Restore_IP_Addresses {
    List<String> list = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        int length = s.length();
        if(length > 3 && length < 13)
            help(s,new char[length + 3],list,0,0,0);
        return list;
    }

    private void help(String s, char[] chars, List<String> list, int count, int start, int i) {
        int digest = 0;
        for(int l = start; l < 3 + start && l < s.length();l++) {
            digest = digest * 10 + (s.charAt(l) - '0');
            if(digest > 255) return;
            chars[i ++] = s.charAt(l);
            if(count == 3) {
                if(l + 1 == s.length()) list.add(new String(chars));
            } else {
                chars[i] = '.';
                help(s,chars,list,count + 1, l + 1,i + 1);
            }
            if(digest == 0)
                return;
        }
    }

    public static void main(String[] args) {
        _93_Restore_IP_Addresses test = new _93_Restore_IP_Addresses();
        test.restoreIpAddresses("25525511135");
    }
}
