package leetcode.array.easy;

/**
 * Created by lenovo on 2019/5/10.
 * 本题要求到最近人的最大距离，实际就是0距离两侧1的最大距离问题。
 * 【解题思路】
 *      1. 要求距两侧 1 的距离，可以通过求解两个 1 之间 0 的个数，假设 0 的个数为 i，则距离两侧最近的距离是 (i + 1) /2;
 *      2. 还要考虑到以 0 开始的距离的问题，以及以0结尾的位置问题
 *      3. 最终求出最大距离即可。
 */
public class _849_Maximize_Distance_to_Closest_Person {
    public int maxDistToClosest(int[] seats) {
        if(seats == null || seats.length == 0)
            return 0;
        int maxLength = 0,localLength = 0;
        for(int num: seats) {
            localLength = (num == 1 ? 0 : ++localLength);
            maxLength = Math.max(maxLength,(localLength + 1) /2); // 计算最远距离
        }
        for(int i = 0 ; i < seats.length; i++) { // 当开始位置为0的时候
            if(seats[i] == 1) {
                maxLength = Math.max(maxLength, i);
                break;
            }
        }
        for(int i = seats.length - 1; i >= 0; i--) {  // 当结束位置为0的时候
            if(seats[i] == 1) {
                maxLength = Math.max(maxLength,seats.length - 1 - i);
                break;
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        _849_Maximize_Distance_to_Closest_Person test = new _849_Maximize_Distance_to_Closest_Person();
        int[] a = {1,0,0,0};
        test.maxDistToClosest(a);
    }
}
