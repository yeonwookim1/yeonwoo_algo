
//https://programmers.co.kr/learn/courses/30/lessons/92342
//2022 KAKAO BLIND RECRUITMENT 양궁대회

public class Solution14 {
    class Ans{
        int ans;
        int ansIdx;
        int ansIdxCnt;
        public Ans(){
            this.ans = -1;
            this.ansIdx= 0;
            this.ansIdxCnt = 0;
        }
    }
    int[] visit;
    int[] result;
    
    int[] info;
    int n;
    Ans resultAns;
    
    public void calScore(int[] arrA, int[] arrR){
        
        int totalA = 0;
        int totalR = 0;
        Ans temp = new Ans();
        
        int dis = 10;
        for(int i=0; i<11; i++){
            int score = i + dis;
            dis -= 2;
            if(arrA[i] == 0 && arrR[i] == 0){
                continue;
            }
            if(arrA[i] < arrR[i]){
                totalR += score;//*arrR[i];
            } else{ // if(arrA[i] > arrR[i]){
                totalA += score;//*arrA[i];
            } 
            
            if(arrR[i] != 0){
                temp.ansIdx = i;
                temp.ansIdxCnt = arrR[i];
            }
        }
        temp.ans = totalR - totalA;
        // System.out.println(totalR +   " - " + totalA);
        if(temp.ans <= 0){
            return;
        }
        boolean isChange = false;
        if(temp.ans > resultAns.ans){
            isChange = true;
        } else if(temp.ans == resultAns.ans){
            if(temp.ansIdx > resultAns.ansIdx){
                isChange = true;
            }else if(temp.ansIdx == resultAns.ansIdx){
                if(temp.ansIdxCnt > resultAns.ansIdxCnt){
                    isChange = true;
                } 
            }
        }
        if(isChange){
            resultAns.ans = temp.ans;
            resultAns.ansIdx = temp.ansIdx;
            resultAns.ansIdxCnt = temp.ansIdxCnt;
            // for(int a : visit){
            //     System.out.print(a + " ");
            // }
            // System.out.println(" || " + totalR +   " - " + totalA);
            // System.out.println();
            for(int i=0; i<11; i++){
                result[i] = visit[i];
            }
            // System.out.println(System.identityHashCode(result) + " ");
        }
        
    }
    
    public void dfs(int idx, int cnt){
        if(cnt >= n){
            calScore(info, visit);
            return;
        }
        
        for(int i=idx; i<info.length; i++){
            if(visit[i] - info[i] >=2){
                continue;
            }
            visit[i]++;
            dfs(i,cnt+1);
            visit[i]--;
        }
        
    }
    
    public int[] solution(int n, int[] info) {
        int[] answer;
        this.n = n;
        this.info = info;
        resultAns = new Ans();
        visit = new int[11];
        result = new int[11];
        
        dfs(0,0);
        if(resultAns.ans <= 0 ){
            result = new int[1];
            result[0] = -1;
        }
        return result;
    }
    public static void main(String[] args) {
        int info[] = {2,1,1,1,0,0,0,0,0,0,0};
        new Solution14().solution(5, info);
    }
}