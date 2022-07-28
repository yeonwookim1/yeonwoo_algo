package kakao;

import java.util.*;

public class Solution47 {
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
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    char[][] board;
    int m,n;
    List<Character> list;// = new LinkedList<>();
    HashMap<Character, int[][]> map;// = new HashMap<>();

    public String solution(int m, int n, String[] board) {
        this.m = m;
        this.n= n;
        this.board = new char[m][n];
        list  = new LinkedList<>();
        map = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                this.board[i][j] = c;
                if(c!='.' && c!='*'){
                    if(!list.contains(c)){
                        list.add(c);
                        map.put(c,new int[2][2]);
                        map.get(c)[0][0] = i;
                        map.get(c)[0][1] = j;
                    }else{
                        map.get(c)[1][0] = i;
                        map.get(c)[1][1] = j;
                    }
                }
            }
        }
        Collections.sort(list);

        // ('A' , {1,2},{2,4})

        int idx =0;
        String answer = "";
        while(list.size()!=0){
            if(canDelete(list.get(idx))){
                char pop = list.remove(idx);
                answer += pop;
                //print();
                deleteChar(pop);
                //print();
                idx = 0;
            }else{
                idx++;
                if(idx==list.size()){
                    answer = "IMPOSSIBLE";
                    break;
                }
            }
        }

        System.out.println(answer);
        return answer;
    }
    void deleteChar(char c){
        board[map.get(c)[0][0]][map.get(c)[0][1]] = '.';
        board[map.get(c)[1][0]][map.get(c)[1][1]] = '.';
    }

    boolean check(char c){
        int r1 = map.get(c)[0][0];
        int c1 = map.get(c)[0][1];
        int r2 = map.get(c)[1][0];
        int c2 = map.get(c)[1][1];
        if(c1<c2){
            if(calCheck(c1,c2,r1,c) && rowCheck(r1,r2,c2,c)){
                return true;
            }
            if(calCheck(c1,c2,r2,c) && rowCheck(r1,r2,c1,c)){
                return true;
            }
        }else {
            if(calCheck(c2,c1,r1,c) && rowCheck(r1,r2,c2,c)){
                return true;
            }
            if(calCheck(c2,c1,r2,c) && rowCheck(r1,r2,c1,c)){
                return true;
            }
        }
        return false;
    }
    boolean calCheck(int c1, int c2, int r, char c){
        for(int i=c1; i<=c2;i++){
            if(board[r][i] != '.' && board[r][i] != c){
                return false;
            }
        }
        return true;
    }
    boolean rowCheck(int r1, int r2, int c1, char c){
        for(int i=r1; i<=r2;i++){
            if(board[i][c1] != '.' && board[i][c1] != c){
                return false;
            }
        }
        return true;
    }

    boolean canDelete(char c){
        int r1 = map.get(c)[0][0];
        int c1 = map.get(c)[0][1];

        Queue<Point> q = new LinkedList<>();
        int visitMap[][] = new int[m][n];
        visitMap[r1][c1]=1;
        q.add(new Point(r1,c1,-1,0));

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
                if(ddirCnt>2) {
                    continue;
                }

                if(visitMap[xx][yy] == 0 && board[xx][yy] == '.'){
                    q.add(new Point(xx, yy, ddir, ddirCnt));
                    visitMap[xx][yy]=1;
                }
                if(visitMap[xx][yy] == 0 &&board[xx][yy] == c){
                    return true;
                }
            }
        }
        return false;
    }


    public void print(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int m =2;
        int n=4;
        String[] data = {"NRYN", "ARYA"};//
        Solution47 sol = new Solution47();
//        sol.solution(m,n,data);
////
//        String[] data2 = {"AB", "BA"};
////
//        sol.solution(2,2,data2);
////
//        String[] data3 = {"AA"};
//
//        sol.solution(1,2,data3);
//
//        String[] data4 = {"M...M...DU", "....AR...R", "...E..OH.H", ".....O....", ".E..A..Q..", "Q....LL.*.", ".D.N.....U", "GT.T...F..", "....FKS...", "GN....K..S"};
//        sol.solution(10,10,data4);
//
//        String[] data5 = {"A...", "....", "....", "...A"};
//        sol.solution(4,4,data5);
//
//        String[] data6 = {".ZI.", "M.**", "MZU.", ".IU."};
//        sol.solution(4,4, data6);
//
//        String[] data7 = {"A..", "..*", "*.A"};
//        sol.solution(3,3,data7);
//
//        String[] data8 ={"AB.",".B*",".*A"};
//        sol.solution(3,3,data8);

        String[] data9 = {"A.B", "*B*", ".A."};
        /**
         * A.B
         * *B*
         * .A.
         */
        sol.solution(3,3,data9);

    }
}
