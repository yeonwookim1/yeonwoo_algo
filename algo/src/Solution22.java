import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Solution22 {
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x= x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static List<Point> chicken;
    static List<Point> home;
    static int ans = 999999;
    public int cal(List<Integer> idxList){
        int totalDistance = 0;
        for(int i=0; i<home.size(); i++){
            int temp = 99999;
            for(int j=0; j<idxList.size(); j++){
                Point homeTemp = home.get(i);
                Point chickenTemp = chicken.get(idxList.get(j));
                int min = Math.abs(homeTemp.x - chickenTemp.x) + Math.abs(homeTemp.y - chickenTemp.y);
                if(temp > min){
                    temp = min;
                }
            }
            totalDistance += temp;
        }
        return totalDistance;
    }
    public void selectChicken(int idx, List<Integer> idxList){
        if(idxList.size()>= M){
            int num = cal(idxList);
            if(num < ans){
                ans = num;
            }
            return;
        }

        for(int i=idx; i<chicken.size(); i++){
            idxList.add(i);
            selectChicken(i+1, idxList);
            idxList.remove(idxList.size()-1);
        }
    }
    public void solution(){
        selectChicken(0, new ArrayList<>());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int arr[][] = new int[N][N];
        chicken= new ArrayList<>();
        home = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 2){
                    chicken.add(new Point(i,j));
                } else if(arr[i][j] ==1){
                    home.add(new Point(i,j));
                }
            }
        }

        Solution22 sol = new Solution22();
        sol.solution();
        System.out.println(ans);

    }
}
