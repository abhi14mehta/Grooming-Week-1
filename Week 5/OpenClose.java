interface Shape {
    double area();
}

class Rectangle implements Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    public double area() {
        return length * width;
    }
}

class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double area() {
        return Math.PI * radius * radius;
    }
}

class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}



public class OpenClose {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(5,4);
        Circle cir = new Circle(5);

        AreaCalculator area = new AreaCalculator();
        System.out.println("Circle area: "+area.calculateArea(cir));
        System.out.println("Rectangle area: "+area.calculateArea(rec));
    }
}
