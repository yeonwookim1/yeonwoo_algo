package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution66 {
    class Server{
        int y;
        List<Integer> list;
        public Server(){
            this.y = 0;
            this.list = new ArrayList<>();
        }
    }
    int servers;

    public int serverNameChange(int a) {
        if (a >= servers) {
            a = 0;
        }
        return ++a;
    }

    public int[][] solution(int servers, boolean sticky, int[] requests) {
        this.servers = servers;
        List<Integer> list = new ArrayList<>();
        int serverName = 1; // 1,2,...n

        Map<Integer,Server> map = new HashMap<>();
        for(int i=1; i<=servers; i++){
            map.put(i,new Server());
        }

        for (int i = 0; i < requests.length; i++) {
            System.out.println("serverName = " + serverName);
            if(sticky){
                int nextServerName = serverNameChange(serverName);
                if(Math.abs(map.get(serverName).y - map.get(nextServerName).y) >= 1){
                    Server sv = map.get(nextServerName);
                    sv.y++;
                    sv.list.add(requests[i]);
                    map.put(nextServerName,sv);
                    serverName = serverNameChange(serverName);
                }else{
                    Server sv = map.get(serverName);
                    sv.y++;
                    sv.list.add(requests[i]);
                    map.put(serverName,sv);
                }

            }else{
                Server sv = map.get(serverName);
                sv.y++;
                sv.list.add(requests[i]);
                map.put(serverName,sv);
                serverName = serverNameChange(serverName);
            }

        }

        for(Map.Entry<Integer,Server> a : map.entrySet()){
            a.getValue().list.size();
//            System.out.println("\nserverName = " + a.getKey());
//            System.out.print("server List ");
//            for(int b : a.getValue().list){
//                System.out.print( b + " ");
//            }
        }

        int[][] answer = new int[2][map.get(2).list.size()];
        for(int i=0; i<2; i++){
            for(int j=0; j<map.get(i+1).list.size(); j++){
                answer[i][j] = map.get(i+1).list.get(j);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution66 sol = new Solution66();
        int arr[] = {1,2,2,3};
        sol.solution(2,false,arr);
    }

}
