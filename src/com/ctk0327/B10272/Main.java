package com.ctk0327.B10272;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int T, N;
    static double answer;
    static ArrayList<Node> ar;
    static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T > 0) {
            answer = Double.MAX_EXPONENT;
            ar = new ArrayList<>();
            N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                ar.add(new Node(sc.nextInt(), sc.nextInt()));
            }
            getAnswer(ar.get(0), 1, true, 0, new boolean[N]);
            System.out.println(answer);
            T--;
        }
    }

    private static void getAnswer(Node prev, int index, boolean isUp, double sum, boolean[] isVisited) {
        if (sum > answer) {
            return;
        }

        if (isUp) {
            if (index == N) {
                isUp = false;
                index = index - 2;
            } else {
                Node now = ar.get(index);
                if(index ==N-1){
                    isVisited[index] = true;
                    getAnswer(now, index + 1, isUp, sum + getDist(prev, now), isVisited);
                }else{
                    isVisited[index] = true;
                    getAnswer(now, index + 1, isUp, sum + getDist(prev, now), isVisited);
                    isVisited[index] = false;
                    getAnswer(prev, index + 1, isUp, sum, isVisited);
                }
            }
        }

        if (!isUp) {
            if (index == -1) {
                if (sum < answer) {
                    answer = sum;
                }
                return;
            }
            Node now = ar.get(index);
            if (isVisited[index]) {
                getAnswer(prev, index - 1, isUp, sum, isVisited);
            } else {
                getAnswer(now, index - 1, isUp, sum + getDist(prev, now), isVisited);
            }
        }
    }

    private static double getDist(Node prev, Node now) {
        return Math.sqrt(Math.pow(prev.x - now.x, 2) + Math.pow(prev.y - now.y, 2));
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
