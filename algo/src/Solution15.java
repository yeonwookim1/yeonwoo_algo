import java.util.*;
import java.util.stream.Collectors;

public class Solution15 {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        int len = numbers.length;
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(i==j){
                    continue;
                }
                list.add(numbers[i]+numbers[j]);
            }
        }
        // list = list.stream().distinct().;

        int[] answer = {};
        list = list.stream().distinct().collect(Collectors.toList());
        answer = list.stream().distinct().mapToInt(s->s).toArray();
        

        
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] num = {2,1,3,4,1};
        List<Integer> list = new ArrayList<>();


        list = Arrays.stream(num).boxed().collect(Collectors.toList());
        
        //array -> array
        // report = Arrays.stream(report).distinct().toArray(String[]::new);

        //list<Integer> -> int[]
        int[] temp = list.stream().mapToInt(a->a).toArray();
        Arrays.sort(temp);
        //int[] -> list<Integer>
        List<Integer> tempList = Arrays.stream(num).boxed().collect(Collectors.toList());
        Collections.sort(tempList, new Comparator<Integer>(){
            @Override
            public int compare(Integer l1, Integer l2){
                if(l1 < l2)
                    return 1;
                return l2;   
            }
        });


        

        new Solution15().solution(num);
    }
}