// 1.3 Write a Java program to sort a given array list

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Employee{
    int id;
    String name;

    Employee(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
}

public class SortArrayList {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();
        // list.add("India");
        // list.add("Australia");
        // list.add("New Zealand");
        // list.add("England");
        // list.add("Pakistan");
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(105,"Ankit"));
        list.add(new Employee(101,"Abhishek"));
        list.add(new Employee(109,"Ravi"));
        list.add(new Employee(104,"Prakash"));
        Iterator<Employee> it = list.iterator();
        while(it.hasNext()){
            Employee emp = it.next();
            System.out.println( emp.getId() + " " + emp.getName() );
        }
        //Collections.sort(list);
        // Sorting according to employee ID
        Collections.sort(list, (a,b) -> a.getId() - b.getId() );
        System.out.println("After sorting employee ids of ArrayList");
        //System.out.println(list);
        it = list.iterator();
        while(it.hasNext()){
            Employee emp = it.next();
            System.out.println( emp.getId() + " " + emp.getName() );
        }

        // Sorting according to employee name
        Collections.sort(list, (a,b) -> a.getName().compareTo(b.getName()) );
        System.out.println("After sorting employee names of ArrayList");
        //System.out.println(list);
        it = list.iterator();
        while(it.hasNext()){
            Employee emp = it.next();
            System.out.println( emp.getId() + " " + emp.getName() );
        }
    }    
}

