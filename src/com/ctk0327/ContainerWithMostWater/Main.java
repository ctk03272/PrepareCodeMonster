package com.ctk0327.ContainerWithMostWater;

public class Main {
    public static void main(String[] args) {
    }

    static int maxArea(int[] height) {
        int first = 0;
        int second = height.length - 1;
        int max = Math.min(height[first], height[second]) * Math.abs(first - second);
        while (first<second){
            max=Math.max(max,Math.min(height[first], height[second]) * Math.abs(first - second));
            if(height[first]<height[second]){
                first++;
            }else{
                second--;
            }
        }
        return max;
    }
}
