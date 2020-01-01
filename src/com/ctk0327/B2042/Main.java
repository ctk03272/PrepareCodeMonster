package com.ctk0327.B2042;

import java.util.Scanner;

public class Main {
    static long given[];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int K=sc.nextInt();
        given=new long[N];
        for (int i = 0; i <N ; i++) {
            given[i]=sc.nextLong();
        }
        Node headNode=makeNode(1, N);
        for(int i=0;i<K+M;i++){
            int a=sc.nextInt();
            int b =sc.nextInt();
            long c=sc.nextLong();

            if(a==1){

                long diff=c-given[b-1];
                changeSum(headNode,b,diff);
                given[b-1]=c;
            }
            else if(a==2){
                System.out.println(getSum(headNode,b,(int)c));
            }
        }
    }

    private static void changeSum(Node node, int i, long diff){
        int left=node.l;
        int right=node.r;
        if(left<=i && right>=i){
            node.sum+=diff;
            if(node.leftNode!=null && node.rightNode!=null){
                changeSum(node.leftNode,i,diff);
                changeSum(node.rightNode,i,diff);
            }
        }
    }
    private static long getSum(Node node, int l, int r){
        long result=0;
        int nodeL=node.l;
        int nodeR=node.r;

        if(nodeL>=l && nodeR<=r){
            return node.sum;
        }else if((nodeR<l) ||(nodeL>r)){
            return 0;
        }else{
            if(node.leftNode==null || node.rightNode==null){
                return node.sum;
            }
            return getSum(node.leftNode,l,r)+getSum(node.rightNode,l,r);
        }
    }

    private static Node makeNode(int l, int r) {
        Node result=new Node(l,r) ;
        if(l==r){
            result.sum=given[l-1];
            return result;
        }
        int middle=(l+r)/2;
        result.leftNode=makeNode(l,middle);
        result.rightNode=makeNode(middle+1,r);
        result.sum=result.leftNode.sum+result.rightNode.sum;

        return result;
    }
}

class Node {
    int l;
    int r;
    long sum;
    Node leftNode;
    Node rightNode;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        this.sum = sum;
    }
}

