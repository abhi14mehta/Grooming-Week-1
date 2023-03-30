import java.util.Scanner;

// 2.6 find the maximum occurring character in a given String and try to use exception handling for edge cases?

class EmptyStringException extends Exception{
    EmptyStringException(String msg){
        super(msg);
    }
}

public class MaxOccuringCharacter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.nextLine();
            if(str == null || str.equals(""))  {
                throw new EmptyStringException("String is empty enter a valid string");
            }
            str = str.toLowerCase();
            int[] arr = new int[26];

            for(int i=0;i<str.length();i++){
                int val = str.charAt(i) - 'a';
                arr[val] += 1;
            }
            int maxOccurIndex = 0;
            int value = Integer.MIN_VALUE;
            for(int i=0;i<arr.length;i++){
                if(arr[i] > value){
                    value = arr[i];
                    maxOccurIndex = i;
                }
            }
            char maxChar = (char)('a'+ maxOccurIndex);

            System.out.println("Max occuring character is " + maxChar + " and have occuredd " + arr[maxOccurIndex] + " times");
        }catch(EmptyStringException e){
            System.out.println(e.getMessage());
        }
    }    
}

