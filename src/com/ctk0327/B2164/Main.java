package com.ctk0327.B2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int result;
    static Queue<Integer> que;
    static boolean add=false;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        que= new LinkedList<>();
        for (int i = 1; i <=N ; i++) {
            que.offer(i);
        }

        while (!que.isEmpty()){
            if(!add){
                result=que.poll();
                add=true;
            }else {
                que.add(que.poll());
                add=false;
            }
        }
        System.out.println(result);
    }
}
