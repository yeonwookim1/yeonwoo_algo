package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution44 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());

        //map이나 set이라 속도 비슷
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            String temp = String.valueOf(br.readLine());
            set.add(temp);
        }
        for(int j=0; j<M; j++){
            String temp = String.valueOf(br.readLine());
            if(set.contains(temp)){
                list.add(temp);
            }
        }
//        for(Map.Entry<String, Integer> en : map.entrySet()){
//            if(en.getValue()>1){
//                list.add(en.getKey());
//            }
//        }
        Collections.sort(list);
        System.out.println(list.size());
        for(String s : list){
            System.out.println(s);
        }
    }
}
