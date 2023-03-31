// 1.2 Program to Implement LinkedList

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Criket");
        list.add("Hockey");
        list.add(1,"Football");
        System.out.println(list);
        if(list.contains("Football")){
            int x = list.indexOf("Football");
            list.set(x,"Volleyball");
            System.out.println(list);
            list.remove(x);
        }
        System.out.println(list);

    }
}
