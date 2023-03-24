// 2.1 Static keyword various implementations with examples.

public class StaticKeyword {
    static int var1 = 5;
    int var2 = 10;

    static void staticMethod() { 
        System.out.println("Inside static method !!");
    }

    void instanceMethod() {
        System.out.println("Inside instance method !!");
    }

    static{
        System.out.println("Inside Static block !!");
    }

    public static void main(String[] args) {
        System.out.println(StaticKeyword.var1);
        StaticKeyword.staticMethod();

        StaticKeyword obj = new StaticKeyword();
        System.out.println(obj.var2);
        obj.instanceMethod();
    }
}
