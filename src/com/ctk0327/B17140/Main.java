package com.ctk0327.B17140;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {
    static int r, c, k;
    static int[][] input;
    static int count = 0;
    static int R, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = new int[101][101];
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();
        R = 3;
        C = 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        while (input[r - 1][c - 1] != k && count<=100) {
            if (R >= C) {
                int MAX=C;
                for (int i = 0; i < R; i++) {
                    int count=0;
                    int[] temp = caculR(input[i]);
                    int length = temp.length;
                    for (int j = 0; j < length; j++) {
                        if(temp[j]!=0){
                            count++;
                        }
                        input[i][j] = temp[j];
                    }
                    if(count>MAX){
                        MAX=count;
                    }
                }
                C=MAX;
            } else {
                int MAX=R;
                for (int i = 0; i < C; i++) {
                    int count=0;
                    int[] tempInput = new int[C];
                    for (int j = 0; j < C; j++) {
                        tempInput[j] = input[j][i];
                    }
                    int[] temp = caculR(tempInput);
                    int length = temp.length;
                    for (int j = 0; j < length; j++) {
                        if(temp[j]!=0){
                            count++;
                        }
                        input[j][i] = temp[j];
                    }
                    if(count>MAX){
                        MAX=count;
                    }
                }
                R=MAX;
            }
            count++;
        }
        System.out.println(count>100?-1:count);
    }

    private static int[] caculR(int[] tempInput) {
        Node[] nodeList = new Node[101];
        int size = tempInput.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (tempInput[i] != 0) {
                if (nodeList[tempInput[i]] == null) {
                    nodeList[tempInput[i]] = new Node(tempInput[i], 1);
                } else {
                    nodeList[tempInput[i]].count = nodeList[tempInput[i]].count + 1;
                }
                count++;
            }
        }
        Arrays.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                } else if (o1 == null) {
                    return 1;
                } else if (o2== null) {
                    return -1;
                } else {
                    return o1.count - o2.count;
                }
            }
        });
        int index = 0;
        int[] result = new int[101];
        for (int i = 0; i < 101; i++) {
            if(index>100){
                continue;
            }
            if (nodeList[i] != null) {
                result[index++] = nodeList[i].value;
                result[index++] = nodeList[i].count;
            }
        }
        return result;
    }
}

class Node  {
    int value;
    int count;

    public Node(int value, int count) {
        this.value = value;
        this.count = count;
    }


}