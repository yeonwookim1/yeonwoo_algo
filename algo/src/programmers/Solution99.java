package programmers;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/43238
//입국심사
public class Solution99 {

    public long solution(int n, int[] times) {
        long answer = 0;

        long max = (long)n*times[times.length-1];
        long min = 0;

        Arrays.sort(times);

        while(min<=max){
            long mid = (max+min)/2;
            long sum = 0;

            for(int i=0; i<times.length; i++){
                sum += mid/times[i];
            }

            if(sum<n){
                min = mid +1;
            }else{
                max = mid -1;answer = mid;
            }
        }

        return answer;
    }
}
