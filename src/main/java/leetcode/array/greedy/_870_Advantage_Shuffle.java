package leetcode.array.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lenovo on 2019/5/16.
 * 如何安排A的各个数字，使得对于每个位置 A[i]> B[i] 的情况最多。
 * 【解题思路】
 *      田忌赛马：用自己比对方强一点点的马去战胜对方的马，如果对方的马太强了，
 *      那么就用自己的最弱的马去参加比赛。这样做的好处是我们用自己的弱马消耗掉对方的精锐。这样自己获胜的概率最大。
 *
 *      这个题：使用自己最弱的去战胜对方最弱的，如果不能战胜对方最弱的就去干掉对方最强的。
 */
public class _870_Advantage_Shuffle {
    public int[] advantageCount(int[] A, int[] B) {


        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(
                /*(int[] a, int[] b) -> {
                    return Integer.compare(b[0], a[0]);
                }*/
        );

        for(int i = 0; i < B.length; ++i) {
            maxHeap.add(new int[] {B[i], i});
        }

        Arrays.sort(A);
        int[] result = new int[A.length];

        int minIndex = 0, maxIndex = A.length-1;
        while(!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            if(A[maxIndex] > curr[0]) {
                result[curr[1]] = A[maxIndex--];
            }
            else {
                result[curr[1]] = A[minIndex++];
            }
        }

        return result;
    }
}
