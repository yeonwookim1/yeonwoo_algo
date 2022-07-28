
//https://programmers.co.kr/learn/courses/30/lessons/43162
//네트워크
public class Solution9 {
    int visit[][];
    int n;
    int ans;
    public void dfs(int idx, int[][] computers){
        for(int i=0; i<n; i++){
            if(idx==i){
                visit[idx][i] =1;
                continue;
            }
            if(visit[idx][i] == 0 && computers[idx][i] ==1){
                visit[idx][i] = 1;
                dfs(i,computers);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        ans = 0;
        visit = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visit[i][j] == 0 && computers[i][j] ==1){
                    dfs(j,computers);
                    ans++;
                }
            }
        }
        answer = ans;
        return answer;
    }

    public static void main(String[] args) {
        Solution9 s9 = new Solution9();
        int arr[][] = //{{1, 1, 0}, {1, 1,1}, {0, 1, 1}};
        {{1, 1, 0}, {1, 1,0}, {0, 0, 1}};
        s9.solution(3, arr);
    }
}
