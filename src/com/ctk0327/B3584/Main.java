package com.ctk0327.B3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N, root;
    static int first,second;
    static int result;
    static boolean[] check;
    static int[] depth;
    static int[] parent;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        while (T > 0) {
            N = Integer.parseInt(bf.readLine());
            depth = new int[N + 1];
            check = new boolean[N + 1];
            parent = new int[N + 1];

            for (int i = 1; i < N; i++) {
                st = getStringTokenizer(bf.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                parent[y] = x;
            }
            for (int i = 1; i <= N; i++) {
                if (parent[i] == 0) {
                    root = i;
                }
            }

            Arrays.fill(depth, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(root);
            check[root] = true;
            depth[root] = 0;
            parent[root] = 0;

            for (int i = 1; i <= N; i++) {
                depth[i] = getDepth(i);
            }

            st=getStringTokenizer(bf.readLine()," ");
            first=Integer.parseInt(st.nextToken());
            second=Integer.parseInt(st.nextToken());
            
            result=getNCA(first,second);
            
            System.out.println(result);

            T--;
        }
    }

    private static int getNCA(int first, int second) {
        if(depth[first]<depth[second]){
            int temp=first;
            first=second;
            second=temp;
        }
        while(depth[first]!=depth[second]){
            first=parent[first];
        }
        while(first!=second){
            first=parent[first];
            second=parent[second];
        }
        return first;
    }

    private static int getDepth(int i) {
        if (depth[i] !=-1) {
            return depth[i];
        } else {
            return getDepth(parent[i])+1;
        }

    }

    static StringTokenizer getStringTokenizer(String input, String dem) {
        StringTokenizer st = new StringTokenizer(input, dem);
        return st;
    }
}
