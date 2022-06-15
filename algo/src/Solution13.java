import java.util.*;
import java.lang.Math;
class Solution13 {
    class Car{
        String name;
        List<Integer> timeList;
        int fee;
        public Car(String name){
            this.name = name;
            timeList = new ArrayList<>();
            fee = 0;
        }
    }
    
    public int getCarListIdx(String oriName, List<Car> list){
        for(int i=0; i<list.size(); i++){
            Car c = list.get(i);
            if(c.name.equals(oriName)){
                return i;
            }
        }
        return -1;
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        List<Car> list = new ArrayList<>();
        
        for(int i=0; i<records.length; i++){
            String[] temp = records[i].split(" ");
            
            int idx = getCarListIdx(temp[1], list);
            if(idx == -1){
                list.add(new Car(temp[1]));
                idx = list.size()-1;
            }
            
            String[] time = temp[0].split(":");
            int a = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
            list.get(idx).timeList.add(a);
        }
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            if(list.get(i).timeList.size()%2 == 1){
                list.get(i).timeList.add((23*60) + 59);
            }
            int len = list.get(i).timeList.size();
            int sumTime = 0;
            for(int j=1; j<len; j=j+2){
                sumTime += (list.get(i).timeList.get(j) - list.get(i).timeList.get(j-1));
                // System.out.print(list.get(i).timeList.get(j) + " - " +list.get(i).timeList.get(j-1));
            }
            
            
            int price = 0;
            if(sumTime > fees[0]){
                double cal = (double)(sumTime - fees[0])/fees[2];
                cal = Math.ceil(cal);
                //Math.
                // System.out.println(fees[1] + " + " + (int)Math.ceil(cal) + " * " +fees[3]);
                //price = fees[1] + (int)cal * fees[3];
            }else{
                price = fees[1];
            }
            list.get(i).fee = price;
        }
        
        Collections.sort(list, new Comparator<Car>(){
           @Override
            public int compare(Car c1, Car c2){
                return c1.name.compareTo(c2.name);
            }
        });
        int i=0;
        for(Car c : list){
           // System.out.println(c.fee);
            answer[i] = c.fee;
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        
        int[] nums = {1,2,3,4};
        int[] test = Arrays.stream(nums).distinct().toArray();
    }
}