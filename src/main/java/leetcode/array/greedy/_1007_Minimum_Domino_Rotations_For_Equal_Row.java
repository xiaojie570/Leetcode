package leetcode.array.greedy;

/**
 * Created by lenovo on 2019/5/16.
 * 有一拍多米诺骨牌，A和B分别代表每一个牌的正反面。现在要求我们翻转其中的一部分骨牌，使得正反面对调，能不能让A或者B出现完全相同的点数？
 * 如果可以的话，需要返回最少的反转次数。如果不可以，需要返回-1.
 */
public class _1007_Minimum_Domino_Rotations_For_Equal_Row {
    public int minDominoRotations(int[] A, int[] B) {
        int lengthA = A.length, lengthB = B.length;
        if(lengthA != lengthB)
            return -1;
        int ret = Integer.MAX_VALUE;
        loop:
        for(int i = 1; i <= 6; i ++) {
            int a = 0;
            int b = 0;
            for(int j = 0; j < lengthA; j++) {
                if(A[j] == i || B[j] == i) {
                    if(A[j] != i)
                        a ++;
                    if(B[j] != i)
                        b++;
                } else {
                    continue loop;  // 这个地方很好，不能使用break。因为使用break会执行下面的 ret = Math.min(ret, Math.min(a,b));这个语句，但是实际上走到这里说明不能让A或B出现全部值为i的元素。
                }
            }
            ret = Math.min(ret, Math.min(a,b));
        }
        return ret == Integer.MAX_VALUE ? - 1: ret;
    }
}
