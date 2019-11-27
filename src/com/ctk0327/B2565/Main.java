package com.ctk0327.B2565;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static Dot[] dots;
    static int[] count;
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        count=new int[N+1];
        dots=new Dot[N + 1];
        dots[0]=new Dot(0,0);
        for (int i = 1; i <=N ; i++) {
            Dot dot=new Dot(sc.nextInt(), sc.nextInt());
            dots[i]=dot;
        }
        Arrays.sort(dots);
        for (int i = 1; i <=N ; i++) {
            count[i]=1;
            for (int j = 1; j <i ; j++) {
                if(!isCross(j,i) &&  count[i]<count[j]+1){
                    count[i]=count[j]+1;
                }
            }
        }
        for (int i = 1; i <=N ; i++) {
            if(max<count[i]){
                max=count[i];
            }
        }
        System.out.println(N-max);
    }

    private static boolean isCross(int j, int i) {
        if((dots[i].first>dots[j].first && dots[i].second>dots[j].second)||(dots[i].first<dots[j].first && dots[i].second<dots[j].second))
            return false;
        else
            return true;
    }
}
class Dot implements Comparable<Dot>{
    int first;
    int second;

    public Dot(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Dot o) {
        return this.first-o.first;
    }
}