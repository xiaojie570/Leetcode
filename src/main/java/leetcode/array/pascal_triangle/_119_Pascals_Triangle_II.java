package leetcode.array.pascal_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/9.
 * 杨辉三角
 * 给定一个层数，这个题的杨辉三角的层数是从0层开始
 */
public class _119_Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            ret.add(0,1);
            for(int j = 1; j < ret.size() - 1; j++) {
                ret.set(j, ret.get(j) + ret.get(j + 1));
            }
        }
        return ret;
    }
}
