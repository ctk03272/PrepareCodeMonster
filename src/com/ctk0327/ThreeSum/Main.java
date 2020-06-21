package com.ctk0327.ThreeSum;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
//        System.out.println(main.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(main.threeSum(new int[]{0,0,0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);

        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            if(nums[i]>0){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                if(sum>0){
                    continue;;
                }
                if (map.containsKey(-sum) && map.get(-sum) > j) {
                    List<Integer> ar = new ArrayList<>();
                    ar.add(nums[i]);
                    ar.add(nums[j]);
                    ar.add(-sum);
//                    if (!hasThisArray(answer, ar))
                    answer.add(ar);
                }
            }
        }
        return answer;
    }

/*    private boolean hasThisArray(List<List<Integer>> answer, List<Integer> ar) {
        boolean tempRet = false;
        for (List<Integer> temp : answer) {
            boolean eachTemp = true;
            for (Integer target : temp
            ) {
                if (!ar.contains(target)) {
                    eachTemp = false;
                }
            }
            if (eachTemp) {
                tempRet = true;
            }
        }
        return tempRet;
    }*/
}
