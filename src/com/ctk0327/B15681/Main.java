package com.ctk0327.B15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,R,Q;
    static int[] size;
    static ArrayList<Integer>[] node;
    static ArrayList<Integer>[] childNode;
    static int[] parentNode;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=getTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());
        size=new int[N+1];
        parentNode=new int[N+1];
        node=new ArrayList[N+1];
        childNode=new ArrayList[N+1];
        for (int i = 1; i <=N ; i++) {
            childNode[i]=new ArrayList<>();
            node[i]=new ArrayList<>();
        }

        int start,end;
        for (int i = 0; i <N-1 ; i++) {
            st=getTokenizer(bf.readLine());
            start=Integer.parseInt(st.nextToken());
            end=Integer.parseInt(st.nextToken());
            node[start].add(end);
            node[end].add(start);
        }
        makeTree(R,-1);
        countSubTree(R);
        for (int i = 0; i <Q ; i++) {
            System.out.println(size[Integer.parseInt(bf.readLine())]);
        }

    }
    static StringTokenizer getTokenizer(String input){
        StringTokenizer st= new StringTokenizer(input);
        return st;
    }

    static void makeTree(int currentNode,int parent){
        for (int nextNode:node[currentNode]) {
            if(nextNode!=parent){
                childNode[currentNode].add(nextNode);
                parentNode[nextNode]=currentNode;
                makeTree(nextNode,currentNode);
            }
        }
    }

    static void countSubTree(int currentNode){
        size[currentNode]=1;
        for (int nextNode:childNode[currentNode]) {
            countSubTree(nextNode);
            size[currentNode]+=size[nextNode];
        }
    }
}
