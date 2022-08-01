package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://school.programmers.co.kr/learn/courses/30/lessons/12985?language=java
//예상 대진표
//num 은 싸움 번호
//name은 고유값, group은 그룹넘버
public class Solution49 {

    class Group{
        int name,group;
        boolean isWin;
        Group(int name, int group){
            this.name = name;
            this.group = group;
            this.isWin = false;
        }
        public void setWin(boolean win) {
            isWin = win;
        }
    }
    Map<Integer, Group> players;
    static int a;
    static int b;
    static int ans = -1;
    public void makePlayer(int n){
    }

    public void fight(int cnt){

        List<Map.Entry<Integer,Group>> list = new ArrayList<>(players.entrySet());
        for(int i=0; i<list.size(); i=i+2){
            int left = list.get(i).getValue().name;
            int leftIdx = i;
            int right = list.get(i+1).getValue().name;
            int rightIdx = i+1;
            if((left==a && right==b) || left==b && right==a){
                //정답
                ans = cnt;
                return;
            }

            if(left==a || left ==b){
                list.get(leftIdx).getValue().setWin(true);
            }else if(right==a || right==b){
                list.get(rightIdx).getValue().setWin(true);
            } else{
                list.get(leftIdx).getValue().setWin(true);
            }
        }System.out.println("==================================");
        for(Map.Entry<Integer,Group> e : list){
            System.out.print("e.싸움번호() = " + e.getKey());
            System.out.print(" e.ID = " + e.getValue().name);
            System.out.print(" e.group = " + e.getValue().group);
            System.out.print(" e.isWin = " + e.getValue().isWin);
            System.out.println();
        }
    }

    public void next(){
        Map<Integer, Group> member = new HashMap<>();
        List<Map.Entry<Integer,Group>> list = new ArrayList<>(players.entrySet());

        int idx =1;
        for(Map.Entry<Integer,Group> e : list) {
            if(e.getValue().isWin == true){
                int groupNum = e.getKey();
                if(groupNum%2 != 0){
                    groupNum += 1;
                }
                member.put(idx,new Group(e.getValue().name, groupNum/2));
                idx++;
            }
        }

        List<Map.Entry<Integer,Group>> list2 = new ArrayList<>(member.entrySet());
        System.out.println("NEWNEWENWNEWNEWENWNEWNEWENWNEWNEWENWNEWNEWENWNEWNEWENWNEWNEWENWNEWNEWENWNEWNEWENW");
        for(Map.Entry<Integer,Group> e : list2){
            System.out.print("e.싸움번호() = " + e.getKey());
            System.out.print(" e.ID = " + e.getValue().name);
            System.out.print(" e.group = " + e.getValue().group);
            System.out.print(" e.isWin = " + e.getValue().isWin);
            System.out.println();
        }

        players = member;
    }

    public int solution(int n, int a, int b)
    {
        int answer = 0;
        players = new HashMap<>();
        this.a = a;
        this.b = b;

        for(int i=1; i<=n; i++){
            double d = (double) i;
            players.put(i,new Group(i,(int)Math.ceil(d/2)));
        }

        int cnt =1;
        while(true){
            if(ans!=-1){
                break;
            }
            fight(cnt);
            next();
            cnt++;
//            List<Map.Entry<Integer,Group>> list = new ArrayList<>(players.entrySet());
//            for(Map.Entry<Integer,Group> e : list){
//                System.out.print("e.싸움번호() = " + e.getKey());
//                System.out.print(" e.ID = " + e.getValue().name);
//                System.out.print(" e.group = " + e.getValue().group);
//                System.out.print(" e.isWin = " + e.getValue().isWin);
//                System.out.println();
//            } System.out.println("==================================");

        }

        answer = ans;
        return answer;
    }

    public static void main(String[] args) {
        new Solution49().solution(8,4,7);
    }
}
