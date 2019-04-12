package leetcode.dp.climb_stairs;

/**
 * Created by lenovo on 2019/4/12.
 * 斐波那契数列
 * 与爬楼梯有一点点区别，就是第一个数是0和1的时候斐波那契数列是不一样的。
 * 注意循环里面要把i ++
 */
public class _509_Fibonacci_Number {
    public int fib(int N) {
        int[] num = new int[N + 2];
        num[0] = 0;
        num[1] = 1;
        int i = 2;
        while(i <= N + 1) {
            num[i] = num[i - 1] + num[i - 2];
            i++;
        }
        return num[N];

    }
}
