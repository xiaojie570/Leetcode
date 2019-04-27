package leetcode.dp.tree;

/**
 * Created by lenovo on 2019/4/27.
 * 给定一个数n，问从[1,n] 一共可以组成多少中 BST 树
 */
public class _96_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        if(n == 0 || n == 1)
            return 1;
        int[] F = new int[n + 1];
        F[0] = 1; F[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i;j++) {
                F[i] += F[j - 1] * F[i- j];
            }
        }
        return F[n];
    }
}
