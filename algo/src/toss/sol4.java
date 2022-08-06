package toss;

import java.util.*;
import java.util.stream.Collectors;

public class sol4 {
    Map<Long, List<Long>> map;

    public int cal(Long k, int score){
        int cnt = 0;
        if(map.get(k)==null){
            return 0;
        }
        for(long i=0; i<map.get(k).size(); i++){
            if(score==0){
                cnt +=10;
            } else if(score==1){
                cnt += 3;
            }else{
                cnt++;
            }
            int temp = cal(map.get(k).get((int)i),score+1);
            cnt += temp;
        }
        return cnt;
    }

    public long[] solution(long[][] invitationPairs) {
        List<Long> mainList = new ArrayList<>();
        map = new HashMap<>();

        for(int i=0; i<invitationPairs.length; i++){
            if(map.containsKey(invitationPairs[i][0])){
                List<Long> list = map.get(invitationPairs[i][0]);
                list.add(invitationPairs[i][1]);
                map.put(invitationPairs[i][0],list);
            }else{
                List<Long> list = new ArrayList<>();
                list.add(invitationPairs[i][1]);
                map.put(invitationPairs[i][0],list);

                map.put(invitationPairs[i][1], new ArrayList<>());
            }
            mainList.add(invitationPairs[i][0]);
        }

        List<Map.Entry<Long, List<Long>>> list = new ArrayList<>(map.entrySet());

//        for(Map.Entry<Long, List<Long>> a : list){
//            System.out.println(a.getKey());
//        }

        Map<Long, Integer> mmap = new HashMap<>();
        for(long i=0; i<list.size(); i++){
            Long key = list.get((int) i).getKey();
            int cnt = cal(key,0);
            mmap.put(key,cnt);
        }

        List<Map.Entry<Long, Integer>> llist = new ArrayList<>(mmap.entrySet());
        Collections.sort(llist, new Comparator<Map.Entry<Long, Integer>>() {
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                if(o1.getValue() == o2.getValue()){
                    return (int) (o2.getKey() - o1.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        int idx= 0;
        long[] answer = new long[3];

        mainList = mainList.stream().distinct().collect(Collectors.toList());
//        System.out.println(llist.size());
//        System.out.println(mainList.size());
//        for(Long a : mainList){
//            System.out.println(a);
//        }
        for(int i=0; i<llist.size(); i++){

            for(int j=0; j<mainList.size(); j++){
                if(llist.get(i).getKey() == mainList.get(j)){
                    answer[idx] = llist.get(i).getKey();
                    idx++;
                }
            }
            if(idx ==3){
                break;
            }
        }
        System.out.println("++");
        for(Long a : answer){
            System.out.println(a);
        }
        return answer;
    }

    public static void main(String[] args) {
        sol4 sol = new sol4();
        long arr[][] = {{1,2},{2,3},{2,4},{2,5},{5,6},{5,7},{6,8},{2,9}};
        sol.solution(arr);
    }
}
