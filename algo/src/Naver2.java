
import java.util.ArrayList;

public class Naver2 {

    ArrayList<Integer> makeList(String s){
        ArrayList<Integer> list = new ArrayList<>();
        String[] sList = s.split(":");

        for(int i=0; i<sList.length; i++){
            list.add(Integer.parseInt(sList[i]));
        }

        return list;
    }
    
    public int[] solution(String s, String[] times) {
        int[] answer = new int[2];
        ArrayList<Integer> slist = makeList(s);
        ArrayList<Integer> timeStamp = new ArrayList<>();
        timeStamp.add(slist.get(2));

        for(int i=0; i<times.length; i++){
            ArrayList<Integer> hlist = makeList(times[i]);

            int sec = hlist.get(3) + slist.get(5);
            if(sec>=60){
                sec -= 60;
                slist.set(4, slist.get(4)+1);
            }

            int min = hlist.get(2) + slist.get(4);
            if(min >= 60){
                min -= 60;
                slist.set(3, slist.get(3)+1);
            }

            int hour = hlist.get(1) + slist.get(3);
            if(hour >= 24){
                hour -= 24;
                slist.set(2, slist.get(2)+1);
            }

            int day = hlist.get(0) + slist.get(2);
            if(day >= 30){
                day -= 30;
                slist.set(1, slist.get(1)+1);
            }

            int month = slist.get(1);
            if(month >= 12){
                month -= 12;
                slist.set(0, slist.get(0)+1);
            }

            int year = slist.get(0);

            slist.set(0,year);
            slist.set(1,month);
            slist.set(2,day);
            slist.set(3,hour);
            slist.set(4,min);
            slist.set(5,sec);

            boolean isExsist = false;
            for(Integer a : timeStamp){
                if(a==slist.get(2)){
                    isExsist = true;
                    break;
                }
            }
            if(!isExsist){
                timeStamp.add(slist.get(2));
            }
        }

        System.out.println("timeStamp : " + timeStamp);

        int hold = timeStamp.get(timeStamp.size()-1) - timeStamp.get(0) + 1;
        int oneCnt = timeStamp.size();
        if(hold == oneCnt){
            answer[0] =1;
        } else{
            answer[0] = 0;
        }

        answer[1] = hold;

        for(int a : answer){
            System.out.println(a);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] temp = {"01:06:30:00","01:01:12:00","00:00:09:25"};
        String s="2021:04:12:16:08:35";
        new Naver2().solution(s, temp);
    }
}
