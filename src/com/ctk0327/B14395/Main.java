package com.ctk0327.B14395;

import java.util.*;

public class Main {
    static int s, t;
    static long MAX = 1000000000L;
    static char[] given = {'*', '+', '_', '/',};
    static Map<Long, Boolean> isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        t = sc.nextInt();
        isVisited = new HashMap<>();

        if (s == t) {
            System.out.println("0");
            return;
        }

        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(s, ""));

        while (!queue.isEmpty()) {
            Dot nowDot = queue.poll();
            long nowValue = nowDot.value;
            String nowResult = nowDot.result;

            if (nowValue == t) {
                System.out.println(nowResult);
                return;
            }

            // 아스키코드의 순서대로 BFS를 돈다
            // 맥스값이 넘지 않는 상태에서 이미 한번 나온 값은 순회하지 않는 방식으로 전체 순회를 한다.

            if (0 <= nowValue * nowValue && nowValue * nowValue <= MAX && !isVisited.containsKey(nowValue * nowValue)) {
                queue.add(new Dot(nowValue * nowValue, new StringBuilder(nowResult).append("*").toString()));
                isVisited.put(nowValue * nowValue, true);
            }

            if (0 <= nowValue + nowValue && nowValue + nowValue <= MAX && !isVisited.containsKey(nowValue + nowValue)) {
                queue.add(new Dot(nowValue + nowValue, new StringBuilder(nowResult).append("+").toString()));
                isVisited.put(nowValue + nowValue, true);
            }

            if (0 <= nowValue - nowValue && nowValue - nowValue <= MAX && !isVisited.containsKey(nowValue - nowValue)) {
                queue.add(new Dot(nowValue - nowValue, new StringBuilder(nowResult).append("-").toString()));
                isVisited.put(nowValue - nowValue, true);
            }

            if (nowValue != 0 && 0 <= nowValue / nowValue && nowValue / nowValue <= MAX && !isVisited.containsKey(nowValue / nowValue)) {
                queue.add(new Dot(nowValue / nowValue, new StringBuilder(nowResult).append("/").toString()));
                isVisited.put(nowValue / nowValue, true);
            }
        }

        System.out.println("-1");

    }
}

class Dot {
    long value;
    String result;

    public Dot(long value, String result) {
        this.value = value;
        this.result = result;
    }
}