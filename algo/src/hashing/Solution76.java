package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/status?user_id=kop4845&problem_id=1302&from_mine=1
//베스트셀러
public class Solution76 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(map.containsKey(str)){
                int a = map.get(str) +1;
                map.put(str,a);
            }else{
                map.put(str,1);
            }
        }

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

        System.out.println(list.get(0).getKey());

    }
}
