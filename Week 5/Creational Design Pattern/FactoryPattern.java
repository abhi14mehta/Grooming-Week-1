interface Shape{
    void area();
}

class Rectangle implements Shape{
    public void area(){
        System.out.println("Area of Rectangle is l*b");
    }
}

class Square implements Shape{
    public void area(){
        System.out.println("Area of Square is s^2");
    }
}

interface Production{
    Shape createShapes();
}

class Production1 implements Production{
    public Shape createShapes(){
        return new Rectangle();
    }
}

class Production2 implements Production{
    public Shape createShapes(){
        return new Square();
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Production prod1 = new Production1();
        Shape rect = prod1.createShapes();
        rect.area();

        Production prod2 = new Production2();
        Shape sqr = prod2.createShapes();
        sqr.area();
    }
}
