package leetcode.array.two_pointer;

/**
 * Created by lenovo on 2019/5/15.
 * 给一个数组，用数组来装水，返回最多能装多少水
 */
public class _11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ret = 0;
        while(left < right) {
            int h = Math.min(height[left],height[right]);
            ret = Math.max(ret, h * (right - left));
            while(left < right && height[left] <= h) left ++;
            while(left < right && height[right] <= h) right --;
        }
        return ret;
    }
}
