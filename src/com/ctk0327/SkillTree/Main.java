package com.ctk0327.SkillTree;

public class Main {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTree = { "CBADF"};
        System.out.println(solution(skill, skillTree));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            if (canMakeSkillTree(skill, skill_trees[i])) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean canMakeSkillTree(String skill, String skill_tree) {
        boolean[] isNeed = new boolean[26];
        boolean[] isSkill = new boolean[26];
        for (int i = 0; i < skill.length(); i++) {
            isNeed[skill.charAt(i) - 65] = true;
            isSkill[skill.charAt(i) - 65] = true;
        }
        isNeed[skill.charAt(0) - 65] = false;
        boolean answer = true;
        int count = 1;
        int end = skill.length();
        for (int i = 0; i < skill_tree.length(); i++) {
            if (isNeed[skill_tree.charAt(i) - 65]) {
                answer = false;
                break;
            } else {
                if (end > count && isSkill[skill_tree.charAt(i) - 65]) {
                    isNeed[skill.charAt(count) - 65] = false;
                    count++;
                }
            }
        }
        return answer;
    }
}
