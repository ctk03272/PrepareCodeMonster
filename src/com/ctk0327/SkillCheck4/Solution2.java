package com.ctk0327.SkillCheck4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(9, new int[][] {
                { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 }
        }, new int[][] { { 8, 5 }, { 6, 7 }, { 4, 1 } }));
    }

    public boolean solution(int n, int[][] path, int[][] order) {
        ArrayList<Integer>[] ar = new ArrayList[n];
        int[] prev = new int[n];
        int[] after = new int[n];

        Arrays.fill(prev, -1);
        Arrays.fill(after, -1);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < path.length; i++) {
            int from = path[i][0];
            int to = path[i][1];
            if (ar[from] == null) {
                ar[from] = new ArrayList<>();
            }
            ar[from].add(to);
            if (ar[to] == null) {
                ar[to] = new ArrayList<>();

            }
            ar[to].add(from);
        }
        for (int i = 0; i < order.length; i++) {
            prev[order[i][1]] = order[i][0];
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        while (!que.isEmpty()) {
            int next = que.remove();
            if (!visited[next]) {
                if (prev[next] != -1 && !visited[prev[next]]) {
                    after[prev[next]] = next;
                    continue;
                }
                visited[next] = true;
                for (int i : ar[next]) {
                    que.add(i);
                }
                if (after[next] != -1) {
                    que.add(after[next]);
                }
            }

        }
        boolean answer = true;
        for (boolean bool:visited
             ) {
            if(!bool){
                answer=false;
            }
        }
        return answer;
    }
}
