package grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListToArray {

    public void sol(){
        int arr[] = {1,2,3};
        String strArr[] = {"a","b"};

        List<Integer> list = new ArrayList<>();
        //boxed : int -> Integer
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        List<String> strList = new ArrayList<>();
        strList = Arrays.stream(strArr).collect(Collectors.toList());


        list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        arr = list.stream().mapToInt(m->m).toArray();

        String strArr2[] = {};
        strArr2 = strList.stream().toArray(String[]::new);

        int arr2[] ={};
        arr2 = list.stream().mapToInt(a->a).toArray();


        strArr2 = strList.stream().toArray(String[]::new);
        strList = Arrays.stream(strArr2).collect(Collectors.toList());

    }
}
