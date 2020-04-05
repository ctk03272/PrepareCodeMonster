package com.ctk0327.Coupang;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ar = new int[N];
        for (int i = 0; i < N; i++) {
            ar[i] = sc.nextInt();
        }
        System.out.println(solution(ar));
    }

    static int solution(int[] paper) {
        int answer = 0;
        int sum=0;
        int length=paper.length;
        for (int i = 0; i < length; i++) {
            sum+=paper[i];
        }
        Arrays.sort(paper);
        for (int i =length; i >0 ; i--) {
            if(sum>=i*i){
                answer=i;
                break;
            }else{
                sum-=paper[length-i];
            }
        }
        return answer;
    }
}
