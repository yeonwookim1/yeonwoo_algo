package grammar;

import java.util.*;

public class MapSort {

    public void test(){
        Map<String,Integer> map = new HashMap<>();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        List<String> listKey = new ArrayList<>(map.keySet());
        List<Integer> listValue = new ArrayList<>(map.values());

        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> a1, Map.Entry<String,Integer> a2){
                if(a1.getValue() == a2.getValue()){
                    return a1.getKey().compareTo(a2.getKey());
                }
                return a2.getValue() - a1.getValue();
            }
        });

        map.containsKey("te");

        List<Map.Entry<String,Integer>> list2 = new ArrayList<>(map.entrySet());
        Collections.sort(list2, new Comparator<Map.Entry<String,Integer>>(){

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for(Map.Entry<String,Integer> m : list2){
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a1, Integer a2){
                return a1-a2;
            }
        });
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.get(0);
        list.set(0,5);
        list.set(3,10);
        list.remove(2);
        Collections.sort(list, Comparator.reverseOrder());
        for(int a : list){
            System.out.println(a);
        }
    }
}
