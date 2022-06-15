import java.util.ArrayList;
import java.util.List;

public class HDD2 {
    Land arr[];
    int visit[];
    int[] xx;
    int[] yy;
    int len;
    int ans = -1;
    List<Integer> list = new ArrayList<>();
    List<Integer> listB = new ArrayList<>();

    static class Land{
        int x,y;
        Land(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int findNum(List<Integer> tList){
        int minValue = 99999999;
        for(int i=0; i<tList.size(); i++){
            for(int j=i+1; j<tList.size(); j++){
                int tempX = Math.abs(arr[tList.get(i)].x - arr[tList.get(j)].x);
                int tempY = Math.abs(arr[tList.get(i)].y - arr[tList.get(j)].y);
                double temp = Math.pow((double)tempX, 2) + Math.pow((double)tempY, 2);
                if(minValue > (int)temp){
                    minValue = (int)temp;
                }
            }
        }

        return minValue;
    }

    public void checkB(int b, int idx, int valueA){
        if(listB.size() == b){
            
            // System.out.println("============BBB==============");
            // for (int i = 0; i < listB.size(); i++) {
            //     System.out.println(arr[listB.get(i)].x + " : " + arr[listB.get(i)].y);
            // }
            // System.out.println("============================");
            int temp = findNum(listB);
            int tempB =9999999;
            if(tempB > temp){
                tempB = temp;
            }

            // System.out.println(valueA + "  " + tempB);
            int finalNum = 0;
            if(valueA > tempB){
                finalNum = tempB;
            }else{
                finalNum = valueA;
            }

            if(ans < finalNum){
                ans = finalNum;
            }
            
        }

        for(int i=idx; i<len; i++){
            if(visit[i]==1){
                continue;
            }
            listB.add(i);
            visit[i]=1;
            checkB(b, i+1, valueA);
            listB.remove(listB.size()-1);
            visit[i]=0;
        }
    }

    public void check(int a, int b, int idx) {
        if (list.size() == a) {
            // System.out.println("============AA==============");
            // for (int i = 0; i < list.size(); i++) {
            //     System.out.println(arr[list.get(i)].x + " : " + arr[list.get(i)].y);
            // }
            // System.out.println("============================");

            // a부지의 최솟값 찾기
            int tempA = findNum(list);
            // b부지 탐색
            checkB(b, 0, tempA);

           
        }

        for(int i=idx; i<len; i++){
            list.add(i);
            visit[i] = 1;
            check(a,b,i+1);
            visit[i]=0;
            list.remove(list.size()-1);
        }

    }

    public int solution(int[] x, int[] y, int a, int b){
        int answer = 0;
        len = x.length;
        arr = new Land[len];
        visit = new int[len];
        xx = x;
        yy = y;

        for(int i=0; i<x.length; i++){
            arr[i] = new Land(x[i],y[i]);
        }

        check(a, b,0);
        answer = ans;
        return answer;
    }

    public static void main(String[] args) {
        int[] x = {0,1,2,3,4};
        int[] y = {0,0,0,0,0};
        int a =3;
        int b =2;
        new HDD2().solution(x, y, a, b);
        
    }
}
