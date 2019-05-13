package leetcode.array.subsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/13.
 */
public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        for(int num: nums) {
            int size = ret.size();
            for(int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<Integer>(ret.get(i));
                temp.add(num);
                ret.add(temp);
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        _78_Subsets test = new _78_Subsets();
        int a[] = {1,2,3};
        test.subsets(a);
    }
}
