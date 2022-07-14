import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/42860#
//조이스틱
public class Solution20 {
    private String name;
    private int mmax;
    public int moveCount(Character n){
        if(n-65>12){
            int temp = n-65;
            return 26-temp;
        }
        else{
            return n-65;
        }
    }
    public void checkMax(int price){
        if(mmax > price){
            mmax = price;
        }
    }
    public void search(int cnt, int next_idx, int price, char[] changeName){
        int ori = next_idx;
//        for(char a : changeName){
//            System.out.print(a);
//        }
//        System.out.println();
        if(cnt > name.length()){
            return;
        }


        char temp = name.charAt(next_idx);
        if(temp != changeName[next_idx]) {
            price += moveCount(temp);
        }
        changeName[next_idx] = temp;
        String tt = "";
        char[] tempName = new char[changeName.length];
        for(int i=0; i<changeName.length; i++){
            tempName[i] = changeName[i];
            tt += changeName[i];
        }


        if(tt.equals("BBBBAAAABA")){
            System.out.println(price);
            System.out.println("tt = " + tt);
        }
        boolean isSame = true;
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i)!=(changeName[i])){
                isSame = false;
                break;
            }
        }
        if(isSame){
            checkMax(price);
            return;
        }

        //left
        if(next_idx == 0){
            next_idx = name.length()-1;
        } else{
            next_idx--;
        }
//        System.out.println("price = " + price);
        search(cnt+1, next_idx,price+1,changeName);

        //초기화
        for(int i=0; i<changeName.length; i++){
            changeName[i] = tempName[i];
        }
        next_idx = ori;

        //right
        if(next_idx == name.length()-1){
            next_idx = 0;
        } else{
            next_idx++;
        }
        search(cnt+1, next_idx,price+1,changeName);
    }
    public int solution(String name) {
        this.name = name;
        this.mmax = 99999;
        char[] changeName = new char[name.length()];
        for(int i=0; i<name.length(); i++){
            changeName[i] = 'A';
        }
        int answer = 0;
        search(0,0,0, changeName);
        answer = mmax;
        return answer;
    }
    
    public static void main(String[] args) {
        String t = "BBBBAAAABA";

        char a = 65;

        System.out.println(a);

        Solution20 test = new Solution20();
        test.solution(t);

    }
}
