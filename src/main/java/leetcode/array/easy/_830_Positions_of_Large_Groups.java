package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/9.
 * 给定一个数组，找到数组中连续字符出现次数大于三的字符起始下标和结束下标
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 *
 * 【解题思路】
 *   1. 遍历数组，定义一个变量 count 记录连续的重复字符出现的次数, 定义一个变量j 表示当前的字符的位置，
 *   2. 使用变量 j 来进行while循环，判断后面的元素是否和前面的元素相等，如果相等则将count++，j++>
 *   3. 如果次数变量count的值 >=3就满足条件，这个时候把其实元素的下标和终止元素的下标存储起来，然后记住将i的下标变为j，这样可以加快速度。
 */
public class _830_Positions_of_Large_Groups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        char[] arr = S.toCharArray();
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            count = 1;
            int j = i;
            while(j < arr.length - 1 && arr[j] == arr[j + 1]) {
                count ++;
                j++;
            }
            if(count >= 3) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                list.add(j);
                i = j;
                ret.add(list);
            }
        }
        return ret;
    }
}
