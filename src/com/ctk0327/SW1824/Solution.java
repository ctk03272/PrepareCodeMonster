package com.ctk0327.SW1824;
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
    static int R, C;
    static char[][] input;
    static boolean[][][][] visit;
    static Queue<Node> queue;
    static int memory;
    static boolean isStop;

    //direction 1: 왼쪽 2: 오른쪽, 3:위쪽, 4: 아래쪽
    public static void main(String args[]) throws Exception {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            R = sc.nextInt();
            C = sc.nextInt();
            sc.nextLine();
            isStop = false;
            input = new char[R][C];
            visit = new boolean[R][C][5][16];
            queue = new LinkedList<>();
            queue.offer(new Node(0, 0, 2));
            visit[0][0][2][0] = true;
            memory = 0;
            for (int i = 0; i < R; i++) {
                String temp = sc.nextLine();
                for (int j = 0; j < C; j++) {
                    input[i][j] = temp.charAt(j);
                }
            }
            while (!queue.isEmpty() && !isStop) {
                Node now = queue.poll();
                int x = now.x;
                int y = now.y;
                int diection = now.direction;
                char dir = input[x][y];
                switch (dir) {
                    case '<':
                        diection = 1;
                        doMove(x, y, diection);
                        break;
                    case '>':
                        diection = 2;
                        doMove(x, y, diection);
                        break;
                    case '^':
                        diection = 3;
                        doMove(x, y, diection);
                        break;
                    case 'v':
                        diection = 4;
                        doMove(x, y, diection);
                        break;
                    case '_':
                        if (memory == 0) {
                            diection = 2;
                        } else {
                            diection = 1;
                        }
                        doMove(x, y, diection);
                        break;
                    case '|':
                        if (memory == 0) {
                            diection = 4;
                        } else {
                            diection = 3;
                        }
                        doMove(x, y, diection);
                        break;
                    case '?':
                        doMove(x, y, 1);
                        doMove(x, y, 2);
                        doMove(x, y, 3);
                        doMove(x, y, 4);
                        break;
                    case '.':
                        doMove(x, y, diection);
                        break;
                    case '@':
                        isStop = true;
                        break;
                    case '+':
                        if (memory == 15) {
                            memory = 0;
                        } else {
                            memory += 1;
                        }
                        doMove(x, y, diection);
                        break;
                    case '-':
                        if (memory == 0) {
                            memory = 15;
                        } else {
                            memory -= 1;
                        }
                        doMove(x, y, diection);
                        break;
                    default:
                        if ((int) dir >= 48 && (int) dir <= 57) {
                            memory = dir - 48;
                        }
                        doMove(x, y, diection);
                        break;
                }
            }
            System.out.println("#"+(test_case)+" "+(isStop?"YES":"NO"));
        }
    }

    private static void doMove(int x, int y, int diection) {
        int nx = 0, ny = 0;
        if (diection == 1) {
            if (y == 0) {
                nx = x;
                ny = C - 1;
            } else {
                nx = x;
                ny = y - 1;
            }
        } else if (diection == 2) {
            if (y == C - 1) {
                nx = x;
                ny = 0;
            } else {
                nx = x;
                ny = y + 1;
            }
        } else if (diection == 3) {
            if (x == 0) {
                nx = R - 1;
                ny = y;
            } else {
                nx = x - 1;
                ny = y;
            }
        } else if (diection == 4) {
            if (x == R - 1) {
                nx = 0;
                ny = y;
            } else {
                nx = x + 1;
                ny = y;
            }
        }
        if (!visit[nx][ny][diection][memory]) {
            queue.offer(new Node(nx,ny,diection));
            visit[nx][ny][diection][memory]=true;
        }
    }
}

class Node {
    int x;
    int y;
    int direction;

    public Node(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}