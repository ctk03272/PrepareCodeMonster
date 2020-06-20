package com.ctk0327.ThreeSum;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, ArrayLi> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(-nums[i], i);
        }

    }
}
