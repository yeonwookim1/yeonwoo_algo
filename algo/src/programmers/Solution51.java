package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/49994
//방문길이
public class Solution51 {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int solution(String dirs) {
        int answer = 0;
        int arr[][] = new int[11][11];
        int visit[][][][] = new int[11][11][11][11];
        int x = 5;
        int y = 5;
        for(int i=0; i<dirs.length(); i++){
            int dir = 0;
            switch(dirs.charAt(i)){
                case 'U':
                    dir = 0;
                    break;
                case 'D':
                    dir = 2;
                    break;
                case 'L':
                    dir = 3;
                    break;
                default:
                    dir = 1;
                    break;
            }

            int xx = x+dx[dir];
            int yy = y + dy[dir];
            if(xx<0 || xx>=11 || yy<0||yy>=11){
                continue;
            }
            if(visit[xx][yy][x][y] ==0 && visit[x][y][xx][yy] ==0){
                visit[xx][yy][x][y] = 1;
                visit[x][y][xx][yy] = 1;
                answer++;
            }
            x = xx;
            y = yy;
        }
        System.out.println("answer = " + answer);

        return answer;
    }
    public static void main(String[] args) {
        Solution51 sol = new Solution51();
        String dirs = "ULURRDLLU";
        sol.solution(dirs);
    }
}

