import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution11_mapSort {
    private HashMap<String, Integer> map;

    private void initMap(){
        map = new HashMap<>();
        
    }

    private void addMap(String str){
        if(map.containsKey(str)){
            int temp = map.get(str);
            map.put(str, temp+1);
        } else{
            map.put(str, 1);
        }
    }
    private void combi(int idx, int cnt, String[] splitStr, int dest, StringBuffer str){
        if(dest <= cnt){
            addMap(str.toString());
            return;
        }

        for(int i=idx; i<splitStr.length; i++){
            str.append(splitStr[i]);
            combi(i+1, cnt+1, splitStr, dest, str);
            str.deleteCharAt(str.length()-1);
        }

    }

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> list = new ArrayList<>();

        for(int i=0; i<course.length; i++){
            initMap();
            for(int j=0; j<orders.length; j++){
                String[] splitStr = orders[j].split("");
                Arrays.sort(splitStr);
                StringBuffer sb = new StringBuffer("");
                combi(0, 0, splitStr, course[i], sb);
            }

            //map sort
            List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
            Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
                @Override
                public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
                
            });

            int maxx = -1;
            for (Entry<String, Integer> entrySet : entries) {
                int num = entrySet.getValue();
                if(num >= maxx){
                    maxx = num;
                    if(num >= 2){
                        list.add(entrySet.getKey());
                    }
                } else{
                    break;
                }
            }
        }

        list.sort(null);
        answer = new String[list.size()];
        // for(String str : list){
        //     System.out.println(str);
        // }
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] order = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        Solution11_mapSort s11 = new Solution11_mapSort();
        s11.solution(order, course);
    }
}
