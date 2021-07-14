package com.ctk0327.SkillCheck3;

public class Skill3_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("LULLLLLLU"));
    }
}

class Solution {
    int map[][] = new int[11][11];
    boolean visited[][][][] = new boolean[11][11][11][11];
    int dx[] = { 1, -1, 0, 0 };
    int dy[] = { 0, 0, 1, -1 };

    public int solution(String dirs) {
        int answer = 0;
        int x = 5, y = 5;
        int nx=x;
        int ny=y;
        for (int i = 0; i < dirs.length(); i++) {
            char next = dirs.charAt(i);
            if (next == 'U') {
                nx = nx + dx[2];
                ny = ny + dy[2];
            } else if (next == 'D') {
                nx = nx + dx[3];
                ny = ny + dy[3];
            } else if (next == 'R') {
                nx = nx + dx[0];
                ny = ny + dy[0];
            } else if (next == 'L') {
                nx = nx + dx[1];
                ny = ny + dy[1];
            }

            if(nx<0 || nx>10 || ny<0 || ny>10){
                nx=x;
                ny=y;
                continue;
            }
            if(!visited[x][y][nx][ny]){
                answer++;
                visited[x][y][nx][ny]=true;
                visited[nx][ny][x][y]=true;
            }
            x=nx;
            y=ny;
        }
        return answer;
    }
}