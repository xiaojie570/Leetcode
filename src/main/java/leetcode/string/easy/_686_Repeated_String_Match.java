package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/8.
 * 给定两个字符串，A和B，让A重复多少次可以让B变为A的子串。
 * 【解题思路】
 *  1. 首先计算B的长度是A的多少倍count，如果B的长度不能完全整除A，则再将count ++
 *  2. 注意：这个地方要注意  A = "abcd" B = "cdabcdab"
 *
 *  CSDN: https://blog.csdn.net/xiaojie_570/article/details/93391823
 */
public class _686_Repeated_String_Match {
    public int repeatedStringMatch(String A, String B) {
        int lengthA = A.length(), lengthB = B.length();
        int count = lengthB / lengthA;
        if(lengthB % lengthA != 0) count ++;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++) {
            sb.append(A);
        }
        if(!sb.toString().contains(B)) {
            /**
             *  为了这个测试用例：
             * "abcd"
             * "cdabcdab"
             */
            sb.append(A);
            count++;
            if(!sb.toString().contains(B))
                return  - 1;
        }
        return count;
    }
}
