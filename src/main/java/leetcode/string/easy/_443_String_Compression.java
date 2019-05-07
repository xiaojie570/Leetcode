package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/7.
 * Input:
 * ["a","a","b","b","c","c","c"]
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 */
public class _443_String_Compression {
    public int compress(char[] chars) {
        int retIndex = 0;
        for(int i = 0,count = 0; i < chars.length;i++) {
            count ++;
            if(i == chars.length - 1 || chars[i] != chars[i + 1]) {
                chars[retIndex ++] = chars[i];
                if(count > 1) {
                    for(char c : String .valueOf(count).toCharArray())
                        chars[retIndex ++] = c;
                }
                count = 0;
            }
        }
        return retIndex;
    }

    public static void main(String[] args) {
        for(char c : String.valueOf(2).toCharArray())
        {
            System.out.println(c);
        }
        System.out.println( String.valueOf(2).toCharArray().length);
    }
}
