import java.util.Arrays;
import java.util.Comparator;

public class Solution27 {

    public String[] solution(String[] strings, int n) {
        String[] answer = {};System.out.println("d");
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                System.out.println(s1.charAt(n) + " " +s2.charAt(n));
                if(Character.compare(s1.charAt(n),s2.charAt(n)) >0){
                    return 1;
                }else if(Character.compare(s1.charAt(n),s2.charAt(n)) <0){
                    return -1;
                }else{
                    System.out.println(s1 + " " +s2);
                    return s1.compareTo(s2);
                }
            }
        });


        answer = strings;
        return answer;
    }

    public static void main(String[] args) {

        String a = "abcd";
        String b = "abce";
        String temp[] = {"sun", "bed", "car"};
        new Solution27().solution(temp,1);
    }
}
