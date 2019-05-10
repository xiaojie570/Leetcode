package leetcode.array.easy;

import java.util.HashMap;

/**
 * Created by lenovo on 2019/5/10.
 * 给定一副牌，每张牌上都写着一个整数。此时：
 * 你需要选定一个数字X,使我们可以将整副牌按照下述规则分为1组或者更多组：
 *  规则一：每组有X张牌
 *  规则二：组内所有牌上都写着相同的整数
 *  仅当你可选的 X >= 2 时返回 true
 */
public class _914_X_of_a_Kind_in_a_Deck_of_Cards {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i: deck)
            hashMap.put(i,hashMap.getOrDefault(i,0) + 1);
        int min = Integer.MAX_VALUE;
        for(int num : hashMap.values()) {
            if(num < 2)
                return false;
            min = Math.min(min,num); // 找到最小的重复元素的个数
        }
        for(int val: hashMap.values()) {
            boolean flag = false;
            for(int j = 2; j <= min;j++) {
                if(val % j == 0) {
                    flag = true;
                    break;
                }
            }
            if(flag == false)
                return false;
        }
        return true;
    }
}
