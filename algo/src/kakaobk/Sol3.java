package kakaobk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sol3 {
    Map<Integer,Node> map;
    class Node{
        int num;
        double value;

        int parent;
        List<Integer> childList;
        public Node(int num, double value) {
            this.num = num;
            this.value = value;
            childList = new ArrayList<>();
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public void setChildOne(int num){
            childList.add(num);
        }
    }

    public int solution(int[] cash, int[][] links) {
        int answer = 0;
        map = new HashMap<>();
        for(int i=0; i<cash.length; i++){
            map.put(i+1,new Node(i+1,cash[i]));
        }
        int visit[] = new int[cash.length+1]; //최상의 부모 노드 찾기 위함

        for(int i=0; i<links.length; i++){
            visit[links[i][1]] = 1;
            map.get(links[i][0]).setChildOne(links[i][1]);  //부모에 자식 추가
            map.get(links[i][1]).setParent(links[i][0]);    //자식한테 부모 추가
        }

        int topNode = 0;
        for(int i=1; i<visit.length; i++){
            if(visit[i]==0){
                topNode = i;
                break;
            }
        }

        String str[] = getAvgValue(topNode).split("@");


        double d = Double.parseDouble(str[0]);
        int c = Integer.parseInt(str[1]);
        answer = (int) d/c;
        System.out.println("answer = " + answer);

        return answer;
    }

    //부모보다 작은 값의 합
    public String getAvgValue(int num){
        int cnt = 1;
        List<Integer> childList = map.get(num).childList;
        double nowValue = map.get(num).value;
        double total = nowValue;

        for (Integer integer : childList) {
            String[] s = getAvgValue(integer).split("@");
            double d = Double.parseDouble(s[0]);
            int c = Integer.parseInt(s[1]);
//            System.out.println("cnt = " + cnt);
            if (d/c > nowValue) {
                System.out.println("부모 value < 자식 value");
                continue;
            }
            cnt += c;
            total += d;
        }

        String str = total + "@" + cnt;
        System.out.println(str);
        System.out.println();
        return str;
    }

    public static void main(String[] args) {
        Sol3 sol3 = new Sol3();
        int c[] = {300,550,350,500,100,150,100}; //,750,800
        int li[][] = {{3,7},{1,5},{4,1},{3,2},{3,6},{4,3}}; //{4,8},{8,9}

        int c1[] = {200,80,50};
        int ll[][] = {{1,3},{2,1}};
        sol3.solution(c,li);    //221
//        sol3.solution(c1,ll);
    }
}
