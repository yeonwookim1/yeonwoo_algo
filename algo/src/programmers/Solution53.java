package programmers;

import java.util.ArrayList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/12979
//기지국 설치(시간초과) -> 53_2
public class Solution53 {
    int map[];
    int n,w;
    public void star(int k, int w){
        for(int i=0; i<w; i++){
            if(k-w + i> 0){
                map[k-w+i] =1;
            }
            if(k+w-i <=n){
                map[k+w-i] = 1;
            }
        }
    }

    public int check(int cnt){
        double d = (double)cnt/((w*2)+1);
        return (int)Math.ceil(d);
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        this.n =n;
        this.w =w;
        map = new int[200000001];
        for(int i=0; i<stations.length; i++){
            map[stations[i]] = 1;
            star(stations[i],w);
        }

        for(int i=0; i<stations.length; i++){
            map[stations[i]] = 1;
            star(stations[i],w);
        }



        int startIdx = -1;
        int cnt =0;
        for(int i=1; i<=n; i++){
            if(map[i]==1){
                if(cnt!=0){
                    answer += check(cnt);
                    cnt = 0;
                }
                continue;
            }else{
                cnt++;
            }
        }
        //마지막에 0일 경우 최종 체크용
        if(cnt!=0){
            answer += check(cnt);
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution53 sol = new Solution53();
        int arr[]= {9};
        sol.solution(16,arr,2);
    }
}
