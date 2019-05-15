package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/15.
 *  要求任意两个事件不能有重叠的部分，如果插入这个事件会导致重合，则插入失败，不进行插入；否则插入并返回true
 */
public class _729_My_Calendar_I {
    int l,r;
    _729_My_Calendar_I left, right;
    public _729_My_Calendar_I(int start, int end) {
        l = start;
        r = end;
    }
    _729_My_Calendar_I root = null;
    public boolean book(int start, int end) {
        if(root == null) {
            root = new _729_My_Calendar_I(start,end);
        } else {
            _729_My_Calendar_I cur = root;
            _729_My_Calendar_I pre = null; // 父节点
            boolean leftTag = false; // 插入的结点是左孩子还是右孩子
            while(cur != null) {
                pre = cur;
                if(cur.l > end) {  // 如果要插入的元素大于左边的值，则到左边查找
                    leftTag = true;
                    cur = cur.left;
                } else if(cur.r < start) { // 如果要插入的值大于右边的值，则到右边查找
                    leftTag = false;
                    cur = cur.right;
                } else  // 否则说明有重叠，直接返回
                    return  false;
            }
            if(leftTag) { // 到这里说明可以插入元素，那么就将元素插入进来
                pre.left = new _729_My_Calendar_I(start,end);
            } else{
                pre.right = new _729_My_Calendar_I(start,end);
            }
        }
        return true;
    }
}
