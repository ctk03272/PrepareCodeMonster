package com.ctk0327.B15804;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int n, m;
    static Bus[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        input = new Bus[m];
        for (int i = 0; i < m; i++) {
            input[i] = new Bus(sc.nextInt(), sc.nextInt());
        }
        Deque<Bus> deque = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Bus nowIn = input[i];
            if (deque.isEmpty()) {
                nowIn.index = 0;
                deque.offerFirst(nowIn);
            } else {
                int m = nowIn.t;
                while (!deque.isEmpty() && deque.peekFirst().p + deque.peekFirst().t <= m) {
                    deque.pollFirst();
                }
                if(deque.isEmpty()){
                    nowIn.index=0;
                    deque.offerFirst(nowIn);
                    continue;
                }
                if (deque.peekLast().index !=n-1){
                    nowIn.index=deque.peekLast().index+1;
                    deque.offerLast(nowIn);
                }else{

                }
            }
        }
        System.out.println(deque.peekLast().index+1);
    }
}

class Bus {
    int t;
    int p;
    int index;

    public Bus(int t, int p) {
        this.t = t;
        this.p = p;
        this.index = -1;
    }
}
