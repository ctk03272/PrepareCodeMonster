package com.ctk0327.SkillCheck3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.deepToString(solution2.solution(new int[][] {
                { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 }
        })));
    }

    static ArrayList<Integer> pre = new ArrayList<>();
    static ArrayList<Integer> post = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        ArrayList<Node> ar = new ArrayList<>();

        int length = nodeinfo.length;
        int[][] answer = new int[2][length];
        for (int i = 0; i < length; i++) {
            ar.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        ar.sort((a, b) -> {
            return b.y - a.y;
        });
        Node rootNode = ar.get(0);
        for (int i = 1; i < length; i++) {
            rootNode.addNode(ar.get(i));
        }

        preOrder(rootNode);
        postOrder(rootNode);

        for (int i = 0; i <length ; i++) {
            answer[0][i]=pre.get(i);
            answer[1][i]=post.get(i);
        }

        return answer;
    }

    static void preOrder(Node rootNode) {
        if(rootNode==null){
            return;
        }
        if (rootNode.leftChild != null || rootNode.rightChild != null) {
            pre.add(rootNode.value);
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }else{
            pre.add(rootNode.value);
        }
    }

    static void postOrder(Node rootNode) {
        if(rootNode==null){
            return;
        }
        if (rootNode.leftChild != null || rootNode.rightChild != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            post.add(rootNode.value);
        }else{
            post.add(rootNode.value);
        }
    }
}

class Node {
    int x;
    int y;
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    void addNode(Node node) {
        if (node.y < y) {
            if (node.x < x) {
                if (leftChild == null) {
                    leftChild = node;
                } else {
                    leftChild.addNode(node);
                }
            } else if (node.x > x) {
                if (rightChild == null) {
                    rightChild = node;
                } else {
                    rightChild.addNode(node);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
               "x=" + x +
               ", y=" + y +
               ", value=" + value +
               '}';
    }
}
