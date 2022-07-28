package kakao;

import java.util.*;

public class Solution46 {
    class Point{
        int x;
        int y;
        int dir;
        int dirCnt;
        public Point(int x, int y, int dir, int dirCnt){
            this.x = x;
            this.y = y;
            this.dir =dir;
            this.dirCnt = dirCnt;
        }
    }
    static int visit[];

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int n,m;
    static List<Character> list;
    static Set<String> set;
    public boolean bfs(char c, int a, int b, char[][] map){

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(a,b,-1,0));

        int visitMap[][] = new int[m][n];
        visitMap[a][b]=1;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int dir = q.peek().dir;
            int dirCnt = q.peek().dirCnt;
            q.poll();

            for(int i=0; i<4; i++){
                int xx = x +dx[i];
                int yy = y+dy[i];
                if(xx<0 || xx>=m || yy <0 || yy>=n){
                    continue;
                }
                int ddir = i;
                int ddirCnt = dirCnt;
                if(dir!= ddir){
                    ddirCnt++;
                }

                if(visitMap[xx][yy] == 0 && map[xx][yy] == '.'){
                    if(ddirCnt<=2) {
                        q.add(new Point(xx, yy, ddir, ddirCnt));
                    }
                }
                if(visitMap[xx][yy] == 0 &&map[xx][yy] == c){
//                    System.out.println("c = " + c);
//                    System.out.println("clear  :  " + map[xx][yy]);
                    return true;
                }

            }
        }

        return false;
    }

    public char[][] changeMap(char c, char[][] map){
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = map[i][j];
                if(map[i][j] == c){
                    arr[i][j] = '.';
                }
            }
        }
//
        print(m,n,arr);
        return arr;
    }
    public void dfs(char[][] arr){
        boolean isCheck = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] >= 'A' && arr[i][j] <= 'Z') {
                    isCheck = true;
                    break;
                }
            }
            if(isCheck){
                break;
            }
        }

        if(!isCheck){
            StringBuffer sb = new StringBuffer();
            for(char a : list){
                sb.append(a);
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] >= 'A' && arr[i][j] <= 'Z') {
                    int charIdx = arr[i][j] - 65;
                    if (visit[charIdx] == 0) {
                        if (bfs(arr[i][j], i, j, arr)) { //true : match
                            visit[charIdx] = 1;
                            char temp = arr[i][j];
                            list.add(temp);
                            dfs(changeMap(arr[i][j], arr));
                            //map을 이전으로
                            list.remove(list.size()-1);
                            visit[charIdx] = 0;
                        }
                    }
                }
            }
        }
    }

    public String solution(int m, int n, String[] board) {
        String answer = "";
        visit = new int[28];
        list = new ArrayList<>();
        set = new HashSet<>();
        char map[][] = new char[m+1][n+1];
        this.m = m;
        this.n = n;
        for(int i=0; i<m; i++) {
            String[] cStr = board[i].split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = cStr[j].charAt(0);
            }
        }

        dfs(map);

        if(set.size()==0){
            answer = "IMPOSSIBLE";
        }else{
            List tempList = new ArrayList(set);
            Collections.sort(tempList);
            answer = tempList.get(0).toString();
//            System.out.println(tempList.get(0));

        }

//        for(String s : set){
//            System.out.println(s);
//        }

        System.out.println(answer);

        return answer;
    }

    public void print(int m, int n, char map[][]){
        System.out.println();
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int m =2;
        int n=4;
        String[] data = {"NRYN", "ARYA"};//
        Solution46 sol = new Solution46();
        sol.solution(m,n,data);
//
        String[] data2 = {"ZA", "ZA"};
//
        sol.solution(2,2,data2);
//
//        String[] data3 = {"AA"};
//
//        sol.solution(1,2,data3);

//        String[] data4 = {"M...M...DU", "....AR...R", "...E..OH.H", ".....O....", ".E..A..Q..", "Q....LL.*.", ".D.N.....U", "GT.T...F..", "....FKS...", "GN....K..S"};
//        sol.solution(10,10,data4);

        String[] data5 = {"A...", "....", "....", "...A"};
        sol.solution(4,4,data5);
        /**
         * NRYN
         * ARYA
         */
    }
}
