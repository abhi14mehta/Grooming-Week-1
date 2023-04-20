import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsDemoUsingTraderTransaction {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");


        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println(transactions.stream().filter(x -> (x.getYear() == 2011)).sorted(Comparator.comparingInt(Transaction::getValue)).collect(Collectors.toList())); 

        // 2. What are all the unique cities where the traders work
        Set<String> set = transactions.stream().map(x -> x.getTrader().getCity()).collect(Collectors.toSet());
        System.out.println(set);
        
        // 3. Find all traders from Cambridge and sort them by name.
        List<String> tradersname = transactions.stream().filter(x -> (x.getTrader().getCity()=="Cambridge")).map(x -> x.getTrader().getName()).distinct().sorted().collect(Collectors.toList());
        System.out.println(tradersname);

        // 4. Return a string of all traders’ names sorted alphabetically.
        List<String> allTraders = transactions.stream().map(x -> x.getTrader().getName()).distinct().sorted().collect(Collectors.toList());
        System.out.println(allTraders);

        // 5. Are any traders based in Milan?
        List<String> milenTrader = transactions.stream().filter(x -> (x.getTrader().getCity()=="Milan")).map(x -> x.getTrader().getName()).distinct().sorted().collect(Collectors.toList());
        System.out.println(milenTrader);

        // 6. Print all transactions’ values from the traders living in Cambridge.
        List<Integer> valueTradersCambridge = transactions.stream().filter(x -> (x.getTrader().getCity()=="Cambridge")).map(x -> x.getValue()).sorted().collect(Collectors.toList());
        System.out.println(valueTradersCambridge);

        // 7. What’s the highest value of all the transactions?
        System.out.println(transactions.stream().map(x -> x.getValue()).max(Comparator.naturalOrder()).get());

        // 8. Find the transaction with the smallest value
        System.out.println(transactions.stream().map(x -> x.getValue()).min(Comparator.naturalOrder()).get());

    }
}


class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader(){
        return this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public int getValue(){
        return this.value;
    }
    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}

class Trader{
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}