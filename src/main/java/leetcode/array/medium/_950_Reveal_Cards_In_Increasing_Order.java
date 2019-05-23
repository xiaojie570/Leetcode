package leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2019/5/23.
 * 按照给定的要求返回数组
 */
public class _950_Reveal_Cards_In_Increasing_Order {
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck == null || deck.length == 0)
            return deck;
        if(deck.length <= 1)
            return deck;
        Arrays.sort(deck);
        List<Integer> list = new ArrayList<Integer>();
        list.add(deck[deck.length - 2]);
        list.add(deck[deck.length - 1]);
        for(int i = deck.length - 3; i >= 0; i--) {
            list.add(0,list.remove(list.size() - 1));
            list.add(0,deck[i]);
        }
        int[] ret = new int[deck.length];
        for(int i = 0; i < ret.length; i++)
            ret[i] = list.get(0);
        return ret;
    }
}
