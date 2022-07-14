import java.util.ArrayList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/17681
//1차 비밀지도
public class Solution19 {

    public String getBinary(int x, int n){
        List<Integer> list = new ArrayList<>();
        while(n>0){
            list.add(n%2);
            n = n/2;
        }
        while(list.size()<x){
            list.add(0);
        }

        System.out.println(list.size());
        StringBuffer sb = new StringBuffer();
        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i).toString());
        }


        return sb.toString();
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            String a = getBinary(n,arr1[i]);
            String b = getBinary(n,arr2[i]);
//            System.out.println("a = " + a);
//            System.out.println("b = " + b);
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<n; j++){
                if(a.charAt(j) == '0' && b.charAt(j) == '0'){
                    sb.append(" ");
                } else{
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();

        }
        return answer;
    }

    public static void main(String[] args) {
//        int arr1[] = {9,20,28,18,11};
//        int arr2[] = {30,1,21,17,28};
        int arr1[] = {46, 33, 33 ,22, 31, 50};
        int arr2[] = {27 ,56, 19, 14, 14, 10};
        int n = 6;
        new Solution19().solution(n, arr1, arr2);
    }
}
