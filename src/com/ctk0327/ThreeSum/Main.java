package com.ctk0327.ThreeSum;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, ArrayLi> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(-nums[i], i);
        }
    }
}
