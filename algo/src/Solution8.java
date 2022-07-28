import java.util.ArrayList;
import java.util.List;

public class Solution8 {
    // source underline wasn't use Dp
    // public int n;
    // public int ans;
    // public void dfs(int[][] triangle, int idx, int summ, int cnt){
    //     if(cnt >= n){
    //         if(summ > ans){
    //             ans = summ;
    //         }
    //         return;
    //     }

    //     for(int i=idx; i<idx+2; i++){
    //         summ += triangle[cnt][i];
    //         dfs(triangle, i, summ, cnt+1);
    //         summ -= triangle[cnt][i];
    //     }

    // }

    // public int solution(int[][] triangle) {
    //     int answer = 0;
    //     //첫 7 합치기
    //     n = triangle.length;
    // ans = -1;
    // dfs(triangle, 0, 0, 1);

    // answer = ans + triangle[0][0];
    // System.out.println(answer);
    // return answer;
    // }

    int n;
    int[][] map;

    public int solution(int[][] triangle) {
        int answer = 0;
        n = triangle.length;

       List<Integer>[] arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(i==n-1){
                    arr[i].add(triangle[i][j]);
                }else{arr[i].add(0);}
                
            }
        }
        for(int i = n-1; i>0; i--){
            for(int j=0; j< triangle[i].length; j++){
                boolean isFristEx = false;
                boolean isLastEx = false;
                if (j == 0) {
                    isLastEx = true;
                } else if (j == triangle[i].length - 1) {
                    isFristEx = true;
                }
                if (!isFristEx) {
                    int tempRight = arr[i].get(j) + triangle[i - 1][j];
                    if (arr[i - 1].get(j) < tempRight) {
                        arr[i - 1].set(j, tempRight);
                    }
                }
                if (!isLastEx) {
                    int tempLeft = arr[i].get(j) + triangle[i - 1][j - 1];
                    if (arr[i - 1].get(j - 1) < tempLeft) {
                        arr[i - 1].set(j - 1, tempLeft);
                    }
                }
            }
        }


        // for(int i=0; i<n; i++){
        //     for(int j=0; j<arr[i].size(); j++){
        //         System.out.print(arr[i].get(j));
        //     }
        //     System.out.println();
        // }
        answer = arr[0].get(0);
        return answer;
    }

    public static void main(String[] args) {
        Solution8 s = new Solution8();
        int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
        s.solution(triangle);
    }
}
