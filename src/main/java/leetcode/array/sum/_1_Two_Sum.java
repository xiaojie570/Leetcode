package leetcode.array.sum;

/**
 * 2019/4/11.
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 给一个数组，和一个目标值，返回数组中和为目标值的两个数。
 */
public class _1_Two_Sum {
    /**
     * 利用【位图】来解题。时间复杂度O（n）
     * 1. 定义一个位图数组，数组的长度是2047。
     * 2. 每次循环都得到当前值与目标的差值different，
     * 3. 同时每个值都放到对应位图上面，位图的下标对应nums数组的值，位图的值对应nums数组的下标
     * 4. 用差值different去找位图对应的位置是否有值，如果有就说明找到了符合条件的两个数。
     *
     * CSDN: https://blog.csdn.net/xiaojie_570/article/details/91880093
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int t=2048;
        int bitMode=t-1;
        int[] temp=new int[t];
        int length=nums.length;
        int firstValue=nums[0];

        for(int i=1;i<length;i++){
            int different=target-nums[i];
            int current=nums[i];
            if(different==firstValue) {
                return new int[] {0,i};
            }
            int differentIndex=temp[different&bitMode];
            if(differentIndex!=0){
                return new int[] {differentIndex,i};
            }
            int currentIndex=current&bitMode;
            temp[currentIndex]=i;
        }
        return new int[2];
    }
    public static void main(String[] args) {
        int[] nums = {3,4,10,9,1,11,2};
        _1_Two_Sum test = new _1_Two_Sum();
        int [] ret = test.twoSum(nums,6);
        for(int i : ret)
            System.out.println(i);
    }
}
