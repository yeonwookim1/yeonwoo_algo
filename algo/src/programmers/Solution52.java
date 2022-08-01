package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/49993
//스킬트리
public class Solution52 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++){
            int idx = 0;
            boolean isTrue = true;
            for(int j=0; j<skill_trees[i].length(); j++){
                //skill의 인덱스
                int a= skill.indexOf(skill_trees[i].charAt(j));
//                System.out.println("skill_trees[i] " + skill_trees[i] + " " + skill_trees[i].charAt(j));
//                System.out.println("a = " + a);
                if(a==-1){
                    continue;
                }
                if(idx!=a) {
                    isTrue = false;
                    break;
                }else{
                    idx++;
                }
            }
            System.out.println("@@@@@@@@@@@@@@@@@@");

            if(isTrue){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution52 sol = new Solution52();
        String skill = "CBD";
        String tree[] = {"BACDE", "CBADF", "AECB", "BDA"};
        sol.solution(skill,tree);
    }
}
