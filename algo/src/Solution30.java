import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution30 {

    public static void main(String[] args) {

        char a = '3';
        int aa = Character.valueOf(a);
        String aaa = String.valueOf(a);

        int q = 3;
        String qq = Integer.toString(q);
        int qqq = Integer.parseInt(qq);

        List<String> strList = new ArrayList<>();
        String strArr[] = {};
        strArr = strList.stream().toArray(String[]::new);
        strList = Arrays.stream(strArr).collect(Collectors.toList());

        List<Integer> intList = new ArrayList<>();
        int arr[] = new int[3];
        arr = intList.stream().mapToInt(m->m).toArray();
        intList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Collections.sort(intList, new Comparator<>(){
            @Override
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });

        String arrSort[] = {};
        Arrays.sort(arrSort, new Comparator<>(){
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        Map<String,Integer> map = new HashMap<>();
        List<String> testt = new ArrayList<>(map.keySet());
        List<Map.Entry<String,Integer>> mapList = new ArrayList<>(map.entrySet());
        Collections.sort(mapList, new Comparator<Entry<String, Integer>>(){

            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
                if(o1.getKey()=="abc"){
                    return o1.getValue() - o2.getValue();
                }
                return o1.getKey().compareTo(o2.getKey());
            }
           
        });
        for(Map.Entry<String,Integer> en : mapList){
            System.out.println(en.getKey());
            System.out.println(en.getValue());
        }

    }
}
