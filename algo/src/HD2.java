import java.util.ArrayList;
import java.util.List;

public class HD2 {

    static String[] map;
    static int visit[];
    static List<Integer> list = new ArrayList<>();
    static int ans = 9999999;

    public void dfs(int idx){
        if(list.size()>0){
            for(int a : list){
                System.out.print(a + " ");
            }
            System.out.println();
            if(checkVisit()){
                if(ans > list.size()){
                    ans = list.size();
                }
            }
        }

        for(int i = idx; i<map.length; i++){
            list.add(i);
            addVisit(i);
            dfs(i+1);
            list.remove(list.size()-1);
            removeVisit(i);
        }

    }

    public boolean checkVisit(){
        for(int i=0; i<map.length; i++){
            if(visit[i]==0){
                return false;
            }
        }
        return true;
    }

    public void addVisit(int i){
        String temp[] = map[i].split("");
        for(int j=0; j<temp.length; j++){
            if(temp[j].equals("O")){
                visit[j]++;
            }
        }
    }

    public void removeVisit(int i){
        String temp[] = map[i].split("");
        for(int j=0; j<temp.length; j++){
            if(temp[j].equals("O")){
                visit[j]--;
            }
        }
    }

    public int sol(String[] table){
        map = table;
        visit = new int[table[0].length()];

        for(int i=0; i<map.length; i++){
            addVisit(i);
            list.add(i);
            dfs(i+1);
            list.remove(list.size()-1);
            removeVisit(i);
        }

        System.out.println("answer = " + ans);
        return -1;
    }

    public static void main(String[] args) {
        String a[] = {"XOXO", "OXXO", "XXOX", "XOOO"}; //2
        String b[] = {"OXXO", "XOXO", "XXOO"};  //3
        String c[] = {"OXOXO", "OOOOO", "XOXOX"}; //1
        new HD2().sol(c);
    }
    
}
