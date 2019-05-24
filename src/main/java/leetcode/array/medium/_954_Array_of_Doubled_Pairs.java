package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/24.
 * Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 */
public class _954_Array_of_Doubled_Pairs {
    public boolean canReorderDoubled(int[] A) {
        int z[] = new int[20000];
        int f[] = new int[20000];
        for(int a: A) {
            if(a >= 0)
                z[a] ++;
            else
                f[-a] ++;
        }
        if((z[0] & 1) != 0)
            return false; // 如果0的个数是奇数，应该返回false
        for(int i = 1; i < 10000; i ++) {
            if(z[i] > 0)
                z[i << 1] -= z[i];
            else if(z[i] < 0)
                return false;
            if(f[i] > 0)
                f[i << 1] -= f[i];
            else if(f[i] < 0)
                return false;
        }
        for(int i = 10001; i < 20000; i++)
            if(z[i] != 0 || f[i] != 0)
                return  false;
        return true;
    }
}
