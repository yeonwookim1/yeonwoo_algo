package hakerrank;

import java.util.*;
import java.util.stream.Collectors;

public class Solution113 {

    static Map<Integer, User> userMap;
    static class User{
        private int idx;
        List<Integer> friendsList;

        public User(int idx) {
            this.idx = idx;
            this.friendsList = new ArrayList<>();
        }

        public void setFriend(int idx){
            friendsList.add(idx);
        }
    }

    public static int dfs(int visit[], int targetIdx){
        List<Integer> list = userMap.get(targetIdx).friendsList;
        int cnt = 0;
        for(int i=0; i<list.size(); i++){
            if(visit[list.get(i)] == 0){
                visit[list.get(i)] = 1;
                cnt++;
                cnt += dfs(visit, list.get(i));
            }
        }
        return cnt;
    }

//    public static int getTotal(int visit[], int targetIdx, Map<Integer, User> userMap){
//        int ans = 0;
//        ans++;
//        ans += dfs(visit, targetIdx);
//        return ans;
//    }

    public static List<Integer> solution(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
        // Write your code here
        userMap = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();

        for(int i=1; i<=n; i++){
            userMap.put(i,new User(i));
        }

        for(int i=0; i<queryType.size(); i++){
            //"Friend", "Total"
            if(queryType.get(i).equals("Friend")){
                userMap.get(students1.get(i)).setFriend(students2.get(i));
                userMap.get(students2.get(i)).setFriend(students1.get(i));
            }else{
                int cnt = 0;
                int visit[] = new int[n+1];

                if(students1.get(i).equals(students2.get(i))){
                    cnt = 1;
                    visit[students1.get(i)] = 1;
                    cnt += dfs(visit,students1.get(i));
                }else{
                    cnt = 2;
                    visit[students1.get(i)] = 1;
                    visit[students2.get(i)] = 1;
                    cnt += dfs(visit,students1.get(i));
                    cnt += dfs(visit,students2.get(i));
                }
                answerList.add(cnt);
            }
        }


//        for(int i=1; i<=n; i++){
//            List<Integer> list = userMap.get(i).friendsList;
//
//            System.out.println("list.size() = " + list.size());
//            for(int j=0; j<list.size(); j++){
//                System.out.print(list.get(j) + " ");
//            }
//            System.out.println();
//        }

        for(int a : answerList){
            System.out.println("a = " + a);
        }
        return answerList;

    }

    public static void main(String[] args) {
        int n = 4;
//        String[] query = {"Friend","Friend", "Total"};
//        int[] s1 = {1,2,1};
//        int[] s2 = {2,3,4};
        // 4

        String[] query = {"Total"};
        int[] s1 = {1};
        int[] s2 = {1};
        //2



        List<String> strList = Arrays.stream(query).collect(Collectors.toList());
        List<Integer> sList1 = Arrays.stream(s1).boxed().collect(Collectors.toList());
        List<Integer> sList2 = Arrays.stream(s2).boxed().collect(Collectors.toList());


        Solution113 sol = new Solution113();
        sol.solution(n,strList,sList1,sList2);
    }

}
