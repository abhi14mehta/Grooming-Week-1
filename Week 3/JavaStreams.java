import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 1.Given a list of integers, find out all the even numbers exist in the list using Stream functions
// 2.How to find duplicate elements in a given integers list in java using Stream functions
// 5.Given a list of integers, find the maximum value element present in it using Stream functions


public class JavaStreams{
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println("Even Numbers: " + EvenNumbers(list));

        list = Arrays.asList(2,2,10,10,15,8,49,40,25,98,98,32,15,15);
        System.out.println("Duplicate Elements: "+Duplicates(list));

        System.out.println("Maximum Value: "+MaximumValue(list));
    }

    public static List<Integer> EvenNumbers(List<Integer> list){
        return list.stream().filter(x -> (x%2==0)).collect(Collectors.toList());
    }

    public static Set<Integer> Duplicates(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        return list.stream().filter(x -> !set.add(x)).collect(Collectors.toSet());
    }

    public static Integer MaximumValue(List<Integer> list){
        return list.stream().max(Comparator.naturalOrder()).get();
    }
}