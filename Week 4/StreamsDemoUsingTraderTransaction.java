import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class GetYearPredicate implements Predicate<Transaction> {

    @Override
    public boolean test(Transaction transaction) {
        return transaction.getYear() == 2011;
    }
}

class GetTraderCity implements Function<Transaction, String> {
    
    @Override
    public String apply(Transaction transaction) {
        return transaction.getTrader().getCity();
    }
}
  
class GetTraderName implements Function<Transaction, String> {
    
    @Override
    public String apply(Transaction transaction) {
        return transaction.getTrader().getName();
    }
}

class GetTransactionValue implements Function<Transaction, Integer> {
    
    @Override
    public Integer apply(Transaction transaction) {
        return transaction.getValue();
    }
}
class GetValueComparator implements Comparator<Transaction> {
    
    @Override
    public int compare(Transaction t1, Transaction t2) {
        return t1.getValue() - t2.getValue();
    }
}
    
class CityPredicate implements Predicate<Transaction> {
    private String cityName;
    public CityPredicate(String cityName) {
        this.cityName = cityName;
    }
    
    @Override
    public boolean test(Transaction transaction) {
        return transaction.getTrader().getCity().equalsIgnoreCase(cityName);
    }
}

class PrintName implements Consumer<String> {
    public void accept(String name) {
        System.out.println(name);
    }
}
    
    
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
        System.out.println(transactions.stream().filter(new GetYearPredicate()).sorted(new GetValueComparator()).collect(Collectors.toList())); 

        // 2. What are all the unique cities where the traders work
        transactions.stream().map(new GetTraderCity()).collect(Collectors.toSet()).forEach(new PrintName());
        
        // 3. Find all traders from Cambridge and sort them by name.
        List<String> tradersname = transactions.stream().filter(new CityPredicate("Cambridge")).map(new GetTraderName()).distinct().sorted().collect(Collectors.toList());
        System.out.println(tradersname);

        // 4. Return a string of all traders’ names sorted alphabetically.
        List<String> allTraders = transactions.stream().map(x -> x.getTrader().getName()).distinct().sorted().collect(Collectors.toList());
        System.out.println(allTraders);

        // 5. Are any traders based in Milan?
        List<String> milenTrader = transactions.stream().filter(new CityPredicate("Milan")).map(new GetTraderName()).distinct().sorted().collect(Collectors.toList());
        System.out.println(milenTrader);

        // 6. Print all transactions’ values from the traders living in Cambridge.
        List<Integer> valueTradersCambridge = transactions.stream().filter(new CityPredicate("Cambridge")).map(new GetTransactionValue()).sorted().collect(Collectors.toList());
        System.out.println(valueTradersCambridge);

        // 7. What’s the highest value of all the transactions?
        System.out.println(transactions.stream().map(new GetTransactionValue()).max(Comparator.naturalOrder()).get());

        // 8. Find the transaction with the smallest value
        System.out.println(transactions.stream().map(new GetTransactionValue()).min(Comparator.naturalOrder()).get());

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