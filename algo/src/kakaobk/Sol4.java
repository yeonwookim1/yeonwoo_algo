package kakaobk;

import java.util.Arrays;
import java.util.Comparator;

public class Sol4 {

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public long solution1(int[] height, int[] width) {
        long answer = -1;
        Point[] h = new Point[height.length];
        for(int i=0; i<height.length; i++){
            h[i] = new Point(height[i],i);
        }
        Arrays.sort(h, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.x - o1.x;
            }
        });

        for(Point p : h){
            System.out.println("p.x = " + p.x);
            System.out.println("width[p.y] = " + width[p.y]);
        }

        long totalLen = 0;

        for(int i=0; i<h.length; i++){
            totalLen += width[h[i].y];
            long size = h[i].x * totalLen;
            if(size > answer){
                answer = (long) size;
            }
        }

        System.out.println("answer = " + answer);
        return answer;
    }

    public long solution(int[] height, int[] width) {
        long answer = -1;
        long[][] books = new long[height.length+1][width.length+1];

//        Point h[] = new Point[height.length+1];


        for(int i=0; i<height.length; i++) {
            books[i][0] = height[i];
            books[i][1] = width[i];
//            h[i] = new Point(height[i],width[i]);
        }

//        Arrays.sort(h, new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                if(o1.x == o2.x){
//                    return o2.y - o1.y;
//                }
//                return o2.x - o1.x;
//            }
//        });

        Arrays.sort(books, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o2[0] == o1[0]) {
                    return (int) (o2[1] - o1[1]);
                }
                return (int) (o2[0] - o1[0]);
            }
        });

//        for(int i=0; i<books.length; i++){
//            System.out.println(books[i][0] + " " + books[i][1]);
//        }

        //[0] height
        //[1] width

        long totalLen = 0;
        for(long i=0; i<books.length; i++){
            totalLen += books[(int)i][1];
            long size = totalLen * (books[(int)i][0]);
//            System.out.println("size = " + size);
            if(size > answer){
                answer = (long) size;
            }
        }

//        long totalLen = 0;
//        for(int i=0; i<h.length; i++){
//            totalLen += h[i].y;
//            long size = totalLen * h[i].x;
////            System.out.println("size = " + size);
//            if(size > answer){
//                answer = (long) size;
//            }
//        }



        System.out.println("answer = " + answer);

        return answer;
    }

    public static void main(String[] args) {

        Sol4 sol4 = new Sol4();
        int h1[] = new int[400000];
        int w1[] = new int[400000];

//        sol4.solution(h1,w1);

        int h[] = {140,21,21,32};
        int w[] = {2,1,3,7};
        sol4.solution(h,w);
        sol4.solution1(h,w);
    }
}
