package com.ctk0327.B1018;

import java.util.Scanner;

public class Main {
    static String[][] input;
    static String[][] checks1 = {
            { "W", "B", "W", "B", "W", "B", "W", "B" }, { "B", "W", "B", "W", "B", "W", "B", "W" },
            { "W", "B", "W", "B", "W", "B", "W", "B" }, { "B", "W", "B", "W", "B", "W", "B", "W" },
            { "W", "B", "W", "B", "W", "B", "W", "B" }, { "B", "W", "B", "W", "B", "W", "B", "W" },
            { "W", "B", "W", "B", "W", "B", "W", "B" }, { "B", "W", "B", "W", "B", "W", "B", "W" }
    };

    static String[][] checks2 = {
            { "B", "W", "B", "W", "B", "W", "B", "W" }, { "W", "B", "W", "B", "W", "B", "W", "B" },
            { "B", "W", "B", "W", "B", "W", "B", "W" }, { "W", "B", "W", "B", "W", "B", "W", "B" },
            { "B", "W", "B", "W", "B", "W", "B", "W" }, { "W", "B", "W", "B", "W", "B", "W", "B" },
            { "B", "W", "B", "W", "B", "W", "B", "W" }, { "W", "B", "W", "B", "W", "B", "W", "B" }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        input = new String[N][M];
        String line;
        for (int i = 0; i < N; i++) {
            line = sc.nextLine();
            input[i] = line.split("");
        }
        int diffMin=Integer.MAX_VALUE;
        for (int i = 0; i <=N-8 ; i++) {
            for (int j = 0; j <=M-8 ; j++) {
                int diff1=checDiff(checks1,i,j);
                int diff2=checDiff(checks2,i,j);

                if(diff1<diffMin){
                    diffMin=diff1;
                }
                if(diff2<diffMin){
                    diffMin=diff2;
                }
            }
        }
        System.out.println(diffMin);
    }

    private static int checDiff(String[][] checks, int i, int j) {
        int count=0;
        for (int k = 0; k <8 ; k++) {
            for (int l = 0; l <8 ; l++) {
                if(!checks[k][l].equals(input[k+i][l+j])){
                    count++;
                }
            }
        }
       return count;
    }
}
