package programmers;

import java.util.*;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/68646
//풍선 터트리기
public class Solution56 {

    public int solution(int[] a) {
        int answer = a.length;
        int leftMin[] = new int[a.length];
        int rightMin[] = new int[a.length];
        int l = a[0];
        int r = a[a.length-1];

        for(int i =1; i<a.length; i++){
            if(l>a[i]){
                l= a[i];
            }
            leftMin[i] = l;
        }

        for(int i =a.length-2; i>=0; i--){
            if(r>a[i]){
                r= a[i];
            }
            rightMin[i] = r;
        }
        if(a.length==1){
            return 1;
        }
        for(int i=1; i<=a.length-2; i++){
            if(a[i] > leftMin[i] && a[i] > rightMin[i]){ //양쪽이 둘다 작으면 무조건 사라짐
                continue;
            }
            answer ++;
        }
        return answer+2;
    }

    public static void main(String[] args) {
        Solution56 sol = new Solution56();
        int arr[] = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        sol.solution(arr);
    }
}
