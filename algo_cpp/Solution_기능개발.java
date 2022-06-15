package com.java.algo;

import java.util.ArrayList;

public class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        int idx = 0;
        int[] answer = {};
        int len = progresses.length;
        // this.check = new Integer[len];
        // for(int i=0; i<check.length; i++){
        //     check[i] = 0;
        // }

        ArrayList<Integer> ans = new ArrayList<Integer>();

        boolean check = true;

        while (check) {
            int cnt =0;
            // one day work
            for (int i = 0; i < progresses.length; i++) {
                if(progresses[i] >= 100){
                    continue;
                }
                progresses[i] += speeds[i];
            }

            if (progresses[idx] >= 100) {
                for (int i = idx; i < progresses.length; i++) {
                    if (progresses[i] < 100) {
                        idx = i;
                        // System.out.println("IDX : " +idx);
                        break;
                    } else {
                        cnt++;
                        if(i == len-1){
                            check = false;
                        }
                    }
                }
                ans.add(cnt);
            }
        }
        answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
