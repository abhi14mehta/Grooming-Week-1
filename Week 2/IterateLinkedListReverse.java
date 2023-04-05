// 1.4 Write a Java program to iterate a linked list in reverse order.

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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

public class IterateLinkedListReverse{
    public static void main(String[] args) {
        // List<Integer>  list = new LinkedList<>();
        // list.add(16);
        // list.add(68);
        // list.add(73);
        // list.add(38);
        // list.add(42);

        List<Employee> list = new LinkedList<>();
        list.add(new Employee(105,"Ankit"));
        list.add(new Employee(101,"Abhishek"));
        list.add(new Employee(109,"Ravi"));
        list.add(new Employee(104,"Prakash"));


        // can also use usual iterator for retreving in normal order
        ListIterator<Employee> it = list.listIterator();
        System.out.println("Output in original order");
        while(it.hasNext()){
            System.out.println(it.next().getName());
        }

        ListIterator<Employee> lit = list.listIterator(list.size());
        System.out.println("List in reverse order");
        while(lit.hasPrevious()){
            System.out.println(lit.previous().getName());
        }
    }
}