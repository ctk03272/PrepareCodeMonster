package com.ctk0327.B2613;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        input = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            sum += temp;
            input[i] = temp;
        }
        int start = 0;
        int end = sum;
        int count = 0;
        int answer = Integer.MAX_VALUE;
        ArrayList<Integer> ar = new ArrayList<>();
        ArrayList<Integer> answerAr = new ArrayList<>();
        while (start <= end) {
            boolean isEnough = true;
            int key = (end - start) / 2 + start;
            int tempSum = 0;
            count = 0;
            int innerCount = 0;
            ar = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                innerCount++;
                if (tempSum + input[i] > key) {
                    if (tempSum != 0) {
                        tempSum = 0;
                        i--;
                        count++;
                        ar.add(--innerCount);
                        innerCount = 0;
                    } else {
                        tempSum = 0;
                        count++;
                        isEnough = false;
                        ar.add(innerCount);
                        innerCount = 0;
                    }
                } else {
                    tempSum += input[i];
                }
            }
            if (tempSum != 0) {
                count++;
                ar.add(innerCount);
            }
            if (count > M || !isEnough) {
                start = key + 1;
            } else {
                end = key - 1;
                if (key < answer) {
                    answer = key;
                    answerAr = new ArrayList<>();
                    for (int i = 0; i < ar.size(); i++) {
                        answerAr.add(ar.get(i));
                    }
                }
            }
        }
        System.out.println(answer);
        StringBuilder sb = new StringBuilder();
        int diff = M - answerAr.size();
        for (int i = 0; i < answerAr.size(); i++) {
            if (answerAr.get(i) == 1) {
                sb.append(answerAr.get(i) + " ");
            }else{
                while(answerAr.get(i)>1 && diff>0){
                    sb.append("1"+ " ");
                    answerAr.set(i,answerAr.get(i)-1);
                    diff--;
                }
                sb.append(answerAr.get(i) + " ");
            }
        }
        System.out.println(sb.toString());
    }

}
