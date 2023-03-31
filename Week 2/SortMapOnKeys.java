// 1.7 Program to sort a map based on keys.

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortMapOnKeys {
    public static void main(String[] args) {
        Map<Integer,String> lookup = new HashMap<>();
        lookup.put(0, "Sehwag");
        lookup.put(18,"Sachin");
        lookup.put(97,"Gambhir");
        lookup.put(35,"Virat");
        lookup.put(91,"Dhoni");
        lookup.put(21,"Yuvraj");

        List<Map.Entry<Integer,String>> list = new LinkedList<>(lookup.entrySet());

        Collections.sort(list,(a,b) -> a.getKey().compareTo(b.getKey()));

        Map<Integer,String> demo = new HashMap<>();
        
        for(Map.Entry<Integer,String> val : list){
            demo.put(val.getKey(),val.getValue());
        }

        System.out.println(demo);
        
        
    }
}
