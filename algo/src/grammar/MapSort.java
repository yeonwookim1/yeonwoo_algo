package grammar;

import java.util.*;

public class MapSort {

    public void test(){
        Map<String,Integer> map = new HashMap<>();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> a1, Map.Entry<String,Integer> a2){
                if(a1.getValue() == a2.getValue()){
                    return a1.getKey().compareTo(a2.getKey());
                }
                return a2.getValue() - a1.getValue();
            }
        });
    }
}
