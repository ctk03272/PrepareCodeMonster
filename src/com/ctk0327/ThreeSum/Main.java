package com.ctk0327.ThreeSum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i <length ; i++) {
            for (int j = i+1; j <length ; j++) {
                int twoSum=nums[i]+nums[j];
                if(map.containsKey(-twoSum)){

                }
            }
        }
        return null;
    }
}
