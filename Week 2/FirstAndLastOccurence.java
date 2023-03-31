// 1.5 Write a Java program to get the first and last occurrence of the specified elements in a linked list

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FirstAndLastOccurence {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("India");
        list.add("Australia");
        list.add("Pakistan");
        list.add("New Zealand");
        list.add("India");
        list.add("Australia");
        list.add("Pakistan");
        list.add("New Zealand");
        list.add("England");
        list.add("India");
        list.add("New Zealand");
        list.add("Pakistan");
        list.add("Australia");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element for their occurence:");
        String element = sc.next();

        System.out.println("First occurence of element " + element + " is " + list.indexOf(element));
        System.out.println("Last occurence of element " + element + " is " + list.lastIndexOf(element));

        sc.close();
    }
}
