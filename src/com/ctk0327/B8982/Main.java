package com.ctk0327.B8982;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, length;
    static int[] height;
    static int[] answer;
    static ArrayList<Node> input;
    static ArrayList<Integer> hole;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            input.add(new Node(x, y));
            if (length < x) {
                length = x;
            }
        }
        height = new int[length + 1];
        answer=new int[length];
        int arSize = input.size();
        for (int i = 0; i < arSize; i++) {
            int x = input.get(i).x;
            int y = input.get(i).y;
            if (height[x] < y) {
                height[x] = y;
            }
        }
        for (int i = 1; i < length; i++) {
            if (height[i] == 0) {
                if (height[i - 1] != 0 && height[i + 1] != 0) {
                    height[i] = Math.max(height[i - 1], height[i + 1]);
                } else {
                    if (height[i + 1] == 0) {
                        height[i] = height[i - 1];
                    }
                }
            }
        }
        int M = sc.nextInt();
        hole=new ArrayList<>();
        for (int i = 0; i < M; i++) {
            hole.add(sc.nextInt());
            sc.nextInt();
            sc.nextInt();
            sc.nextInt();
        }

        for (int i = 0; i <M ; i++) {
            makeLength(hole.get(i));
        }
        int ans=0;
        for (int i = 0; i < length; i++) {
            ans+=height[i]-answer[i];
        }
        System.out.println(ans);
    }

    private static void makeLength(Integer integer) {
        int h=height[integer];
        answer[integer]=h;
        for (int i = integer-1; i >=0; i--) {
            if(h>height[i]){
                h=height[i];
            }
            if(answer[i]<h){
                answer[i]=h;
            }
        }

        for (int i = integer+1; i < length; i++) {
            if(h>height[i]){
                h=height[i];
            }
            if(answer[i]<h){
                answer[i]=h;
            }
        }
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
