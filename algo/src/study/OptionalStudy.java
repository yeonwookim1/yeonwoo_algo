package study;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OptionalStudy{

    Map<Long, String> store;

    public OptionalStudy(){
        store = new HashMap<Long, String>();
    }
    public Optional<String> findName(String name){
        return store.values().stream().filter(s -> s.equals(name)).findAny();
    }

    public static void main(String[] args) {
        OptionalStudy test = new OptionalStudy();
        System.out.println(test.findName("name").orElse("XX"));


        Optional<Person> p1 = Optional.of(new Person());
        
        String name = p1.flatMap(p -> p.getCar())
                .flatMap(c -> c.getInsurance())
                .map(i -> i.getName())
                .orElse("unknown");

        System.out.println(name);
    }
}