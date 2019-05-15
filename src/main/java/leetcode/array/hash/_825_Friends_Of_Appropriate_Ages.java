package leetcode.array.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019/5/15.
 */
public class _825_Friends_Of_Appropriate_Ages {
    public int numFriendRequests(int[] ages) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Arrays.sort(ages);
        int ret = 0;
        int sum = 0;
        for(int i = 0; i < ages.length; i++) {
            if(map.containsKey(ages[i])){
                ret += map.get(ages[i]);
                continue;
            }
            sum = 0;
            for(int j = 0; j < ages.length; j++) {
                if(i != j && requestOrNot(ages[i],ages[j]))
                    sum++;
            }
            ret += sum;
            map.put(ages[i], sum);
        }
        return ret;
    }
    public boolean requestOrNot(int A, int B) {
        if(B > 100 && A < 100)
            return false;
        else if(B > A)
            return false;
        else if(B <= 0.5 * A + 7)
            return false;
        else
            return true;
    }
}
