package leetcode.array.pascal_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/9.
 * 杨辉三角
 * 【解题思路】
 *   这个解题方法很清奇，是使用一个list，不断更新这个list来得到新的一层的元素的值的。
 *   要注意一些细小的条件
 */
public class _118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < numRows; i++) {
            list.add(0,1); // 每一行的第一个二元素都是1,
            for(int j = 1; j < list.size() - 1; j ++) {  // 遍历到前一个是因为保留最后一个元素，最后一个元素都是1
                list.set(j,list.get(j) + list.get(j + 1));

            }
            ret.add(new ArrayList<Integer>(list)); // 这里注意要新new出来一个。不能直接将list放进去。
        }
        return ret;
    }

    public static void main(String[] args) {
        _118_Pascals_Triangle test = new _118_Pascals_Triangle();
        test.generate(5);
    }
}
