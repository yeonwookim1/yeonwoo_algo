package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/10825
//국영수
public class Solution105 {

    static class Student{
        String name;
        int korean;
        int math;
        int eng;
        public Student(String name, int korean, int math, int eng) {
            this.name = name;
            this.korean = korean;
            this.math = math;
            this.eng = eng;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Student> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Student(name,korean, math, eng));
        }

        Collections.sort(list, new Comparator<Student>(){

            @Override
            public int compare(Student s1, Student s2){
                if(s1.korean != s2.korean){
                    return s2.korean - s1.korean;
                }else{
                    if(s1.eng != s2.eng){
                        return s1.eng - s2.eng;
                    }else{
                        if(s1.math != s2.math){
                            return s2.math - s1.math;
                        }else{
                            return s1.name.compareTo(s2.name);
                        }
                    }
                }
            }
        });
        for(Student s : list){
            System.out.println(s.name);
        }

    }
}

