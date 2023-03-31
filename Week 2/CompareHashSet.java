// 1.6 Write a Java program to compare two hash set

import java.util.HashSet;

public class CompareHashSet {
    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<>();
        set1.add("Rohit");
        set1.add("Virat");
        set1.add("Dhoni");
        set1.add("Bumrah");
        set1.add("Bhuvi");
        set1.add("Rohit");
        System.out.println("Set 1: "+set1);

        HashSet<String> set2 = new HashSet<>();
        set2.add("Rohit");
        set2.add("Surya");
        set2.add("Kishan");
        set2.add("Bumrah");
        set2.add("Jofra");
        System.out.println("Set 2: "+set2);

        HashSet<String> set3 = new HashSet<>();
        set3.add("Rohit");
        set3.add("Virat");
        set3.add("Dhoni");
        set3.add("Bumrah");
        set3.add("Bhuvi");
        System.out.println("Set 3: "+set3);

        // Order of adding is diff but set is same 
        HashSet<String> set4 = new HashSet<>();
        set4.add("Rohit");
        set4.add("Dhoni");
        set4.add("Virat");
        set4.add("Bhuvi");
        set4.add("Bumrah");
        System.out.println("Set 4: "+set4);

        System.out.println("Are set1 and set2 equal: " + set1.equals(set2));

        System.out.println("Are set1 and set3 equal: " + set1.equals(set3));

        System.out.println("Are set1 and set4 equal: " + set1.equals(set4));        

    }
}