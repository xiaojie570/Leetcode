package leetcode.string.easy;

import java.util.*;

/**
 * Created by lenovo on 2019/5/6.
 * 有一个日志数组logs, 每条日志都是以空格分隔的字符串
 * 对于每条日志，其第一个字为字母数字标识符，然后，要么：
 *      1. 标识符后面的每个字符将仅由小写字母组成，或者：
 *      2. 标识符后面的每个字符仅由数字组成。
 *  我们将这两种日志分别称为【字母日志】和【数字日志】。保证每个日志在其标志否后面至少有一个字。
 *  将日志重新排序，使得所有字母日志都排在数字日志前。字母日志按照字母顺序排序，忽略标识符，标识符仅表示关系。
 *  数字日志按照原来的顺序排列。 返回日志的最终顺序。
 */
public class _937_Reorder_Log_Files {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            public int compare(String s1, String s2) {
                int s1si = s1.indexOf(' '); // 找到字符串 s1 的第一个空格
                int s2si = s2.indexOf(' '); // 找到字符串 s2 的第一个空格
                char s1fc = s1.charAt(s1si+1); //  // 找到字符串 s1 的第一个空格后面的元素
                char s2fc = s2.charAt(s2si+1); // 找到字符串 s2 的第一个空格后面的元素

                if (s1fc <= '9') {  // 如果第一个字符串是数字
                    if (s2fc <= '9') // 第二个字符歘也是数字
                        return 0;  // 返回 0
                    else
                        return 1; // 第一个字符串是数字，第二个字符串是字母，返回 1
                }
                if (s2fc <= '9') return -1;  // 第一个字符串是字母，第二个字符串是数字，返回 - 1

                int preCompute = s1.substring(s1si+1).compareTo(s2.substring(s2si+1));
                if (preCompute == 0)   // 如果都是字母或者都是数字，就要比较标志位的大小了
                    return s1.substring(0,s1si).compareTo(s2.substring(0,s2si));
                return preCompute;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }

    public static void main(String[] args) {
        String a = "ajla ssss";
        System.out.println(a.substring(a.indexOf(" ") + 1));
    }
}
