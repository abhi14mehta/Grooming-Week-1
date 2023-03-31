// 1.3 Write a Java program to sort a given array list

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("India");
        list.add("Australia");
        list.add("New Zealand");
        list.add("England");
        list.add("Pakistan");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Collections.sort(list);
        System.out.println("After sorting ArrayList");
        System.out.println(list);
        it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }    
}
