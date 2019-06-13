package leetcode.array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lenovo on 2019/4/11.
 * 三个数相加等于0
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/91880976
 */
public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        // 在需要频繁读取集合中的元素时，使用ArrayList效率较高，而在插入和删除操作较多时，使用LinkedList效率较高。
        // 对于此题来说两种都可以。
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 0; i+2 < num.length; i++) {
            // if num[i] already larger than 0, lo and hi will both larger than 0
            if(num[i] > 0) break;
            // 为了保证不加入重复的 list,因为是有序的，所以如果和前一个元素相同，只需要继续后移就可以
            // i==0，正常寻找另两个数；i>0且当前元素不同于前一个元素，正常寻找前两个值
            // i>0且当前元素与前一个元素相同，直接进入下一循环，否则本次找到的三个数会与上个循环的三个数完全相同
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                // lo将从前往后遍历，且不与i相同；hi为从后往前遍历
                int lo = i+1;
                int hi = num.length-1;
                int sum = 0 - num[i];

                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {

                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        // 重复元素跳过
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if(num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
