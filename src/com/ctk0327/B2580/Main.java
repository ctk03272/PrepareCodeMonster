package com.ctk0327.B2580;

import java.util.Scanner;

public class Main {
    static int sdokuX[];
    static int sdokuY[];
    static int[][] sdoku;
    static int count;
    static boolean isEnd;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        sdoku=new int[10][10];
        sdokuX=new int[82];
        sdokuY=new int[82];
        count=0;
        int temp;
        for (int i = 1; i <=9 ; i++) {
            for (int j = 1; j <=9 ; j++) {
                temp=sc.nextInt();
                sdoku[i][j]=temp;
                if(temp==0){
                    count++;
                    sdokuX[count]=j;
                    sdokuY[count]=i;
                }
            }
        }

        for (int i = 1;i <=9; i++) {
            sdoku[sdokuY[1]][sdokuX[1]]=i;

            dfs(2);
        }

        System.out.println("??");
    }

    private static void dfs(int num) {
        if(num>count){
            printAnswer();
            System.exit(0);
        }else{
            for (int i = 1; i <=9 ; i++) {
                sdoku[sdokuY[num]][sdokuX[num]]=i;
                if(isPossible(num)){
                    dfs(num+1);
                }else{
                    sdoku[sdokuY[num]][sdokuX[num]]=0;
                }
            }
            sdoku[sdokuY[num]][sdokuX[num]]=0;
        }
    }

    private static boolean isPossible(int num) {
        if(crossPossible(num) && squarePossible(num)){
            return true;
        }else{
            return false;
        }
    }

    private static boolean squarePossible(int num) {
        int x=sdokuX[num];
        int y=sdokuY[num];
        int sum=0;
        boolean isValid=false;

        int startx=((x-1)/3)*3+1;
        int starty=((y-1)/3)*3+1;
        for (int i = starty; i <starty+3 ; i++) {
            for (int j = startx; j < startx+3; j++) {
                if(sdoku[i][j]==0){
                    isValid=true;
                }else{
                    if(sdoku[i][j]==sdoku[y][x]&& i!=y && j!=x){
                        return false;
                    }
                    sum+=sdoku[i][j];
                }
            }
        }
        if (isValid){
            return true;
        }else{
            if(sum==45){
                return true;
            }else{
                return false;
            }
        }
    }

    private static boolean crossPossible(int num) {
        int x=sdokuX[num];
        int y=sdokuY[num];

        int sumX=0;
        int sumY=0;

        boolean validX=false;
        boolean validY =false;
        for (int i = 1; i <=9 ; i++) {
            if(sdoku[y][i]==0){
                validY=true;
            }
            if(x!=i && sdoku[y][x]==sdoku[y][i]){
                validY=false;
                return false;

            }
            sumY+=sdoku[y][i];
        }
        if(!validY){
            if(sumY==45){
                validY=true;
            }
        }
        for (int i = 1; i <=9 ; i++) {
            if(sdoku[i][x]==0){
                validX=true;
            }
            if(y!=i&&sdoku[y][x]==sdoku[i][x]){
                validX=false;
                return false;
            }
            sumX+=sdoku[i][x];
        }

        if(!validX){
            if(sumX==45){
                validX=true;
            }
        }
        if(validX && validY){
            return true;
        }else{
            return false;
        }
    }

    private static void printAnswer() {
        isEnd=true;
        sb=new StringBuilder();
        for (int i = 1; i <=9 ; i++) {
            for (int j = 1; j <=9 ; j++) {
                sb.append(sdoku[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
