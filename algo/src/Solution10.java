import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/64065
//튜플
public class Solution10 {
    static int n;
    public ArrayList<List<Integer>> getList(String s){
        s = s.replace("{", "");
        s = s.replace("},", "|");
        s = s.replace("}", "");
       String[] list = s.split("\\|");

       ArrayList<List<Integer>> arrayList = new ArrayList<>();
       Arrays.sort(list, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
       });
       n = list.length;
       for (int i = 0; i < list.length; i++) {
           String[] li = list[i].split(",");
           List<Integer> intList = new ArrayList<>();
           for (int j = 0; j < li.length; j++) {

            intList.add(Integer.parseInt(li[j]));
           }
           arrayList.add(intList);
       }
       return arrayList;
    }

    public int[] solution(String s) {
        int[] answer = {};
        s = "{{20,111},{111}}";//"{{2,1},{2},{2,1,3},{2,1,3,4}}";//"{{4,2,3},{3},{2,3,4,1},{2,3}}";//
        int[] visit = new int[1000000];
        ArrayList<List<Integer>> arrayList = getList(s);
        answer = new int[n];
        for(int i=0; i<arrayList.size(); i++){
            for(int j=0; j<arrayList.get(i).size(); j++){
                int temp = arrayList.get(i).get(j);
                if(visit[temp] == 0){
                    answer[i] = temp;
                    visit[temp] =1;
                    break;
                }
            }
        }

        for(int a : answer){
        System.out.println(a);
    }
        return answer;
    }

    public static void main(String[] args) {
        Solution10 s10 = new Solution10();
        s10.solution("t");
    }
}
