package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution67 {

    public static boolean bSearch(int[] arr, int a){
        int idx = -1;
        int start = 0;
        int end = arr.length;

        while(start<=end){
            int mid = (start+end)/2;
            if(mid > arr.length-1){
                break;
            }
            if(a<arr[mid]){
                end = mid-1;
            }else if(a>arr[mid]){
                start = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int k = 0; k<N; k++) {
//            Map<Integer, Boolean> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());

            int arr[] = new int[num1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < num1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
//                map.put(Integer.parseInt(st.nextToken()), true);
            }
            Arrays.sort(arr);

            StringBuffer sb = new StringBuffer();

            st = new StringTokenizer(br.readLine());
            int num2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < num2; i++) {
//                arr2[i] = Integer.parseInt(st.nextToken());

//                if (!map.containsKey(Integer.parseInt(st.nextToken()))) {
                    if (!bSearch(arr,Integer.parseInt(st.nextToken()))) {
                        sb.append("0\n");
                    } else {
                        sb.append("1\n");
                    }
            }


            String temp = sb.toString();
            System.out.println(temp.substring(0,temp.length()-1));
        }
    }
}
