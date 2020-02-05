package com.ctk0327.B2666;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] input;
    static int[] dest;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N - 2];
        answer = Integer.MAX_VALUE;
        int first = sc.nextInt();
        int second = sc.nextInt();
        if (first > second) {
            int temp = first;
            first = second;
            second = first;
        }
        M = sc.nextInt();
        dest = new int[M];
        for (int i = 0; i < M; i++) {
            int temp = sc.nextInt();
            dest[i] = temp;
        }
        getAnswer(0, first, second, 0);
        System.out.println(answer);
    }

    private static void getAnswer(int index, int first, int second, int sum) {
        if (index == M) {
            if (sum < answer) {
                answer = sum;
            }
            return;
        }
        if (sum > answer) {
            return;
        }
        int target=dest[index];
        ArrayList<Node> ar=new ArrayList<>();
        ar.add(new Node(target,second,Math.abs(target-first)));
        ar.add(new Node(first,target,Math.abs(target-second)));
        ar.sort((o1, o2) ->o1.sum-o2.sum);
        for (int i = 0; i <2 ; i++) {
            getAnswer(index+1,ar.get(i).first,ar.get(i).second,sum+ar.get(i).sum);
        }
    }
}
class Node{
    int first;
    int second;
    int sum;

    public Node(int first, int second, int sum) {
        this.first = first;
        this.second = second;
        this.sum = sum;
    }
}