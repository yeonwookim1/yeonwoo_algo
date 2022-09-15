package programmers;

import java.util.*;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/118667
//두 큐 합 같게 만들기
public class Solution110 {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long s1 = 0;
        long s2 = 0;
        for(int temp : queue1){
            q1.add(temp);
            s1 += temp;
        }
        for(int temp : queue2){
            q2.add(temp);
            s2 += temp;
        }

        long sum = s1 + s2;

        if(sum%2 ==1){
            return -1;
        }

        sum /= 2;

        int limit = queue1.length*2;
        int p1 =0, p2=0;
        while(p1<=limit && p2<=limit){
            if(s1==sum){
                answer = p1+p2;
                System.out.println(answer);
                return p1+p2;
            }
            if (s1 > sum) {
                s1 -= q1.peek();
                s2 += q1.peek();
                q2.add(q1.poll());
                p1++;
            } else {
                s2 -= q2.peek();
                s1 += q2.peek();
                q1.add(q2.poll());
                p2++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ////{3, 2, 7, 2}; //{4, 6, 5, 1}; 2
        ////{1, 2, 1, 2}; //{1, 10, 1, 2};  7
        int a[] = {1, 2, 1, 2};
        int b[] = {1, 10, 1, 2};
        Solution110 sol = new Solution110();
        sol.solution(a,b);
    }
}
