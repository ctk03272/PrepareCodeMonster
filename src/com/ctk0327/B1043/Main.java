package com.ctk0327.B1043;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M, P, K;
    static ArrayList<Integer> know;
    static ArrayList<ArrayList<Integer>> ar;
    static boolean[] isAdd;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        P = sc.nextInt();
        isAdd=new boolean[M];
        know = new ArrayList<>();
        for (int i = 0; i < P; i++) {
            know.add(sc.nextInt());
        }
        ar=new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int L = sc.nextInt();
            ArrayList<Integer> temp=new ArrayList<>();
            for (int j = 0; j < L; j++) {
                temp.add(sc.nextInt());
            }
            ar.add(temp);
        }

        while(true){
            int beforeLength = know.size();

            for (int i = 0; i <M ; i++) {
                boolean isContain=false;
                ArrayList<Integer> ar2=ar.get(i);
                int length=ar2.size();
                for (int j = 0; j < length; j++) {
                    if(know.contains(ar2.get(j))){
                        isContain=true;
                    }
                }
                if(isContain && !isAdd[i]){
                    isAdd[i]=true;
                    know.addAll(ar2);
                }
            }

            int afterLength=know.size();
            if(beforeLength==afterLength){
                break;
            }
        }
        int result=0;
        for (int i = 0; i < M; i++) {
            if(!isAdd[i]){
                result++;
            }
        }
        System.out.println(result);
    }
}
