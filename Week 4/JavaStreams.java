import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// 1.Given a list of integers, find out all the even numbers exist in the list using Stream functions
// 2.How to find duplicate elements in a given integers list in java using Stream functions
// 5.Given a list of integers, find the maximum value element present in it using Stream functions


public class JavaStreams{
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println("Even Numbers: " + evenNumbers(list));

        list = Arrays.asList(2,2,10,10,15,8,49,40,25,98,98,32,15,15);
        System.out.println("Duplicate Elements: "+duplicates(list));

        System.out.println("Maximum Value: "+maximumValue(list));
    }

    public static List<Integer> evenNumbers(List<Integer> list){

        Predicate<Integer> evenPredicate = x -> (x%2==0);
        return list.stream().filter(evenPredicate).collect(Collectors.toList());
    }

    public static Set<Integer> duplicates(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        Predicate<Integer> duplicatePredicate = x -> !set.add(x);
        return list.stream().filter(duplicatePredicate).collect(Collectors.toSet());
    }

    public static Integer maximumValue(List<Integer> list){
        return list.stream().max(Comparator.naturalOrder()).get();
    }
}