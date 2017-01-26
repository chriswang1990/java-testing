package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by cwang on 1/26/2017.
 */
public class FrogJump {

    //can jump 1 with dp.
    public boolean canCross1(int[] stones) {
        int len = stones.length;
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < len; i++) {
            dp.add(new ArrayList<Integer>());
        }
        dp.get(0).add(0);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                for (int jump : dp.get(j)) {
                    int dist = stones[i] - stones[j];
                    if (jump - dist >= -1 && jump - dist <= 1 && dist >= 1) {
                        dp.get(i).add(dist);
                        break;
                    }
                }
            }
        }
        return dp.get(len - 1).size() != 0;
    }

    //HashMap + HashSet, dp solution 2;
    public boolean canCross2(int[] stones) {
        int len = stones.length;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < len; i++) {
            for (int prevStep : map.get(stones[i])) {
                for (int step = prevStep + 1; step >= prevStep - 1; step--) {
                    int pos = stones[i] + step;
                    if (step >= 1 && map.containsKey(pos)) {
                        map.get(pos).add(step);
                    }
                }
            }
        }
        return !map.get(stones[len - 1]).isEmpty();
    }
}
