package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/21608
//상어초등학교
public class Solution113 {

    static int N;
    static int map[][];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static class Position{
        int nearCnt;
        int emptyCnt;
        int r,c;

        public Position(int nearCnt, int emptyCnt, int r, int c) {
            this.nearCnt = nearCnt;
            this.emptyCnt = emptyCnt;
            this.r = r;
            this.c = c;
        }
    }

    static void move(int idx, Set<Integer> set){
        List<Position> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==0){
                    int loveCnt=0;
                    int emptyCnt=0;

                    for(int k=0; k<4; k++){
                        int x = i+dx[k];
                        int y = j+dy[k];
                        if(x<0 || y <0 || x>=N|| y>=N){
                            continue;
                        }
                        if(map[x][y]==0){
                            emptyCnt++;
                        }else{
                            if(set.contains(map[x][y])){
                                loveCnt++;
                            }
                        }
                    }

                    list.add(new Position(loveCnt, emptyCnt, i,j));

                }
            }
        }

        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Position p1, Position p2){
                if(p1.nearCnt == p2.nearCnt){
                    if(p1.emptyCnt == p2.emptyCnt){
                        if(p1.r == p2.r){
                            return p1.c - p2.c;
                        }else{
                            return p1.r-p2.r;
                        }
                    }else{
                        return p2.emptyCnt - p1.emptyCnt;
                    }
                }else{
                    return p2.nearCnt - p1.nearCnt;
                }
            }
        });

        Position p = list.get(0);
        map[p.r][p.c] = idx;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        Map<Integer, Set> studentMap = new HashMap<>();

        for(int i=0; i<N*N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int student = Integer.parseInt(st.nextToken());
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<4; j++){
                set.add(Integer.parseInt(st.nextToken()));
            }

            studentMap.put(student, set);
            move(student,set);
        }

        int ans = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {

                Set set = studentMap.get(map[i][j]);
                int cnt = 0;
                for(int k=0; k<4; k++){
                    int x = i+dx[k];
                    int y = j+dy[k];
                    if(x<0 || y <0 || x>=N|| y>=N){
                        continue;
                    }
                    if(set.contains(map[x][y])){
                        cnt++;
                    }
                }
                if(cnt==2){
                    cnt = 10;
                }else if(cnt == 3){
                    cnt = 100;
                }else if(cnt == 4){
                    cnt = 1000;
                }

//                System.out.println("cnt : " + cnt);
                ans += cnt;
            }
        }

        System.out.println(ans);

    }
}
