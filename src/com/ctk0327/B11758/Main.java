package com.ctk0327.B11758;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sin,x1,x2,x3,y1,y2,y3;
        x1=sc.nextInt();
        y1=sc.nextInt();
        x2=sc.nextInt();
        y2=sc.nextInt();
        x3=sc.nextInt();
        y3=sc.nextInt();
        Vector vector1=new Vector(new Dot(x1,y1),new Dot(x2,y2));
        Vector vector2=new Vector(new Dot(x2,y2),new Dot(x3,y3));
        int result=vector1.x*vector2.y-vector1.y*vector2.x;
        if(result==0){
            System.out.println(0);
        }else if(result>0){
            System.out.println(1);
        }else if(result<0){
            System.out.println(-1);
        }
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
class Dot{
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
