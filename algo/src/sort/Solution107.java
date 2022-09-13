package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/11650
//좌표 정렬하기
public class Solution107 {

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Point> list = new ArrayList<>();
        for(int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x,y));
        }

        Collections.sort(list, new Comparator<>(){

            @Override
            public int compare(Point p1, Point p2){
                if(p1.x != p2.x){
                    return p1.x - p2.x;
                }else{
                    return p1.y - p2.y;
                }
            }
        });

        for(Point p : list){
            System.out.println(p.x + " " +p.y);
        }
    }
}
