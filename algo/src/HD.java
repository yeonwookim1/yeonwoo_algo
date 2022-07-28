import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HD {

    class Student{
        int num;
        String name;
        int x,y;
        double grade;

        Student(String name, int x, int y, double grade){
            this.name = name;
            this.x = x;
            this.y = y;
            this.grade = grade;
        }
        
    }
    
    public int[] sol(String[] names , int[][] homes, double[] grade){
        // int[] answer = {};
        int n = names.length;
        int[] answer = new int[n];
        List<Student> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Student(names[i], homes[i][0], homes[i][1], grade[i]));
        }

        Collections.sort(list, new Comparator<Student>(){

            @Override
            public int compare(HD.Student o1, HD.Student o2) {
                // TODO Auto-generated method stub
                if(Math.floor(o1.grade) > Math.floor(o2.grade)){
                    return -1;
                } else if(Math.floor(o1.grade) < Math.floor(o2.grade)){
                    return 1;
                } else{ // grade 앞자리 같은 경우
                    double dis1 = Math.pow(o1.x, 2) + Math.pow((o1.y),2);
                    double dis2 = Math.pow(o2.x, 2) + Math.pow((o2.y),2);
                    if(dis1 > dis2){
                        return -1;
                    } else if(dis1 < dis2){
                        return 1;
                    } else{ //거리까지 일치
                        return o1.name.compareTo(o2.name);
                    }
                }
            }
            
        });
        //순위 부여
        for(int i=0; i<n; i++){
            list.get(i).num = i+1;
        }

        Long a = System.currentTimeMillis();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(names[i].equals(list.get(j).name)){
                    answer[i] = list.get(j).num;
                }
            }
            
        }
        System.out.println(System.currentTimeMillis());
        return answer;
    }

    public static void main(String[] args) {
        String[] a = {"azad","andy","louis","will","edward"};
        int[][] homes = {{3,4},{-1,5},{-4,4},{3,4},{-5,0}};
        double[] grade = {4.19, 3.77, 4.41, 3.65, 3.58};
        new HD().sol(a, homes, grade);
    }
}
