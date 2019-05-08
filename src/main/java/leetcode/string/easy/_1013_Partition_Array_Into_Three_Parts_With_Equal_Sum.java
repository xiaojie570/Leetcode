package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/8.
 * 判断给定的数组是否可以分成三段和相同的子数组。 注意：需要连续
 * 【解题思路】
 *      1. 首先求数组的和sum，看sum能否被3整除，如果不能被整除，那么肯定不能分成三个和相同的子数组
 *      2. 然后求 三个子数组的和应该是多少 avg
 *      3. 循环遍历数组A，计算和的一部分;如果找到平均值，则将该部分重置为0，并增加计数器
 *      4. 如果平均可以看到至少3次，返回true;否则返回假
 */
public class _1013_Partition_Array_Into_Three_Parts_With_Equal_Sum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int num : A) sum += num;
        if(sum % 3 != 0) return false;
        int avg = sum / 3;
        int part = 0,count = 0;
        for(int num : A) {
            part += num;
            if(part != avg) continue;
            if( ++ count == 3) return true;
            part = 0;
        }
        return false;
    }
}
