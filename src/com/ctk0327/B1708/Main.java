package com.ctk0327.B1708;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static Dot[] input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        input=new Dot[N];
        for (int i = 0; i < N; i++) {
            input[i]=new Dot(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(input);

        for (int i = 1; i < N; i++) {
            input[i].p=input[i].x-input[0].x;
            input[i].q=input[i].y-input[0].y;
        }
        Arrays.sort(input,1,N-1);

        Stack<Integer> st=new Stack<>();
        st.push(0);
        st.push(1);

        int next=2;

        while(next<N){
            while(st.size()>=2){
                int first,second;
                second=st.pop();
                first=st.peek();
                if(ccw(new Vector(input[first],input[second]),new Vector(input[second],input[next]))>=0){
                    st.push(second);
                    break;
                }
            }
            st.push(next++);
        }

        System.out.println(st.size());

    }
    static int ccw(Vector vector1,Vector vector2){
        int result=vector1.x*vector2.y-vector1.y*vector2.x;
        return result;
    }
}

class Vector{
    Dot start;
    Dot end;
    int x;
    int y;
    public Vector(Dot start, Dot end) {
        this.start = start;
        this.end = end;
        x=end.x-start.x;
        y=end.y-start.y;
    }
}

class Dot implements Comparable<Dot>{
    int x;
    int y;

    int p;
    int q;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Dot dot) {
        if(this.q*dot.p!=this.p*dot.q){
            return (int)((long)(this.q*dot.p)-(long)this.p*dot.q);
        }else{
            if(this.y!=dot.y){
                return this.y-dot.y;
            }else{
                return this.x-dot.x;
            }
        }
    }
}