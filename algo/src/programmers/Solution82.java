package programmers;
import java.util.List;
import java.util.ArrayList;

//https://school.programmers.co.kr/learn/courses/30/lessons/17677
//1차 뉴스클러스팅
public class Solution82 {
    
    public List<String> makeSet(String str){
        List<String> list = new ArrayList<>();

        for(int i =0; i<str.length()-1; i++){
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);
            if(c1 < 'A' || c1 > 'Z'){
                continue;
            }
            if(c2 < 'A' || c2 > 'Z'){
                continue;
            }
            StringBuffer sb = new StringBuffer();
            sb.append(c1);
            sb.append(c2);
//                System.out.println("sb = " + sb);
            list.add(sb.toString());
        }
        return list;
    }
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> set1 = makeSet(str1);
        List<String> set2 = makeSet(str2);



        //total size
        double totalSize = set1.size() + set2.size();

        String arr1[] = set1.stream().toArray(String[]::new);
        String arr2[] = set2.stream().toArray(String[]::new);


        //둘다 공집합인 경우 1로 처리
        if(arr1.length ==0 && arr2.length==0){
            answer = 1 * 65536;
            return answer;
        }
        int visit2[] = new int[arr2.length];
        double cnt = 0;
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                if(visit2[j] == 0 && arr1[i].equals(arr2[j])){
                    cnt++;
                    visit2[j] = 1;
                    break;
                }
            }
        }

//            System.out.println("totalSize = " + totalSize);
//            System.out.println("cnt : " + cnt);
        double ans = (double)(cnt/(totalSize - cnt)) * 65536;

        answer = (int)ans;
//            System.out.println("answer = " + answer);
        
        //교집합 수 / (전체 사이즈 합 - 교집합 수)

        // *65536 곱하고 정수부분만 출력
        return answer;
    }

    
    public static void main(String[] args) {
        Solution82 sol = new Solution82();
        String str1 = "FRANCE";
        String str2 = "french";
        sol.solution(str1,str2);

        str1 = "handshake";
        str2 = "shake hands";
        sol.solution(str1,str2);

        str1 = "aa1+aa2";
        str2 = "AAAA12";
        sol.solution(str1,str2);

        str1= "E=M*C^2";
        str2= "e=m*c^2";
        sol.solution(str1,str2);
    }

    /**
     * str1	str2	answer
        FRANCE	french	16384
        handshake	shake hands	65536
        aa1+aa2	AAAA12	43690
        E=M*C^2	e=m*c^2	65536



     */
}
