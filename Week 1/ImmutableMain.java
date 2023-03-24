// 2.2 Write a program create Immutable class.

public class ImmutableMain {
    public static void main(String[] args) {
        ImmutableClass immutableObj = new ImmutableClass("Abhishek", "Mehta");
        System.out.print(immutableObj.getFirstName() + " ");
        System.out.println(immutableObj.getLastName());
    }
}
