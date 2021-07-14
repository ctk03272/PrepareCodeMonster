package com.ctk0327.skillCheck2;

public class Solution2 {
    public String solution(String number, int k) {
        StringBuffer sb=new StringBuffer();
        int n=number.length();
        int start=-1;
        int selected=Integer.MIN_VALUE;
        int makeLength=n-k;
        for (int i = 0; i <makeLength ; i++) {
            int temp=-1;
            for (int j = start+1; j <=n-(makeLength-i) ; j++) {
                if(selected<number.charAt(j)-'0'){
                    selected=number.charAt(j)-'0';
                    temp=j;
                }
            }
            sb.append(selected);
            start=temp;
            selected=Integer.MIN_VALUE;
        }
        return sb.toString();
    }
}
