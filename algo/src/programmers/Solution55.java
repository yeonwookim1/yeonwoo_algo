package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/68936
//쿼드압축 후 개수 세기
public class Solution55 {

    int oneCnt;
    int zeroCnt;
    int arr[][];
    public boolean check(int n, int m, int nn, int mm){
        boolean isZero = false;
        boolean isOne = false;
        for(int i=n; i<=nn; i++){
            for(int j=m; j<=mm; j++){

                if(arr[i][j] == 0){
                    isZero = true;
                }
                if(arr[i][j] ==1){
                    isOne = true;
                }
                if(isOne && isZero){
                    return false;
                }
            }
        }
        if(isOne){
            oneCnt++;
        }
        if(isZero){
            zeroCnt++;
        }
        return true;
    }

    public void map(int n, int m, int nn, int mm){
        System.out.println(n + " " + m+ " " +nn+ " " +mm);
        if(n==nn && m==mm){
            if(arr[n][m]==1){
                oneCnt++;
                return;
            }else{
                zeroCnt++;
                return;
            }
        }
        if(!check(n,m,nn,mm)){
            map(n, m, (nn + n) / 2, (mm + m) / 2);
            map(n, ((mm + m) / 2) + 1, (nn + n) / 2, mm);
            map(((nn + n) / 2) + 1, m, nn, (mm + m) / 2);
            map(((nn + n) / 2) + 1, ((mm + m) / 2) + 1, nn, mm);
        }
    }

    public int[] solution(int[][] arr) {
        int[] answer = {};
        this.arr = arr;
        oneCnt = 0;
        zeroCnt = 0;
        map(0,0,arr.length-1, arr[0].length-1);

        System.out.println("mapCnt = " + zeroCnt);
        System.out.println("oneCnt = " + oneCnt);
        return answer;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,1,0,0,},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        Solution55 sol = new Solution55();
        sol.solution(arr);
    }
}
