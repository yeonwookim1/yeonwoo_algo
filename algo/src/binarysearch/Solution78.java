package binarysearch;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/43238
//입국심사
public class Solution78 {


    public long solution(int n, int[] times) {
        long answer = 0;

        long max = (long)n*times[times.length-1];
        long min = 0;

        String s = "tem";
        s = s.toUpperCase();
        Arrays.sort(times);
        while(min<=max){
            long mid = (min+max)/2;
            long sum = 0;
            for(int i=0; i<times.length; i++){
                sum = sum + mid/times[i];
            }

            if(sum<n){
                min = mid + 1;
            }else{
                max = mid-1;
                answer = mid;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution78 sl = new Solution78();
        int n= 6;
        int arr[] = {7,10};
        sl.solution(n,arr);
    }
}
