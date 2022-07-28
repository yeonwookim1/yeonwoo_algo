import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/17683#
//방금그곡
public class Solution23 {

    public int calTime(String a, String b){
        String preTime[] = a.split(":");
        String nowTime[] = b.split(":");
        int preHour = Integer.parseInt(preTime[0]);
        int preMin = Integer.parseInt(preTime[1]);
        int nowHour = Integer.parseInt(nowTime[0]);
        int nowMin = Integer.parseInt(nowTime[1]);

        if(preHour == nowHour){
            return nowMin - preMin;
        } else{
            if(nowMin > preMin){
                return (nowMin - preMin) + (nowHour - preHour)*60;
            }else if (nowMin < preMin){
                nowHour -= 1;
                nowMin += 60;
                return (nowMin - preMin) + (nowHour - preHour)*60;
            } else{
                return 60;
            }

        }
    }

    public String changeSong(String m){
        StringBuilder sb = new StringBuilder();
        char a = ' ';
        for(int i=0; i<m.length(); i++){
            if(m.charAt(i)=='#'){
                sb.deleteCharAt(sb.length()-1);
                sb.append(Character.toLowerCase(a));
            } else{
                sb.append(m.charAt(i));
            }
            a = m.charAt(i);
        }
        return sb.toString();
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = changeSong(m);

        String memoryName = "";
        int memoryTime = 0;
        for(int i=0; i<musicinfos.length; i++){


            String temp[] = musicinfos[i].split(",");
            int time = calTime(temp[0], temp[1]);
            String song = changeSong(temp[3]);
            StringBuilder tempSb = new StringBuilder();
            int idx = 0;
            for(int j=0; j<time; j++){

                if(idx>=song.length()){
                    idx = 0;
                }
                tempSb.append(song.charAt(idx));
                idx++;
            }
            if(tempSb.toString().indexOf(m) >=0){

                if(memoryName != ""){
                    if(memoryTime < time){
                        memoryTime = time;
                        memoryName = temp[2];
                    }
                } else{
                    memoryName = temp[2];
                    memoryTime = time;
                }


            }
        }
        if(memoryName != ""){
            answer = memoryName;
        }

        return answer;
    }

    public static void main(String[] args) {
        String a = "a";
        String b= "C";
        System.out.println(Character.isDigit('3'));
        System.out.println(Character.isDigit(':'));
        System.out.println(Character.isDigit(' '));
        System.out.println(Character.isDigit('.'));
        if(a.toLowerCase().equals(b.toLowerCase())){

        }
    }
}
