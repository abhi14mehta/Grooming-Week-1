// 1.6 Write a Java program to compare two hash set

import java.util.HashSet;

class Cricketers{
    String name;

    Cricketers(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}

public class CompareHashSet {
    public static void main(String[] args) {
        HashSet<Cricketers> set1 = new HashSet<>();

        Cricketers rohit = new Cricketers("Rohit");
        Cricketers virat = new Cricketers("Virat");
        Cricketers dhoni = new Cricketers("Dhoni");
        Cricketers bumrah = new Cricketers("Bumrah");
        Cricketers bhuvi = new Cricketers("Bhuvi");


        set1.add(rohit);
        set1.add(virat);
        set1.add(dhoni);
        set1.add(bumrah);
        set1.add(bhuvi);
        System.out.println("Set 1: "+set1);

        HashSet<Cricketers> set2 = new HashSet<>();
        set2.add(new Cricketers("Rohit"));
        set2.add(new Cricketers("Surya"));
        set2.add(new Cricketers("Kishan"));
        set2.add(new Cricketers("Dhoni"));
        set2.add(new Cricketers("Virat"));
        System.out.println("Set 2: "+set2);

        HashSet<Cricketers> set3 = new HashSet<>();
        set3.add(rohit);
        set3.add(dhoni);
        set3.add(bhuvi);
        set3.add(virat);
        set3.add(bumrah);
        System.out.println("Set 3: "+set3);

        // Order of adding is diff but set is same 
        HashSet<Cricketers> set4 = new HashSet<>();
        set4.add(new Cricketers("Rohit"));
        set4.add(new Cricketers("Virat"));
        set4.add(new Cricketers("Dhoni"));
        set4.add(new Cricketers("Bumrah"));
        set4.add(new Cricketers("Bhuvi"));
        System.out.println("Set 4: "+set4);

        System.out.println("Are set1 and set2 equal: " + set1.equals(set2));

        System.out.println("Are set1 and set3 equal: " + set1.equals(set3));

        System.out.println("Are set1 and set4 equal: " + set1.equals(set4));        

    }
}