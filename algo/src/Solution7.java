import java.util.ArrayList;

//코딩테스트 연습 2018 KAKAO BLIND RECRUITMENT [1차] 프렌즈4블록

//https://programmers.co.kr/learn/courses/30/lessons/17679?language=java

public class Solution7 {

    class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] visit;
    int[] dx = new int[3];
    int[] dy;

    public Solution7() {
        dx = new int[] { 0, 1, 1 };
        dy = new int[] { 1, 1, 0 };
    }

    public boolean check(int n, int m, String[][] map) {
        boolean isHit = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visit[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String now = map[i][j];
                if(now.equals(" ")){
                    continue;
                }
                ArrayList<Point> dm = new ArrayList<Point>();

                for (int k = 0; k < 3; k++) {
                    int dxx = i + dx[k];
                    int dyy = j + dy[k];
                    
                    if (dxx < 0 || dxx >= n || dyy < 0 || dyy >= m || !now.equals(map[dxx][dyy])) {
                        dm.clear();
                        break;
                    }
                    if (now.equals(map[dxx][dyy])) {
                        dm.add(new Point(dxx, dyy));
                    }
                }
                if (!dm.isEmpty()) {
                    isHit = true;
                    visit[i][j] = 1;
                    for (int w = 0; w < dm.size(); w++) {
                        Point temp = dm.get(w);
                        visit[temp.x][temp.y] = 1;
                    }

                    // for (int q = 0; q < n; q++) {
                    //     for (int z = 0; z < m; z++) {
                    //         System.out.print(visit[q][z] + " ");
                    //     }
                    //     System.out.println();
                    // }
                    // System.out.println("===================================================");
                }

            }
        }
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(visit[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("===================================================");
        return isHit;
    }

    public int solution(int n, int m, String[] board) {
        int answer = 0;
        visit = new int[n][m];
        String[][] map = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = board[i].split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = temp[j];
            }
        }

        while (true) {
            boolean hit = check(n, m, map);
            if (!hit) {
                break;
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (visit[i][j] == 1) {
                            map[i][j] = " ";
                            answer++;
                        }
                    }
                }
                //print(n, m, map);
                // fall_down
                for (int i = 0; i < m; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        boolean isSpace = false;
                        if (map[j][i].equals(" ")) {
                            //System.out.println("n : " + j +" m : " +i);
                            for (int k = j - 1; k >= 0; k--) {
                                if (!map[k][i].equals(" ")) {
                                    map[j][i] = map[k][i];
                                    map[k][i] = " ";
                                    isSpace = false;
                                    break;
                                }else{
                                    isSpace =true;
                                }

                            }
                        }
                        if(isSpace){
                            break;
                        }
                    }

                }
                //print(n, m, map);
            }

        }

        //System.out.println(answer);
        return answer;
    }

    public void print(int n, int m, String[][] map){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("============================");
    }
    public static void main(String[] args) {

        String[] ans = { "AAAAA","AUUUA","AUUAA","AAAAA" };
        new Solution7().solution(4, 5, ans);

    }
}
