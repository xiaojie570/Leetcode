package leetcode.string.easy;

/**
 * Created by lenovo on 2019/4/18.
 * 机器人能否回到原点。
 * 【解题思路】
 *  1. 定义两个变量，一个是保存上下方向，一个是保存左右方向。
 *
 *  CSDN: https://blog.csdn.net/xiaojie_570/article/details/93387478
 */
public class _657_Robot_Return_to_Origin {
    public boolean judgeCircle(String moves) {
        int lr = 0;
        int ud = 0;
        for(char c: moves.toCharArray()) {
            if(c == 'L') lr ++;
            else if(c == 'R') lr --;
            else if(c == 'U') ud ++;
            else if(c == 'D') ud --;
        }
        return lr == 0 && ud == 0;
    }
}
