package leetcode.array.design;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by lenovo on 2019/5/16.
 */
public class _380_Insert_Delete_GetRandom_O_1 {
    private HashMap<Integer, Integer> keyMap = null;
    private HashMap<Integer, Integer> valueMap = null;
    int count;

    /** Initialize your data structure here. */
    public _380_Insert_Delete_GetRandom_O_1() {
        keyMap = new HashMap<Integer, Integer>();
        valueMap = new HashMap<Integer, Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(keyMap.containsKey(val)) {
            return false;
        } else {
            keyMap.put(val, count);
            valueMap.put(count, val);
            count = keyMap.size();
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!keyMap.containsKey(val)) {
            return false;
        } else {
            int valueKey = keyMap.get(val);
            keyMap.remove(val);
            if(valueKey != valueMap.size() - 1) {
                valueMap.put(valueKey, valueMap.get(valueMap.size() - 1));
                keyMap.put(valueMap.get(valueMap.size() - 1), valueKey);
                valueMap.remove(valueMap.size() - 1);
            } else {
                valueMap.remove(valueKey);
            }
            count = keyMap.size();
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int n = random.nextInt(keyMap.size());
        return valueMap.get(n);
    }
}
