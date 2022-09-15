package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/118666
//성격 유형 검사
public class Solution109 {

    class Point{
        String first;
        String end;
        Map<String, Integer> m1;
        Map<String, Integer> m2;
        public Point(String first, String end){
            this.first = first;
            this.end = end;
            m1 = new HashMap<>();
            m2 = new HashMap<>();
            m1.put(first,0);
            m2.put(end,0);
        }

        public void addCount(String str, int cnt){
            if(str.equals(this.first)){
                int a = m1.get(str) + cnt;
                m1.replace(str,a);
            }else{
                int a = m2.get(str) + cnt;
                m2.replace(str,a);
            }
        }

        public String getStr(){
            if(m1.get(first) < m2.get(end)){
                return end;
            }else{
                return first;
            }
        }

    }

    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
//        Map<Integer, Point> map = new HashMap<>();
        List<Point> list = new ArrayList<>();
        list.add(new Point("R","T"));
        list.add(new Point("C","F"));
        list.add(new Point("J","M"));
        list.add(new Point("A","N"));

        for(int i=0; i<survey.length; i++){
            String temp[] = survey[i].split("");

            //idx로 RT / CF/ JM / AN 구분
            int idx;

            if(temp[0].equals("R") || temp[0].equals("T")){
                idx =0;
            }else if(temp[0].equals("C") || temp[0].equals("F")){
                idx =1;
            }else if(temp[0].equals("J") || temp[0].equals("M")){
                idx =2;
            }else{
                idx =3;
            }

            //addCount 매서드를 만들어서 map1, map2 카운트를 넣어줌
            int score = 0;
            if(choices[i]<4){   //temp[0]이 증가
                score = 4-choices[i];
                list.get(idx).addCount(temp[0],score);
            }else if(choices[i] >4){    //temp[1]이 증가
                score = choices[i] - 4;
                list.get(idx).addCount(temp[1],score);
            }

        }

        for(Point p : list){
//            System.out.println(p.getStr());
            sb.append(p.getStr());
        }

//        for(Point p : list){
//            System.out.println("p.m1 = " + p.m1);
//            System.out.println("p.m2 = " + p.m2);
//        }


        return sb.toString();
    }

    public static void main(String[] args) {
        Solution109 sol = new Solution109();
        String survey[] = //{"AN", "CF", "MJ", "RT", "NA"};
        {"TR", "RT", "TR"};
        int choices[] = {7,1,3};//{5, 3, 2, 7, 5};
        sol.solution(survey,choices);
    }
}
