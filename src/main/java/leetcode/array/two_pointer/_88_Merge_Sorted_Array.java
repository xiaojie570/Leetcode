package leetcode.array.two_pointer;

/**
 * Created by lenovo on 2019/5/10.
 * 合并两个有序数组
 */
public class _88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1, secod = n - 1; //从后面往前
        int index = nums1.length - 1;
        while(first >= 0 && secod >= 0) {
            while(first >= 0 && secod >= 0 && nums1[first] <= nums2[secod]) {
                nums1[index --] = nums2[secod --];
            }
            while(first >= 0 && secod >= 0 && nums1[first] > nums2[secod]) {
                nums1[index --] = nums1[first --];
            }
        }
        while(secod >= 0) {
            nums1[index --] = nums2[secod --];
        }
    }

    public static void main(String[] args) {
        _88_Merge_Sorted_Array test = new _88_Merge_Sorted_Array();
        int [] a = {4,5,0,0};
        int[] b = {1,2};
        test.merge(a,2,b,2);
    }
}
