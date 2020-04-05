package com.ctk0327.B1036;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            ArrayList<Integer> a=null;
            a.size();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        BigInteger ret = BigInteger.ZERO;
        BigInteger[] diff = new BigInteger[36];
        Arrays.fill(diff, BigInteger.ZERO);
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String raw = br.readLine();
            BigInteger now = new BigInteger(raw, 36);
            BigInteger pow = BigInteger.ONE;
            ret = ret.add(now);
            for (int j = 0; j < raw.length(); j++) {
                int idx = toNumaber(raw.charAt(raw.length() - 1 - j));
                diff[idx] = diff[idx].add(pow.multiply(BigInteger.valueOf(35 - idx)));
                pow = pow.multiply(BigInteger.valueOf(36));
            }
        }

        Arrays.sort(diff);
        int K = Integer.parseInt(br.readLine());
        for (int i = 35; K-- > 0; i--) {
            ret = ret.add(diff[i]);
        }
        System.out.println(ret.toString(36).toUpperCase());
    }

    static int toNumaber(char x) {
        return ('0' <= x && x <= '9') ? x - 48 : x - 55;
    }
}