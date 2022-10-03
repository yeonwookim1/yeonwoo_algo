package hakerrank;

import java.util.*;
import java.util.stream.Collectors;

public class Solution111 {

    static int visit[];
    static int dx[] = {-1,1};

    static class Point{
        int x,cnt;
        public Point(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static int solution(List<String> ingredients, int startIndex, String target) {
        int ans = 0;

        visit = new int[ingredients.size()];
//        bfs(ingredients,startIndex,target);

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startIndex, 1));
        visit[startIndex] = 1;    //visit check , final ans-1

        while(!q.isEmpty()){
            int x = q.peek().x;
            int cnt = q.peek().cnt;
            q.poll();

            if(ingredients.get(x).equals(target)){
                ans = cnt - 1;
                break;
            }

            for(int i=0; i<2; i++){
                int xx = x + dx[i];

                if(xx<0){
                    xx = ingredients.size()-1;
                }else if(xx >=ingredients.size()){
                    xx = 0;
                }

                if(visit[xx] == 0 || visit[xx] > cnt){
                    visit[xx] = cnt+1;
                    q.add(new Point(xx,cnt+1));
                }
            }
        }

        for(int a : visit){
            System.out.print(a+ " ");
        }
        System.out.println();
        System.out.println("ans = " + ans);
        return ans;
    }


    public static void main(String[] args) {
        Solution111 sol = new Solution111();

        List<String> list = new ArrayList<>();

        String[] str = {"linguine", "pepper", "ketchup", "mushroom"};
        list = Arrays.stream(str).collect(Collectors.toList());

        int idx = 1;
        String target = "mushroom";
//        sol.solution(list, idx, target);

        String[] str2 = {"linguine", "pepper", "ketchup", "ketchup"};

        list = Arrays.stream(str2).collect(Collectors.toList());
        idx = 0;
        target = "ketchup";
        sol.solution(list, idx, target);
    }

}
