// 1.1 Write a program to accept two numbers as command line arguments and print the addition of those numbers.

public class AdditionOfTwoNum {
    public static void main(String args[])   
    {  
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int total = num1 + num2;  
        System.out.println("Result is: " + total);  
    }  
}
