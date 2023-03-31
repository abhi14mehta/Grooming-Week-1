// 1.1 Program to add, retrieve & remove element from ArrayList

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        //Adding element in arraylist
        al.add(100);al.add(43);
        al.add(62);al.add(82);
        al.add(100);al.add(21);
        al.add(49);al.add(36);
        System.out.println("ArrayList: " + al);
        //retrieve element 
        int x = al.get(3);
        System.out.println("Element at index 3 is " + x + " and List size is "+al.size() );
        //removing element
        al.remove(3);
        x = al.get(3);
        System.out.println("Now element at index 3 is " + x + " and List size is "+al.size());
    }
}
