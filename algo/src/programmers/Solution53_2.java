package programmers;

import java.util.ArrayList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/12979
//기지국 설치
public class Solution53_2 {
    int w;

    public int check(int cnt){
        int d = cnt/((w*2)+1);
        if(cnt%((w*2)+1) > 0){
            d++;
        }
        return d;
//        double d = (double)cnt/((w*2)+1);
//        return (int)Math.ceil(d);
    }
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        this.w = w;

        List<Integer> list = new ArrayList<>();
        int startIdx =1;
        for(int i=0; i<stations.length; i++){
            if(i==0) {
                startIdx = stations[i]-w;
                if(startIdx <=0){
                    startIdx = 1;
                }
                answer += check(startIdx -1);
//                list.add(startIdx - 1);
            }else {
                startIdx = stations[i-1]+w;
                int temp = stations[i]-w;
//                list.add(temp - startIdx - 1);
                answer += check(temp - startIdx - 1);
            }
//            startIdx = stations[i]+w;
        }
        if(stations[stations.length-1]+w < n){
            answer += check((n-(stations[stations.length-1]+w)));
//            list.add(n - startIdx);
        }


//        for(int a : list){
//            System.out.println(a);
//        }

//        for(int i=0; i<list.size(); i++){
//            answer += check(list.get(i));
//        }


        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        Solution53_2 sol = new Solution53_2();
        int arr[]= {9};
        int arr2[] = {4,11};
        sol.solution(16,arr,2);

        System.out.println("@@@@@@@@@@@@@@@");
        sol.solution(11,arr2,1);
    }
}
