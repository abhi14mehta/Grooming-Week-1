// 4.Write a single program to implement inheritance and polymorphism in java.

class Shapes {
    public void area(){
        System.out.println("Area of different shapes are calculated different");
    }
}

class Rectangle extends Shapes{
    public void area(){
        System.out.println("Area is l*b ");
    }
}

class Square extends Shapes{
    public void area(){
        System.out.println("Area is l^2 ");
    }
}

public class InheritanceAndPolymorphism{
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Shapes rect = new Rectangle();
        Shapes sq = new Square();

        shape.area();
        rect.area();
        sq.area();

    }
}