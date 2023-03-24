// 1.3 Write a java program to implement multilevel inheritance with 4 levels of hierarchy.

class ClassA {
    public void methodA() {
        System.out.println("Inside Method A");
    }
}

class ClassB extends ClassA {
    public void methodB() {
        System.out.println("Inside Method B");
    }
}

class ClassC extends ClassB {
    public void methodC() {
        System.out.println("Inside Method C");
    }
}

class ClassD extends ClassC {
    public void methodD() {
        System.out.println("Inside Method D");
    }
}

class ClassE extends ClassD {
    public void methodE() {
        System.out.println("Inside Method E");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        ClassE obj = new ClassE();
        obj.methodA();    
        obj.methodB();  
        obj.methodC();   
        obj.methodD();  
        obj.methodE();  
    }
}
