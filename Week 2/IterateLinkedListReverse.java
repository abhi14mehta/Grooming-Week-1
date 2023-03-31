// 1.4 Write a Java program to iterate a linked list in reverse order.

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IterateLinkedListReverse{
    public static void main(String[] args) {
        List<Integer>  list = new LinkedList<>();
        list.add(16);
        list.add(68);
        list.add(73);
        list.add(38);
        list.add(42);

        // can also use usual iterator for retreving in normal order
        ListIterator<Integer> it = list.listIterator();
        System.out.println("Output in original order");
        while(it.hasNext()){
            System.out.println(it.next());
        }

        ListIterator<Integer> lit = list.listIterator(list.size());
        System.out.println("List in reverse order");
        while(lit.hasPrevious()){
            System.out.println(lit.previous());
        }
    }
}