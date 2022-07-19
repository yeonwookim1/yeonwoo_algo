import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/87946
//피로도
public class Solution28 {
    static int[][] arr;
    static int k;
    static int visit[];
    static int ans = -1;

    public boolean isLive(int life){
        for(int i=0; i<arr.length; i++){
            if(visit[i] == 0 && arr[i][0] <= life){
                return true;
            }
        }
        return false;
    }

    public void cal(){

    }

    public void dfs(List<Integer> list, int idx, int life, int cnt){
        if(!isLive(life)){
            if(ans <cnt){
                ans = cnt;
            }
            System.out.println(ans);
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(visit[i] == 0 && life >= arr[i][0]){
                visit[i] = 1;
                list.add(i);
                life -= arr[i][1];
                dfs(list,i+1, life, cnt+1);
                life += arr[i][1];
                list.remove(list.size()-1);
                visit[i] = 0;
            }
        }


    }
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        arr = dungeons;
        this.k = k;
        visit = new int[arr.length];
        dfs(new ArrayList<>(), 0, k, 0);


        return answer;
    }

    public static void main(String[] args) {
        int k = 80;
        int arr[][] = {{80,20},{50,40},{30,10}};
        new Solution28().solution(k,arr);
    }
}
