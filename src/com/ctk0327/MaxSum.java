package com.ctk0327;
import java.util.List;
import java.util.Arrays;

public class MaxSum {
    public static int findMaxSum(List<Integer> list) {
        int firstMax=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        int listLength=list.size();
        for (int i = 0; i < listLength; i++) {
            int now=list.get(i);
            if(now>secondMax){
                if(now>firstMax){
                    secondMax=firstMax;
                    firstMax=now;
                }else{
                    secondMax=now;
                }
            }
        }
        return firstMax+secondMax;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        System.out.println(findMaxSum(list));
    }
}
