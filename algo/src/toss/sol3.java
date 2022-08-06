package toss;

public class sol3 {
    int k;
    int arr[][];
    int visit[];
    int ans = -1;
    public void bt(int life, int score){
        if(life<=0){
            System.out.println(score);
            if(ans < score){
                ans = score;
            }
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(visit[i]==0 &&arr[i][0] <= life){ //ar[i][0] 요구 체력
                visit[i]=1;
                bt(life-arr[i][1], score+1); //arr[i][1] 사용체력
                visit[i]=0;
            }
        }

        if(ans < score){
            ans = score;
        }
    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        this.k = k;
        this.arr = dungeons;
        this.visit = new int[dungeons.length];
        bt(k, 0);
        return answer;
    }



    public static void main(String[] args) {
        sol3 sol = new sol3();

        int arr[][] = {{80,20}, {50,40},{30,10}};
        sol.solution(80,arr);
    }
}
