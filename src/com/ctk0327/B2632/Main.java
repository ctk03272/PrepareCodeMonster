package com.ctk0327.B2632;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] inputN;
    static int[] inputM;
    static int sum;
    static boolean[] check;
    static ArrayList<Integer> ar1;
    static ArrayList<Integer> ar2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sum = sc.nextInt();
        M = sc.nextInt();
        N = sc.nextInt();
        inputM = new int[M];
        inputN = new int[N];

        ar1=new ArrayList<>();
        ar2=new ArrayList<>();

        for (int i = 0; i < M; i++) {
            inputN[i] = sc.nextInt();
            check=new boolean[N];
            check[i]=true;
            getAll(i,i,inputM,ar1);
        }
        for (int i = 0; i < N; i++) {
            inputM[i]=sc.nextInt();
        }
    }

    private static void getAll(int i,int j,int[] input,ArrayList<Integer> ar) {
        int sum=0;
        for (int k = i; k <=j ; k++) {
            sum+=input[k];
        }
        if(!ar.contains(sum)){
            ar.add(sum);
        }
    }
}
