import java.util.Scanner;

class StringEmptyException extends Exception{
    StringEmptyException(String message){
        super(message);
    }
}

public class MockJava {
    public static void main(String[] args) throws StringEmptyException {
        try (Scanner sc = new Scanner(System.in)){
          System.out.print("Enter your string: ");
          String str = sc.nextLine();

          if(str == null || str.equals("")){
            throw new StringEmptyException("You have entered empty string !!");
          }

          int[] arr = new int[256];
          for(int i=0;i<str.length();i++){
            arr[str.charAt(i)]++;
          }

          int maxOccuringIndex = 0;
          int value = Integer.MIN_VALUE;
          for(int i=0;i<arr.length;i++){
            if(arr[i] > value){
                value = arr[i];
                maxOccuringIndex = i;
            }
          }

          System.out.println("Max Occuring element is "+ (char)maxOccuringIndex + " and have occured " + value + " times");
        }        
    }    
}

