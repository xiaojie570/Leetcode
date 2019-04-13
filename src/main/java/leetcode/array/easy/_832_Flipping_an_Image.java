package leetcode.array.easy;

/**
 * Created by lenovo on 2019/4/13.
 * 反转二维数组。将每一行反转，然后对应的1变为0 ，0变为1
 * 签到题，主要考察代码不出错的能力
 */
public class _832_Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int[] a:A){
            reverse(a);
            flip(a);
        }
        return A;
    }
    public void reverse(int []a) {
        int j = a.length-1,i=0;
        while(i<j) {
            int temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }
    public void flip(int[] a) {
        for(int i=0;i<a.length;i++)
            a[i]= (a[i]==0)?  1 : 0;
    }
}
