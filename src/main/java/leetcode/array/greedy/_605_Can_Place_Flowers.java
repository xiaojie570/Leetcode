package leetcode.array.greedy;

/**
 * Created by lenovo on 2019/5/10.
 * 给定一个花圃flowerbed 和 n盘花，看这n盘花能否被放到花圃中，放置的原则是相邻的两个小plots不能都放花。1代表原来有花，0代表原来没有花。
 * 【解题思路】
 * 贪婪法，只要可以插入就插入，每插入一个元素，就将这个元素的值变为1，n--。  最后判断n的值是否是小于等于0的即可。一定要小于等于零。因为可能给定的位置可以插入更多的元素。
 */
public class _605_Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                int prev = (i == 0) ? 0: flowerbed[i - 1];
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                if(prev == 0 && next == 0) {
                    n --;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }
}
