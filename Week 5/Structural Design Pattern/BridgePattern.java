
interface Color {
    public void applyColor();
}

class Red implements Color {
    public void applyColor() {
        System.out.println("Red color applied! ");
    }
}

class Blue implements Color {
    public void applyColor() {
        System.out.println("Blue color applied! ");
    }
}
//Abstract Class
abstract class Shape {
    protected Color color;
    public Shape(Color color) {
        this.color = color;
    }
    abstract public void draw();
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }
    public void draw() {
        System.out.print("Drawing square! ");
        color.applyColor();
    }
}

class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }
    public void draw() {
        System.out.print("Drawing circle! a");
        color.applyColor();
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        Color red = new Red();
        Color blue = new Blue();

        Shape square = new Square(red);
        square.draw();

        Shape circle = new Circle(blue);
        circle.draw();
    }
}
