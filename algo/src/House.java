import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

public class House {
    String[][] variables;
    Map<String, String> map = new HashMap<>();

    public String findKey(String ori, int idx){
        for(int i=0; i<variables.length; i++){
            if(variables[i][0].equals(ori)){
                if(variables[i][1].charAt(0) == '{'){
                    if(i==idx){
                        return null;
                    }
                    int len = variables[i][1].length();
                    return findKey(variables[i][1].substring(1,len-1),idx);
                } else{
                    return variables[i][1];
                }
            }
        }

        // return null;
        return variables[idx][1];
    }
    public void addMap(String str, String temp){
        if(map.containsKey(str)){

        }else{
            map.put(str, temp);
        }
    }
    public String solution(String tstring, String[][] variables){
        this.variables = variables;
        String answer = "";
        boolean isError = false;
        for(int i=0; i<variables.length; i++){
            if(variables[i][1].charAt(0) == '{'){
                int len = variables[i][1].length();
                String temp = findKey(variables[i][1].substring(1,len-1), i);
                if(temp != null){
                    addMap(variables[i][0], temp);
                } else{
                    isError = true;
                }
            } else{
                addMap(variables[i][0], variables[i][1]);
            }
        }

        System.out.println("====================");
        for(Map.Entry<String, String> e : map.entrySet()){
            System.out.println(e.getKey() + "  " + e.getValue());
        }

        String[] strList = tstring.split(" ");
        System.out.println("====================");
        for(int i=0; i<strList.length; i++){
            if(strList[i].charAt(0) == '{'){
                String str = strList[i].substring(1,strList[i].length()-1);
                if(map.containsKey(str)){
                    strList[i] = map.get(str);
                }
            }
        }
        for(String s : strList){
            System.out.println(s);
        }
        return answer;
    }

    public static void main(String[] args) {
        String t3 = "{a} {b} {c} {d} {i}";
        String[][] v3= {{"b", "{c}"}, {"a", "{b}"}, {"e", "{f}"}, {"h", "i"}, {"d", "{e}"}, {"f", "{d}"}, {"c", "d"}};

        
        String t2 = "this is {c} c is {bb}";
        String[][] v2= {{"b", "{c}"}, {"c", "{bb}"}};

        String t = "this is {template} {template} is {state}";
        String[][] v = {{"template", "{state}"}, {"state", "{template}"}};
        new House().solution(t, v);
        new House().solution(t3, v3);
        new House().solution(t2, v2);
    }
    



}
