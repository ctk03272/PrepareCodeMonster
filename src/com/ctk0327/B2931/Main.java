package com.ctk0327.B2931;

import java.util.Scanner;

public class Main {
    static char[][] input;
    static int R, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        input = new char[R][C];
        sc.nextLine();
        Node start = new Node();
        Node missing = new Node();
        for (int i = 0; i < R; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < C; j++) {
                input[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (input[i][j] == 'M') {
                    start.x = i;
                    start.y = j;
                    start.block = input[i][j];

                    if (canGoLeft(i, j)&& input[i][j-1]!='Z') {
                        start.direction = 1;
                    }
                    if (canGoRight(i, j) && input[i][j+1]!='Z') {
                        start.direction = 2;
                    }
                    if (canGoUp(i, j) && input[i-1][j]!='Z') {
                        start.direction = 3;
                    }
                    if (canGoDown(i, j) && input[i+1][j]!='Z') {
                        start.direction = 4;
                    }
                }
            }
        }
        while (true) {
            Node next = start.next();
            next.block = input[next.x][next.y];
            if (next.block == '.') {
                missing.x = next.x;
                missing.y = next.y;
                break;
            }
            start = next;
        }
        int missingX = missing.x;
        int missingY = missing.y;
        if (canGoUp(missingX, missingY) && canGoDown(missingX, missingY)) {
            missing.block = '|';
        }
        if (canGoLeft(missingX, missingY) && canGoRight(missingX, missingY)) {
            missing.block = '-';
        }
        if (canGoDown(missingX, missingY) && canGoRight(missingX, missingY)) {
            missing.block = '1';
        }
        if (canGoUp(missingX, missingY) && canGoRight(missingX, missingY)) {
            missing.block = '2';
        }
        if (canGoUp(missingX, missingY) && canGoLeft(missingX, missingY)) {
            missing.block = '3';
        }
        if (canGoLeft(missingX, missingY) && canGoDown(missingX, missingY)) {
        missing.block = '4';
    }
        if (canGoUp(missingX, missingY) && canGoDown(missingX, missingY) && canGoLeft(missingX, missingY)
            && canGoRight(missingX, missingY)) {
            missing.block = '+';
        }

        System.out.printf("%d %d %c", missing.x + 1, missing.y + 1, missing.block);
    }

    static boolean canGoLeft(int x, int y) {
        if (y - 1 >= 0 && (input[x][y - 1] == '-' || input[x][y - 1] == '+' || input[x][y - 1] == '1'
                           || input[x][y - 1] == '2' || input[x][y - 1] == 'Z' )) {
            return true;
        }
        return false;
    }

    static boolean canGoRight(int x, int y) {
        if (y + 1 < C && (input[x][y + 1] == '-' || input[x][y + 1] == '+' || input[x][y + 1] == '3'
                          || input[x][y + 1] == '4' || input[x][y + 1] == 'Z' )) {
            return true;
        }
        return false;
    }

    static boolean canGoUp(int x, int y) {
        if (x - 1 >= 0 && (input[x - 1][y] == '|' || input[x - 1][y] == '+' || input[x - 1][y] == '1'
                           || input[x - 1][y] == '4' || input[x - 1][y] == 'Z' )) {
            return true;
        }
        return false;
    }

    static boolean canGoDown(int x, int y) {
        if (x + 1 < R && (input[x + 1][y] == '|' || input[x + 1][y] == '+' || input[x + 1][y] == '2'
                          || input[x + 1][y] == '3' || input[x + 1][y] == 'Z' )) {
            return true;
        }
        return false;
    }
}

class Node {
    int x;
    int y;
    char block;
    int direction;
    // 1:left 2:right 3: up 4: down

    @Override
    public String toString() {
        return "Node{" +
               "x=" + x +
               ", y=" + y +
               ", block=" + block +
               ", direction=" + direction +
               '}';
    }

    public Node() {
    }

    Node next() {
        Node node = new Node();
        if (this.block == '|') {
            if (direction == 3) {
                node.x = this.x - 1;
                node.y = this.y;
            } else if (direction == 4) {
                node.x = this.x + 1;
                node.y = this.y;
            }
            node.direction = direction;
        } else if (this.block == '-') {
            if (direction == 1) {
                node.x = this.x;
                node.y = this.y - 1;
            } else if (direction == 2) {
                node.x = this.x;
                node.y = this.y + 1;
            }
            node.direction = direction;
        } else if (this.block == '+' || this.block == 'M') {
            if (direction == 1) {
                node.x = this.x;
                node.y = this.y - 1;
            } else if (direction == 2) {
                node.x = this.x;
                node.y = this.y + 1;
            } else if (direction == 3) {
                node.x = this.x - 1;
                node.y = this.y;
            } else if (direction == 4) {
                node.x = this.x + 1;
                node.y = this.y;
            }
            node.direction = direction;
            // 1:left 2:right 3: up 4: down
        } else if (this.block == '1') {
            if (direction == 3) {
                node.x = this.x;
                node.y = this.y + 1;
                node.direction = 2;
            } else if (direction == 1) {
                node.x = this.x + 1;
                node.y = this.y;
                node.direction = 4;
            }
        } else if (this.block == '2') {
            if (direction == 4) {
                node.x = this.x;
                node.y = this.y + 1;
                node.direction = 2;
            } else if (direction == 1) {
                node.x = this.x - 1;
                node.y = this.y;
                node.direction = 3;
            }
        } else if (this.block == '3') {
            if (direction == 4) {
                node.x = this.x;
                node.y = this.y - 1;
                node.direction = 1;
            } else if (direction == 2) {
                node.x = this.x - 1;
                node.y = this.y;
                node.direction = 3;
            }
        } else if (this.block == '4') {
            if (direction == 3) {
                node.x = this.x;
                node.y = this.y - 1;
                node.direction = 1;
            } else if (direction == 2) {
                node.x = this.x + 1;
                node.y = this.y;
                node.direction = 4;
            }
        }

        return node;
    }
}
