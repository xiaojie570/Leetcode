package leetcode.array.medium;

import java.util.TreeMap;

/**
 * Created by lenovo on 2019/5/15.
 * 要求任意三个事件不能有重复的部分，但是两个时间可以有重叠。同样是成果返回true,失败返回false
 * 【解题思路】
 *      用TreeMap保存所有事件开始及终止的位置以及他们的次数，<start, 次数（正）> 和 <end, 次数（负）>。
 *      要插入这个事件的实现过程是：先插入这个事件，再检测这个事件如果会导致 > 2个区间有重合，则取消插入，返回false，否则返回true。
 *      检测的方法：遍历 treemap中的entry（Treemap是有序的）。cnt+=entry.getValue()记录当前时刻开始了还没结束的事件个数。
 */
public class _731_My_Calendar_II {
    TreeMap<Integer,Integer> treeMap;

    public _731_My_Calendar_II() {
        treeMap = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        int a = treeMap.getOrDefault(start,0); // 开始的次数
        int b = treeMap.getOrDefault(end,0); // 结束的次数
        treeMap.put(start,a + 1);
        treeMap.put(end,b - 1);
        int count = 0;
        for(int value : treeMap.values()) {
            count += value;  // 记录当前已经开始但是还没有结束的事件的个数
            if(count > 2) {  // 如果事件的个数超过2个，说明有三个或者以上的重叠，不满足条件，则取消刚刚的插入
                if(a == 0) { // 如果插入前的个数为 0 ，则可以直接删除这条记录，否则对次数进行修改。
                    treeMap.remove(start);
                } else
                    treeMap.put(start,a);
                if(b == 0) {
                    treeMap.remove(end);
                } else
                    treeMap.put(end, b);
                return  false;
            }
        }
        return true;
    }
}
