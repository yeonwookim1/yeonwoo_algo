package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/87946
//피로도
public class Solution96 {

    int K;
    int visit[];
    int map[][];
    int min;
    public void dfs(int life, int cnt){
        if(cnt > min){
            min = cnt;
        }
        if(life<=0 || cnt >=map.length){
            return;
        }

        for(int i=0; i<map.length; i++){
            if(life>=map[i][0] && visit[i] ==0){
                visit[i] = 1;
                life -= map[i][1];
                dfs(life, cnt+1);
                life += map[i][1];
                visit[i] = 0;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        min = Integer.MIN_VALUE;
        K= k;
        map = dungeons;
        visit = new int[dungeons.length];
        dfs(K,0);
        System.out.println(min);
        answer = min;
        return answer;
    }

    public static void main(String[] args) {
        Solution96 sol = new Solution96();
        int k= 80;
        int dun[][] = {{80,20},{50,40},{30,10}};
        sol.solution(k,dun);
    }


}
