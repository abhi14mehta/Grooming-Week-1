// 1.2 Write a java program to implement visibility controls such as public, private, protected access modes. Assume suitable data, if any.

public class AccessSpecifiers {
    public int a = 10;
    private int b = 20;
    protected int c = 30;
    
    public void display() {
        System.out.println("public = " + a);
        System.out.println("private = " + b);
        System.out.println("protected = " + c);
    }
    
    public static void main(String[] args) {
        AccessSpecifiers as = new AccessSpecifiers();
        
        as.display();
        System.out.println("public variable = " + as.a);
        //System.out.println("private variable = " + as.b);
        System.out.println("protected variable = " + as.c);
    }
}
