package leetcode.array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lenovo on 2019/5/9.
 * Input: [30,20,150,100,40]
 Output: 3
 Explanation: Three pairs have a total duration divisible by 60:
 (time[0] = 30, time[2] = 150): total duration 180
 (time[1] = 20, time[3] = 100): total duration 120
 (time[1] = 20, time[4] = 40): total duration 60
 */
public class _1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    public int numPairsDivisibleBy60(int[] time) {
        int [] module = new int[60];
        for(int i : time)
            module[i % 60] ++;
        int count = 0;
        for(int i = 0; i <= 30; i++) {
            if(module[i] == 0)
                continue; //剪枝法
            if(i == 0 || i == 30) {
                int value = module[i];
                count += (value * (value - 1) / 2);
            } else {
                count += module[i] * module[60- i];
            }
        }
        return count;
    }
}
