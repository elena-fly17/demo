package com.example.demo.fromLeetcode;

import java.util.HashMap;
import java.util.Map;

// 1 ЗАДАЧА ИЗ СПИСКА BLIND CURATED 75
public class Solution_1 {

    public int[] twoSumFromLeetcode(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
