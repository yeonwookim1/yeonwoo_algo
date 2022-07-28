package programmers;

import java.util.ArrayList;
import java.util.List;


//https://school.programmers.co.kr/learn/courses/30/lessons/1835?language=java
//단체 사진찍기
public class Solution42 {

    static class Member{
        String x;
        String y;
        String comp;   //=,>,<
        int compNum;
        public Member(String x, String y, String comp, int compNum){
            this.x = x;
            this.y = y;
            this.comp = comp;
            this.compNum = compNum;
        }
    }
    static String names[];
    static int visit[];
    static Member members[];
    static List<String> list;
    static int ans;

    public boolean check(){
        boolean isRight = true;
        for(int i=0; i<members.length; i++){
            int x = -1;
            int y = -1;
            for(int j=0; j<list.size(); j++){
                if(members[i].x.equals(list.get(j))){
                    x = j;
                    continue;
                }
                if(members[i].y.equals(list.get(j))){
                    y = j;
                    continue;
                }
                if(x != -1 && y != -1){
                    break;
                }
            }

            int distance = Math.abs(x-y);
            if(members[i].comp.equals("=") && distance != members[i].compNum+1){
                return false;
            }
            if(members[i].comp.equals(">") && distance<=members[i].compNum+1){   // >
                return false;
            }
            if(members[i].comp.equals("<")&& distance>=members[i].compNum+1){
                return false;
            }
        }

        return isRight;
    }
    public void dfs(){
        if(list.size()>=8){
            if(check()) {
                ans++;
            }
            return;
        }

        for(int i=0; i<8; i++){
            if(visit[i] == 0){
                visit[i] = 1;
                list.add(names[i]);
                dfs();
                visit[i] = 0;
                list.remove(list.size()-1);
            }
        }

    }

    public int solution(int n, String[] data) {
        int answer = 0;
        visit = new int[8];
        names = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
        list = new ArrayList<>();
        for(int i=0; i<8; i++){
            visit[i] =0;
        }


        ans = 0;
        //"N~F=0", "R~T>2"
        members = new Member[n];

        for(int i=0; i<n; i++){
            String[] temp = data[i].split("");
//            {A, C, F, J, M, N, R, T}
            int comp = 0;
            members[i] = new Member(temp[0],temp[2] ,temp[3],Integer.parseInt(temp[4]));
        }
        dfs();
        System.out.println(ans);
        return answer;
    }


    public static void main(String[] args) {
        int n = 2;
        String data[] = {"N~F=0", "R~T>2"};
        String data1[] = {"M~C<2", "C~M>1"};
        Solution42 sol = new Solution42();
        sol.solution(n,data);
        sol.solution(n,data1);
        sol.solution(n,data);
    }

}
