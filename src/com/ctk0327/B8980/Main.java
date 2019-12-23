package com.ctk0327.B8980;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int C=sc.nextInt();
        int M=sc.nextInt();
        int ans=0;
        int [] trucks=new int[N];
        ArrayList<Node> ar=new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            ar.add(new Node(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }

        ar.sort((a,b)->{
            if(a.end==b.end){
                return a.start-b.start;
            }else{
                return a.end-b.end;
            }
        });

        for (int i = 0; i < M; i++) {
            int max=0;
            int min=0;
            int from=ar.get(i).start;
            int to=ar.get(i).end;
            int w=ar.get(i).w;

            for (int j = from; j <to ; j++) {
                max=Math.max(max,trucks[j]);
            }
            min=Math.min(C-max,w);
            ans+=min;

            for (int j = from; j <to ; j++) {
                trucks[j]+=min;
            }
        }

        System.out.println(ans);
    }
}
class Node{
    int start;
    int end;
    int w;

    public Node(int start, int end, int w) {
        this.start = start;
        this.end = end;
        this.w = w;
    }

    @Override
    public String toString() {
        return start+" "+end+ " "+w;
    }
}
