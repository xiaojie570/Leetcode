package leetcode.array.easy;

/**
 * Created by lenovo on 2019/5/8.
 * 找到给定数组中缺少的那个元素，只缺少了一个元素
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/92212109
 */
public class _268_Missing_Number {
    public int missingNumber(int[] nums) {
        int len=nums.length,Nsum=0,sum=0;
        Nsum=(len+1)*len/2;
        for(int i=0;i<len;i++)
            sum+=nums[i];
        return Nsum-sum;
    }
}
