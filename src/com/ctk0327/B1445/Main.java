package com.ctk0327.B1445;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import java.io.*;
import java.util.*;
public class Main{
    static int n,m,sx,sy,ans1,ans2,sideNum;
    static char[][] map;
    static int[][] dir= {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][] v;
    static int[][] memoside,memopass,dpside,dppass;
    static String s;
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new char[n][m];
        memoside=new int[n][m];
        memopass=new int[n][m];
        dppass=new int[n][m];
        dpside=new int[n][m];
        v=new boolean[n][m];
        for(int i=0;i<n;++i) {
            s=br.readLine();
            for(int j=0;j<m;++j) {
                map[i][j]=s.charAt(j);
                if(map[i][j]=='S') {
                    sx=i; sy=j;
                }
                dppass[i][j]=Integer.MAX_VALUE;
                dpside[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {

                if(map[i][j]=='S' || map[i][j]=='F') continue;
                if(map[i][j]=='.' && checkSide(i,j))
                    memoside[i][j]=1;
                else if(map[i][j]=='g')
                    memopass[i][j]=1;
            }
        }
        ans1=Integer.MAX_VALUE;
        ans2=Integer.MAX_VALUE;

        v[sx][sy]=true;
        dfs(sx,sy,0,0);
        System.out.println(ans1+" "+ans2);
    }
    static void dfs(int x, int y, int pass, int side) {
        if(ans1<pass) return;
        if(ans1==pass && ans2<=side) return;
        if(dppass[x][y]<pass) return;
        if(dpside[x][y]<side) return;

        if(map[x][y]=='F') {
            if(ans1>pass) {
                ans1=pass;
                ans2=side;
            }
            else if(ans1==pass) {
                if(ans2>side) {
                    ans2=side;
                }
            }

            return;
        }

        for(int i=0;i<4;++i) {
            int nx=x+dir[i][0];
            int ny=y+dir[i][1];
            if(nx>=0 && ny>=0 && nx<n && ny<m
               && !v[nx][ny]) {


                if(memopass[nx][ny]==1) {
                    if(dppass[nx][ny]<pass+1) continue;

                    dppass[nx][ny]=pass+1;

                    v[nx][ny]=true;
                    dfs(nx,ny,pass+1,side);
                    v[nx][ny]=false;
                }
                //두 개 별개로 다뤄줘야
                else if(memoside[nx][ny]==1) {

                    if(dppass[nx][ny]==pass
                       && dpside[nx][ny]<side+1)
                        continue;
                    dpside[nx][ny]=side+1;

                    v[nx][ny]=true;
                    dfs(nx,ny,pass,side+1);
                    v[nx][ny]=false;
                }
                else {
                    v[nx][ny]=true;
                    dfs(nx,ny,pass,side);
                    v[nx][ny]=false;
                }

            }
        }
    }

    static boolean checkSide(int x, int y) {
        boolean flag=false;
        int tempx=0; int tempy=0;
        for(int i=0;i<4;++i) {
            tempx=x+dir[i][0];
            tempy=y+dir[i][1];
            if(tempx>=0 && tempy>=0 && tempx<n &&tempy<m
               && map[tempx][tempy]=='g')//방문했는지 여부는 상관없다

            {
                flag=true;//쓰레기 옆에 있다
                break;
            }
        }
        return flag;
    }
}