// 1.5 Write a program to convert String to enum.

public class StringToEnum {
    enum Names {ANKIT,RAVI,PRAKASH,AVINASH,ARNAB,ABHISHEK};
    public static void main(String[] args) {
        String string = "ABHISHEK";
        // valueOf matches to enum created if doesnt matches then create error
        Names name = Names.valueOf(string);
        System.out.println("Name: " + name);
    }
}
