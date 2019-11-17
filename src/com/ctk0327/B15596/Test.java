package com.ctk0327.B15596;

import java.util.Scanner;

public class Test {
    long sum(int[] a){
        long result=0;
        for (int i = 0; i <a.length ; i++) {
            result +=a[i];
        }
        return result;
    }
}
