package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/23.
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 */
public class _228_Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if(nums.length == 1) {
            ret.add(nums[0] + "");
            return ret;
        }
        for(int i = 0; i < nums.length; i++) {
            int start  = nums[i];
            while(i < nums.length - 1 && nums[i] + 1 == nums[i + 1])
                i++;
            if(start != nums[i])
                ret.add(start + "->" + nums[i]);
            else
                ret.add(start + "");
        }
        return  ret;
    }
}
