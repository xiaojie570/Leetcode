package leetcode.array.medium;

import java.util.ArrayDeque;

/**
 * Created by lenovo on 2019/4/17.
 * 返回所有子串中最小的元素的和
 */
public class _907_Sum_of_Subarray_Minimums {
    public int sumSubarrayMins(int[] A) {
        int res=0, modulo=(int)1e9+7;
        int lengthA =A.length;
        int[] loc=new int[lengthA];
        ArrayDeque<Integer> stack=new ArrayDeque<Integer>();
        stack.addFirst(0);
        for(int i=1;i<lengthA;i++){
            System.out.println(stack.peekFirst());
            if(stack.isEmpty()||A[stack.peekFirst()] <= A[i])
                stack.addFirst(i);
            else {
                while(!stack.isEmpty()&&A[stack.peekFirst()]>A[i]){
                    loc[stack.removeFirst()]=i;
                }
                stack.addFirst(i);
            }
        }
        while(!stack.isEmpty())loc[stack.removeFirst()]=lengthA;
        int[] dp=new int[lengthA+1];
        for(int i=lengthA-1;i>=0;i--){
            dp[i]=(loc[i]-i)*A[i]+dp[loc[i]];
        }
        for(Integer i:dp)res=(res+i)%modulo;
        return res;
    }

    public static void main(String[] args) {
        _907_Sum_of_Subarray_Minimums test = new _907_Sum_of_Subarray_Minimums();
        int[] A = {3,1,2,4};
        int ret =test.sumSubarrayMins(A);
        System.out.println(ret);
    }
}
