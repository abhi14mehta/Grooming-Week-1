
class Rectangle {
    private int width;
    private int height;
    
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int area() {
        System.out.println("inside rec");
        return width * height;
    }
}

class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }
    
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
    
    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}



public class LiskovSubstitution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 2);
        System.out.println(rectangle.area()); 
        
        Square square = new Square(5);
        System.out.println(square.area());
        
        Rectangle squareAsRectangle = new Square(5);
        System.out.println(squareAsRectangle.area());
    }
}
