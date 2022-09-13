package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//https://www.acmicpc.net/problem/10814
//나이순정렬
public class Solution106 {

    static class Member{
        int age;
        int idx;
        String name;

        public Member(int age, int idx, String name) {
            this.age = age;
            this.idx = idx;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Member> list = new ArrayList<>();
        for(int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(age,i,name));
        }

        Collections.sort(list, new Comparator<Member>(){
           @Override
           public int compare(Member m1, Member m2){
               if(m1.age!= m2.age){
                   return m1.age - m2.age;
               }else{
                   return m1.idx - m2.idx;
               }
           }
        });
        for(Member m : list){
            System.out.println(m.age + " " + m.name);
        }
    }
}
