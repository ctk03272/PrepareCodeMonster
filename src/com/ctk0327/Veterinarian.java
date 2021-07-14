package com.ctk0327;

import java.util.LinkedList;
import java.util.Queue;

public class Veterinarian {
    Queue<String> petQue=new LinkedList<>();
    public void accept(String petName) {
        petQue.add(petName);
    }

    public String heal() {
        return petQue.poll();
    }

    public static void main(String[] args) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.accept("Barkley");
        veterinarian.accept("Mittens");
        System.out.println(veterinarian.heal());
        System.out.println(veterinarian.heal());
    }
}