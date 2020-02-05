package com.ctk0327.B17143;

import java.util.Scanner;

public class Main {
    static int R, C, M;
    static int[][] input;
    static int answer;
    static Shark[] sharkList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();
        input = new int[R + 1][C + 1];
        sharkList = new Shark[M + 1];
        for (int i = 1; i <= M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();
            sharkList[i] = new Shark(r, c, s, d, z, i);
            input[r][c] = i;
        }

        for (int i = 1; i <= C; i++) {
            getShark(i);
            moveShark();
        }
        System.out.println(answer);
    }

    private static void moveShark() {
        int length = sharkList.length;
        for (int i = 1; i < length; i++) {
            Shark shark = sharkList[i];
            int totald = 0;
            if (shark == null || shark.s == 0) {
                continue;
            }
            if (shark.d == 1) {
                totald = (R - shark.r) + shark.s;
                int a = (totald - 1) / (R - 1);
                int b = (totald - 1) % (R - 1);
                if ((a) % 2 == 0) {
                    shark.r = R - b - 1;
                } else {
                    shark.r = 2 + b;
                    shark.d = 2;
                }
            } else if (shark.d == 2) {
                totald = shark.r + shark.s - 1;
                int a = (totald - 1) / (R - 1);
                int b = (totald - 1) % (R - 1);
                if ((a) % 2 == 0) {
                    shark.r = 2 + b;
                } else {
                    shark.d = 1;
                    shark.r = R - b - 1;
                }
            } else if (shark.d == 4) {
                totald = (C - shark.c) + shark.s;
                int a = (totald - 1) / (C - 1);
                int b = (totald - 1) % (C - 1);
                if ((a) % 2 == 0) {
                    shark.c = C - b - 1;
                } else {
                    shark.c = 2 + b;
                    shark.d = 3;
                }
            } else if (shark.d == 3) {
                totald = shark.c + shark.s - 1;
                int a = (totald - 1) / (C - 1);
                int b = (totald - 1) % (C - 1);
                if (a % 2 == 0) {
                    shark.c = 2 + b;
                } else {
                    shark.d = 4;
                    shark.c = C - b - 1;
                }
            }
        }
        int[][] newInPut = new int[R + 1][C + 1];
        for (int i = 1; i < length; i++) {
            Shark shark = sharkList[i];
            if (shark != null) {
                int r = shark.r;
                int c = shark.c;
                if (newInPut[r][c] == 0) {
                    newInPut[r][c] = i;
                }else{
                    int prevZ=sharkList[newInPut[r][c]].z;
                    int noWZ=shark.z;
                    if(noWZ>prevZ){
                        sharkList[newInPut[r][c]]=null;
                        newInPut[r][c]=i;
                    }else{
                        sharkList[i]=null;
                    }
                }
            }
        }
        input=newInPut;
    }

    private static void getShark(int i) {
        for (int j = 1; j <= R; j++) {
            if (input[j][i] != 0) {
                answer += sharkList[input[j][i]].z;
                sharkList[input[j][i]] = null;
                input[j][i] = 0;
                break;
            }
        }
    }
}

class Shark {
    int r;
    int c;
    int s;
    int d;
    int z;
    int number;

    public Shark(int r, int c, int s, int d, int z, int number) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
        this.number = number;
    }
}