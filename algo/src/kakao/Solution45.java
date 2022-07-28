package kakao;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/1836
//리틀프렌즈사천성
public class Solution45 {
    class Point{
        int x1,y1,x2,y2;

        public void setX1(int x1) {
            this.x1 = x1;
        }

        public void setY1(int y1) {
            this.y1 = y1;
        }

        public void setX2(int x2) {
            this.x2 = x2;
        }

        public void setY2(int y2) {
            this.y2 = y2;
        }
    }
    int[][] dxy = {{-1,0,1,0},{0,1,0,-1}};

    Map<Character, Point> block;
    List<Map.Entry<Character, Point>> list;

    char map[][];
    int m,n;

    public String solution(int m, int n, String[] board) {
        String answer = "";
        this.m = m;
        this.n =n;
        this.map = new char[m][n];

        block = new HashMap<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                char c = board[i].charAt(j);
                this.map[i][j] = c;
                if(c != '.' && c!='*') {
                    if (!block.containsKey(c)) {
                        Point point = new Point();
                        point.setX1(i);
                        point.setY1(j);
                        block.put(c, point);
                    } else {
                        block.get(c).setX2(i);
                        block.get(c).setY2(j);
                    }
                }
            }
        }
        list = new ArrayList<>(block.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Point>>(){
            @Override
            public int compare(Map.Entry<Character, Point> e1, Map.Entry<Character, Point> e2){
                return e1.getKey() - e2.getKey();
            }
        });

//        for(Map.Entry<Character, Point> e : list){
//            System.out.println(e.getKey());
//        }
        int idx =0;
        while(list.size() != 0){
            if(check(idx)){
                answer += list.get(idx).getKey();
                int x1 = list.get(idx).getValue().x1;
                int y1 = list.get(idx).getValue().y1;
                int x2 = list.get(idx).getValue().x2;
                int y2 = list.get(idx).getValue().y2;
                map[x1][y1] = '.';
                map[x2][y2] = '.';
                list.remove(idx);
                idx = 0;
            }else{
//                System.out.println("idx = " + idx);

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

    public void print(){
        System.out.println();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean check(int idx){
        int x1 = list.get(idx).getValue().x1;
        int x2 = list.get(idx).getValue().x2;
        int y1 = list.get(idx).getValue().y1;
        int y2 = list.get(idx).getValue().y2;

        Queue<Block> q = new LinkedList<>();
        q.add(new Block(x1,y1,-1,0));

        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int dir = q.peek().dir;
            int dirCnt = q.peek().dirCnt;
            q.poll();

//            System.out.println(x +" "+y+" "+dir+" "+dirCnt);

            for(int i=0; i<4; i++){
                int xx = x + dxy[0][i];
                int yy = y + dxy[1][i];
                int ddirCnt = dirCnt;
                if(xx<0 || xx>=m || yy<0||yy>=n){
                    continue;
                }
                if(dir != i){
                    ddirCnt++;
                }
                if(ddirCnt>2){
                    continue;
                }
                if(map[xx][yy] == '.'){
                    q.add(new Block(xx,yy,i,ddirCnt));
                }else if(map[xx][yy] == '*'){
                    continue;
                }else{
                    if(xx==x2 && yy==y2){
                        return true;
                    }
                }
            }

        }

        return false;
    }

    class Block{
        int x,y,dir,dirCnt;
        public Block(int x, int y, int dir, int dirCnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.dirCnt = dirCnt;
        }
    }
    public static void main(String[] args) {
        String data[] = {".ZI.", "M.**", "MZU.", ".IU."};
        Solution45 sol = new Solution45();
        sol.solution(4,4,data);

        String[] data9 = {"A.B", "*B*", ".A."};
        String[] data10 = {"..A", "...",".A*"};
        /**
         * ..A
         * ...
         * .A*
         */
        sol.solution(3,3,data10);

    }
}
