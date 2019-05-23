package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/23.
 * 找出数组的一个分界点长度，使得这个分界点左边的元素都小于分界点右边的元素
 */
public class _915_Partition_Array_into_Disjoint_Intervals {
    public int partitionDisjoint(int[] A) {
        int ret = 0;
        int num = A[0];
        int max = num; // 存储的是最大的元素
        for(int i = 1; i < A.length; i++) {
            max = Math.max(max,A[i]);   // 看当前元素和已存在的最大的元素之间的大小
            if(num > A[i]) {  // 如果当前元素小于上一次知道的最大元素要【小】，那肯定要更新位置了。
                num = max; // 存储的是当前的最大的元素
                ret = i;
            }
        }
        return ret + 1;
    }

    public static void main(String[] args) {
        _915_Partition_Array_into_Disjoint_Intervals test = new _915_Partition_Array_into_Disjoint_Intervals();
        int[] A = {5,0,3,8,6};
        test.partitionDisjoint(A);
    }
}
