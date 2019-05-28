package leetcode.dp.medium;

/**
 * Created by lenovo on 2019/5/28.
 * 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
 * 在开始时，我们同时把一些多米诺骨牌向左或者向右推。
 * 倒向左边的骨牌会推动竖立在其右侧的相邻多米诺骨牌。
 * 倒向右边的骨牌会推动竖立在其左侧的相邻多米诺骨牌。
 *
 * 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
 *
 *
 */
public class _838_Push_Dominoes {
    public String pushDominoes(String dominoes) {
        char[] res = dominoes.toCharArray();
        int i = 0;
        while (i < res.length && res[i] == '.') {  // 从头开始找到第一个不是【竖直】的骨牌
            i++;
        }
        if (i < res.length) {
            if (res[i] == 'L'){  // 如果当前的是 偏向左边的，就将前面的所有竖直的骨牌变为向左的骨牌
                for (int j = 0;j < i;j++) {
                    res[j] = res[i];
                }
            }
            int j = i+1 ;  // 指向当前元素的下一个元素
            for (; j < res.length; j++) {
                if (res[j]!='.') {  // 下一个元素不为 竖直的
                    if (res[j] == res[i]) { // 如果当前元素和前一个最接近的非竖直的元素的偏向是一样的
                        for (int k = i+1; k < j; k++) { // 则将这中间的元素都变为这个偏向的
                            res[k] = res[i];
                        }
                    } else if (res[j] == 'L' && res[i] =='R'){  // 如果当前元素是朝向右边的，下一个元素是朝向左边的
                        int k1 = i+1;
                        int k2 = j-1;
                        while(k1 < k2) {
                            res[k1++] = res[i];
                            res[k2--] = res[j];
                        }
                    }
                    i = j;  //
                }
            }
            if (res[i]=='R') {
                for (int k = i+1; k < res.length; k++) {
                    res[k] = res[i];
                }
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        _838_Push_Dominoes test = new _838_Push_Dominoes();
        String s = ".L.R...LR..L..";
        test.pushDominoes(s);
    }
}
