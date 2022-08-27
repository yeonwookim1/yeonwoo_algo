package programmers;

import java.util.LinkedList;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/86971?language=java
//전력망을 둘로 나누기
public class Solution97 {

    public int check(int n,int map[][]){
        int visit[] = new int[map.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = 1;

        while(!q.isEmpty()){
            int r = q.poll();
            for(int i=1; i<=n; i++){

                if(map[r][i]==1 && visit[i]==0){
                    visit[i] = 1;
                    q.add(i);
                }
            }
        }

        int x = 0;
        for(int i=1; i<=n; i++){
            if(visit[i]==1){
                x++;
            }else{
                x--;
            }
        }
        return Math.abs(x);
    }
    public int solution(int n, int[][] wires) {
        int map[][] = new int[n+1][n+1];
        for(int i=0; i<wires.length; i++){
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<wires.length; i++){
            map[wires[i][0]][wires[i][1]] = 0;
            map[wires[i][1]][wires[i][0]] = 0;

            int temp = check(n,map);
            if(answer > temp){
                answer = temp;
            }

            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution97 sol = new Solution97();
        int n  = 4;
        int arr[][] ={{1,2,},{2,3},{3,4}};
        sol.solution(n,arr);

    }
}
