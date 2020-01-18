package com.ctk0327.B9205;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int T, N;
    static int[][] con;
    static int Max=102;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            con = new int[N + 2][N + 2];
            ArrayList<Node> ar = new ArrayList<>();
            for (int j = 0; j < N+2; j++) {
                ar.add(new Node(sc.nextInt(), sc.nextInt()));
            }

            for (int j = 0; j < N + 2; j++) {
                for (int k = 0; k < N + 2; k++) {
                    if (j != k) {
                        con[j][k] = Max;
                    }
                }
            }

            for (int j = 0; j < N + 2; j++) {
                for (int k = 0; k < N + 2; k++) {
                    if (j == k) { continue; }
                    Node now = ar.get(j);
                    Node next = ar.get(k);
                    int dist = Math.abs(now.x - next.x) + Math.abs(now.y - next.y);

                    if (dist <= 1000) { con[j][k] = 1;}
                }
            }

            for (int j = 0; j < N + 2; j++) {
                for (int k = 0; k < N + 2; k++) {
                    for (int l = 0; l < N + 2; l++) {
                        if (con[k][l] > con[k][j] + con[j][l]) {
                            con[k][l] = con[k][j] + con[j][l];
                        }
                    }
                }
            }
            System.out.println(0 < con[0][N + 1] && con[0][N + 1] < Max? "happy":"sad");
        }
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
