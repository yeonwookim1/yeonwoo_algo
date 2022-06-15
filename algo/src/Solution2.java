import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int[] dx = {-1,0,1,0};
    public int[] dy = {0,1,0,-1};

    class human{
        int x;
        int y;
        int cnt;
        public human(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public boolean sol(String[] room){
        String[][] map = new String[5][5];
        boolean[][] visit = new boolean[5][5];
        ArrayList<human> h = new ArrayList<human>();

        for(int i=0; i<room.length; i++){
            String[] temp = room[i].split("");
            for(int j=0; j<temp.length; j++){
                map[i][j] = temp[j];
                visit[i][j] = false;
                // System.out.println(temp[j]);
                if(temp[j].equals("P")){
                    // System.out.println(i + " : " + j);
                    h.add(new human(i,j,0));
                }
                
            }
        }

        // for(int i=0; i<5; i++){
        //     for(int j=0; j<5; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        for(int i=0; i<h.size(); i++){

            Queue<human> q = new LinkedList<>();
            q.add(h.get(i));


            while(!q.isEmpty()){
                human temp = q.poll();
                int hx = temp.x;
                int hy = temp.y;
                int hCnt = temp.cnt;
                visit[hx][hy] = true;
                if(hCnt > 2){
                    break;
                }
                for(int k=0; k<4; k++){
                    int xx = hx + dx[k];
                    int yy = hy + dy[k];
                    if(xx <0 || yy<0|| xx>4||yy>4){
                        continue;
                    }
                    if(visit[xx][yy] == false && map[xx][yy] != "X"){
                        if(map[xx][yy].equals("P") && hCnt < 2){
                            // System.out.println(map[hx][hy]);
                            // System.out.println("hx : " + hx + " hy : " + hy);
                            // System.out.println("거리두기 OUT   XX : " + xx + "  YY :"  + yy);
                            // System.out.println("cnt : " + hCnt);
                            return false;
                        }
                        if(map[xx][yy].equals("O")){
                            int t = hCnt +1;
                            q.add(new human(xx, yy, t));
                        }
                    }

                }
            }

            for(int idx=0; idx<5; idx++){
                for(int j=0; j<5; j++){
                    visit[idx][j] = false;
                }
            }


        }
        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<places.length; i++){
            
                if(sol(places[i])){
                    answer[i] = 1;
                } else{
                    answer[i] = 0;
                }
            
            
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        String[][] qa = {
            
            {"POOOP", 
            "OXXOX", 
            "OPXPX",
             "OOXOX", 
             "POXXP"}, 
        {
        "POOPX", 
        "OXPXP", 
        "PXXXO", 
        "OXXXO", 
        "OOOPP"}, 

        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        sol.solution(qa);
    }
    
}
