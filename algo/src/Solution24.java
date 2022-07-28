import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//https://school.programmers.co.kr/learn/courses/30/lessons/17686
//[3차] 파일명 정렬
public class Solution24 {class Point{
    String name;
    String head;
    int body;
    int idx;
    public Point(String name, String head, int body, int idx){
        this.name = name;
        this.head = head;
        this.body = body;
        this.idx = idx;
    }
}
    public Point cal(String s1, int idx){
        int a= 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbNum = new StringBuilder();
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) >= '0' && s1.charAt(i) <='9'){
                a = 1;
                sbNum.append(s1.charAt(i));
            }
            if((s1.charAt(i) < '0' || s1.charAt(i) >'9')){
                if(a==1){
                    break;
                }
                sb.append(s1.charAt(i));
            }
        }
        String ss1 = sb.toString().toLowerCase();
        Integer num1 = Integer.parseInt(sbNum.toString());
        System.out.println(num1);
        return new Point(s1, ss1, num1, idx);
    }




    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        List<Point> list = new ArrayList<>();
        for(int i=0; i<files.length; i++){
            list.add(cal(files[i],i));
        }
        Collections.sort(list, new Comparator<Point>(){

            @Override
            public int compare(Point s1, Point s2){
                if(s1.head.equalsIgnoreCase(s2.head)){
                    if(s1.body == s2.body){
                        return s1.idx - s2.idx;
                    } else{
                        return s1.body - s2.body;
                    }
                }else{
                    return s1.head.compareTo(s2.head);
                }
            }

        });

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).name;
            //System.out.println(answer[i]);
        }


//        answer = list.stream().toArray(String[]::new);
        return answer;
    }
    public static void main(String[] args) {

        String a = "aa";
        String b= "AA";
        System.out.println(a.compareTo(b));


        String files[] = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
    //    new Solution24().solution(files);


    }
}
