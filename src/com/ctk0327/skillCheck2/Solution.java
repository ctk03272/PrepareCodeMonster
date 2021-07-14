package com.ctk0327.skillCheck2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] checked=new boolean[500001];
        for (int i = 2; i*i <=50000 ; i++) {
            if(checked[i]==true){
                continue;
            }
            for (int j = i+i; j <=50000 ; j=j+i) {
                checked[j]=true;
            }
        }
        int length=nums.length;
        for (int i = 0; i <length ; i++) {
            for (int j = i+1; j <length ; j++) {
                for (int k = j+1; k <length ; k++) {
                    if(checked[nums[i]+nums[j]+nums[k]]){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}