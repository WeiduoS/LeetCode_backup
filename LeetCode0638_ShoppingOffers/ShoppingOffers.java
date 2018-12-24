package LeetCode0638_ShoppingOffers;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers {
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //System.out.println(needs);
        int res = 0;
        for(int i = 0; i < needs.size(); i++) {
            res += price.get(i) * needs.get(i);
        }
        
        for(List<Integer> coupon : special) {
            List<Integer> next_needs = new ArrayList<>();
            int i;
            for(i = 0; i < coupon.size() - 1; i++) {
                if(needs.get(i) < coupon.get(i)) break;
                next_needs.add(needs.get(i) - coupon.get(i));
            }
            //System.out.println("i: " + i + ", coupon.size(): " + coupon.size());
            if(i != coupon.size() - 1) continue;
            res = Math.min(res, shoppingOffers(price, special, next_needs) + coupon.get(coupon.size() - 1));
        }
        return res;
    }
}
