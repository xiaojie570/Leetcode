package leetcode.tree.easy;

import java.util.List;

/**
 * Created by lenovo on 2019/4/20.
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
