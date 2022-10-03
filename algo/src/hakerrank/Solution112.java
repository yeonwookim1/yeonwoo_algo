package hakerrank;

public class Solution112 {

    public static String solution(String s) {
        // Write your code here

        StringBuilder sb = new StringBuilder();

        int[] countArr = {0,0};

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                countArr[0]++;
            }else{
                countArr[1]++;
            }
        }


        int minValue = 0;
        if(countArr[0]> countArr[1]){
            minValue = countArr[1];
            for(int i=0; i<countArr[0]-countArr[1]; i++){
                sb.append('0');
            }
        }else if(countArr[0]< countArr[1]){
            minValue = countArr[0];for(int i=0; i<countArr[1]-countArr[0]; i++){
                sb.append(1);
            }
        }else{
            minValue = countArr[0];
        }

        for(int i=0; i<minValue; i++){
            sb.append("01");
        }


//        int totalSum = countArr[0] + countArr[1];
//        while(totalSum >0){
//            if(countArr[0]==countArr[1]){
//                sb.append("01");
//                countArr[0]--;
//                countArr[1]--;
//            }else if(countArr[0] >countArr[1]){
//                sb.append('0');
//                countArr[0]--;
//            }else {
//                sb.append('1');
//                countArr[1]--;
//            }
//
//            totalSum = countArr[0] + countArr[1];
//        }

        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution112 solution112 = new Solution112();
        String s= "1100";
        solution112.solution(s);
    }
}
