package leetcode.dp.dfs;

import java.util.List;

/**
 * Created by lenovo on 2019/4/20.
 * 去商场买商品，有优惠政策。
 * 题目要求必须刚好满足购买数量的需求，不可少买也不可以多买，所以对于某种商品的需求数量，如果有一个数量小于所有special offer相应产品的数量，
 * 则不能使用任何special offer，只能以零售价购买。
 * 【注意】 用special offer不一定比不适用好，所以在存储相应的needs所对应的最低价时，初始值要设置为单价购买时的价格，
 */
public class _638_Shopping_Offers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, 0);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index) {
        int total = regular(price,needs);
        for(int j = index; j < special.size(); j++) {
            List<Integer> offer = special.get(j); // 遍历出每一种优惠
            int m = 0;
            while(m < needs.size() && offer.get(m) <= needs.get(m))  m++; // 遍历一下每种优惠政策，找到满足条件的优惠政策
            if(m == needs.size()) {
                while(--m >=  0) needs.set(m, needs.get(m) - offer.get(m)); // 因为使用了优惠所以需要将需要的商品的数量减少优惠中的对应产品的数量；
                total = Math.min(total, offer.get(offer.size() - 1) + dfs(price,special,needs,j)); // 计算使用零售价买划算还是使用优惠价买划算。
                while(++m < needs.size())
                    needs.set(m, needs.get(m) + offer.get(m)); // 要把上一步中使用到的优惠商品数量加上，继续进行dfs
            }
        }
        return total;
    }

    private int regular(List<Integer> price,List<Integer> needs) { // 用来计算以单价购买需要数量的商品时，需要花费的价格。
        if(price == null || needs == null) return 0;
        if(price.size() != needs.size()) return 0;
        int ret = 0;
        for(int i = 0; i < price.size(); i++) {
            ret += price.get(i) * needs.get(i);
        }
        return ret;
    }
}
