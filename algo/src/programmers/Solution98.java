package programmers;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/43164
//여행경로
public class Solution98 {
    List<String> ans;
    int visit[];
    ArrayList<String> allRoute;
    public void dfs(String start, String route, String[][] tickets, int cnt){

        if(cnt == tickets.length){
            allRoute.add(route);
            return;
        }
        for(int i=0; i<tickets.length; i++) {
            if(start.equals(tickets[i][0]) && visit[i] ==0){
                visit[i] = 1;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1);
                visit[i] = 0;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        ans = new ArrayList<>();
        allRoute= new ArrayList<>();
        visit = new int[tickets.length];
        dfs("ICN","ICN",tickets,0);

        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");
        return answer;
    }
    public static void main(String[] args) {
//        String str[][] = {{"ICN", "JFK"}, {"HND", "IAD"},{"JFK", "HND"}};
//        String str[][] = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}};
//        String str[][] = {{"ICN", "B"}, {"ICN", "A"},{"B", "ICN"}};
        String str[][] = {{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}};
        Solution98 sol = new Solution98();
        sol.solution(str);
    }

}
