    package com.ctk0327.B1509;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.Scanner;

    public class Main {
        static String tempInput;
        static String[] input;
        static boolean[][] isPel;
        static int[] dp;
        static int length;
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            tempInput=sc.nextLine();
            length=tempInput.length();
            input=new String[length+1];
            for (int i = 1; i <=length ; i++) {
                input[i]=tempInput.substring(i-1,i);
            }
            isPel=new boolean[length+1][length+1];
            for (int j = 0; j < length; j++) {
                for (int i = 1; i + j <= length; i++) {
                    if (j == 0) {
                        isPel[i][i + j] = true;
                    } else if (j == 1 && input[i].equals(input[i + j])) {
                        isPel[i][i + j] = true;
                    } else {
                        if (isPel[i + 1][i + j - 1] && input[i].equals(input[i + j])) {
                            isPel[i][i + j] = true;
                        }
                    }
                }
            }
            dp=new int[length+1];

            for (int i = 1; i <=length ; i++) {
                for (int j = 1; j <=i ; j++) {
                    if(isPel[j][i]){
                        if(dp[i]==0 || dp[j-1]+1<dp[i]) {
                            dp[i] = dp[j-1] + 1;
                        }
                    }
                }
            }
            System.out.println(dp[length]);
        }
    }
