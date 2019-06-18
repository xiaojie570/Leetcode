package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/6.
 * 检查是否是Capital
 * 1. 所有字母都是大写字母，是Capital
 * 2. 所有字母都是小写字母，是Capital
 * 3. 只有首字母是大写字母其余字母是小写字母，是Capital
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/92766570
 */
public class _520_Detect_Capital {
    public boolean detectCapitalUse(String word) {
        boolean flag = false, small = false;
        int count = 0;
        for(char c: word.toCharArray()) {
            if(c >= 65 && c <= 90) {
                if (small)
                    return false;
                flag = true;
                count ++;
            }
            else if(c >= 97 && c <= 122)
                small = true;
        }
        return  count == word.length() || count == 1 || count == 0;
    }

    public static void main(String[] args) {
        _520_Detect_Capital test = new _520_Detect_Capital();
        boolean ret = test.detectCapitalUse("FFFFFf");
        System.out.println(ret);
    }
}
