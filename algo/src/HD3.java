import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HD3 {

    public int sol(int[] score, int k) {
        int answer = 0;

        int len = score.length;
        int minus[][] = new int[len - 1][2];


        //얘를 프로그래머스에서 햇나?
        if(k==1){
            return score[len-1] - score[0];
        }

        //스코어는 오름차순이므로, 차이를 구함
        for (int i = 0; i < len - 1; i++) {
            minus[i][0] = score[i + 1] - score[i];
            minus[i][1] = i;
        }

        //차이로만 정렬
        Arrays.sort(minus, Comparator.comparingInt(o1-> o1[0]));

        //잘라야 될 인덱스들을 담아두는 배열
        int idxArr[] = new int[k-1];

        for(int i=0; i<k-1; i++){
            idxArr[i] = minus[len -2 -i][1];
        }

        //앞에서부터 계산하기 위해 인덱스를 정렬
        Arrays.sort(idxArr);

        for(int a : idxArr){
            System.out.println(a);
        }

        int cnt = 0;
        for(int i=0; i<=idxArr.length; i++){
            if(i==idxArr.length){
                answer += score[len-1] - score[cnt];
                break;
            }else{
                answer += score[idxArr[i]] - score[cnt];
            cnt = idxArr[i] + 1;
            }
        }
        // for (int i = 0; i < minus.length; i++) {
        //     for (int j = 0; j < minus[i].length; j++) {
        //         System.out.print(minus[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        int a[] = { 1, 3, 7, 8, 10, 15 }; // k=3 answ = 5
        int b[] = {1,2,12,14,15}; //k=2, answer = 4
        new HD3().sol(b, 2);
    }

}
