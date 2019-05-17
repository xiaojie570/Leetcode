package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/17.
 * 产生下一个序列，对给定序列进行重排，生成一个字母顺序比它更大的下一个序列。
 * 如果给定的序列已经是按照字母顺序排列中最大的一个了，则进行逆序排列。
 * 算法在数组内进行，不需要额外的空间。
 * 【解题思路】
 *      1. 首先长度为1的数组可以直接返回
 *      2. 正常的应该是逆序的话这样就可以吧最后一个元素放到第一个元素的位置了，所以从后向前寻找第一个不满足逆序的元素。
 *      3. 如果整个原始数组就是逆序的,就就最后一个元素放到第一个元素的位置就可以了
 *      4. 如果整个原始数组不是逆序的,那么就从i+1的位置向后查找比 num[i]大的元素即可
 */
public class _31_Next_Permutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        //长度为1的数组
        if (nums.length == 1) {
            return;
        }

        //从后向前找到第一个不满足逆序的元素
        int i = nums.length - 2;
        for(; i >= 0 && nums[i] >= nums[i + 1]; --i); //注意，这里有=，可以排除含有重复元素的情况

        // 从i+1位置开始，向后查找比nums[i]大的最小元素
        if(i >= 0){
            int j = i + 1;
            for(; j < nums.length && nums[j] > nums[i]; ++j);
            swap(nums,i,j - 1); //交换，注意是同 j - 1交换
        }

        //将i之后的元素逆置(这里包含一种特殊情况，若该排列已经是字典序中的最大了，则下一个序列应该是最小字典序，因此，直接在这里逆置即可)
        int k = nums.length - 1;
        i++;
        for(; i < k; i++, k--)
            swap(nums, i, k);
    }

    /**
     * 交换元素
     * @param array
     * @param i
     * @param j
     */
    public void swap(int[] array,int i ,int j){
        //交换
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
