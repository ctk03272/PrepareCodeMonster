package com.ctk0327.B1021;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int N,T,count=0;
    static Deque<Integer> dq;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        T=sc.nextInt();
        dq=new LinkedList<>();
        for (int i = 1; i <=N ; i++) {
            dq.offer(i);
        }
        for (int i = 0; i <T ; i++) {
            int find=sc.nextInt();
            count+=getCount(i,find);
        }
        System.out.println(count);
    }

    private static int getCount(int i,int find) {
        int length=dq.size();
        int get=0;
        int tempCount=0;
        while(true){
            get=dq.poll();
            if(find==get){
                break;
            }
            dq.offer(get);
            tempCount++;
        }
        if(tempCount>length/2){
            return length-tempCount;
        }else{
            return tempCount;
        }
    }
}
