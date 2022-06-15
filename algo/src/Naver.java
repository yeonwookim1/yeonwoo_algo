import java.util.ArrayList;

public class Naver {
    int[][] dices;
    int visit[] = new int[10000];
    int n,m;
    static ArrayList<Integer> list = new ArrayList<>();

    public void search(int idx, int cnt){
        if(cnt <= n){
            int temp = 0;
            int multi = 1;
            for(int i=list.size()-1; i>=0; i--){
                temp += list.get(i)*multi;
                multi *= 10;
            }
            visit[temp] =1;
        } else{
            return;
        }
        if(cnt==n){
            return;
        }
        for(int i=0; i<n; i++){
            if(idx == i){
                continue;
            }
            for(int j=0; j<m; j++){
                list.add(dices[i][j]);
                search(i, cnt+1);
                list.remove(list.size()-1);
            }
        }

    }

    public int solution(int[][] dice) {
        int answer = 0;
        n= dice.length;
        m = 6;
        dices = dice;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dices[i][j]==0){
                    continue;
                }
                list.add(dices[i][j]);
                search(i, 1);
                list.remove(list.size()-1);
            }
        }

        for(int i=1; i<visit.length; i++){
            if(visit[i] != 1){
                System.out.println("@@@" + visit[i] + "idx : " + i);
                answer = visit[i];
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] dice = {{1, 6, 2, 5, 3, 4},{9, 9, 1, 0, 7, 8}};
        int[][] dice2 = {{0, 1, 5, 3, 9, 2}, {2, 1, 0, 4, 8, 7}, {6, 3, 4, 7, 6, 5}};
        new Naver().solution(dice2);
    }
}
