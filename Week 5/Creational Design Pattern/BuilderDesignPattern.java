class CarBuilder {
    private String model;
    private String color;
    private int engineSize;
    
    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }
    
    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }
    
    public CarBuilder setEngineSize(int engineSize) {
        this.engineSize = engineSize;
        return this;
    }
    
    public Car build() {
        return new Car(model, color, engineSize);
    }
}

class Car {
    private String model;
    private String color;
    private int engineSize;
    
    public Car(String model, String color, int engineSize) {
        this.model = model;
        this.color = color;
        this.engineSize = engineSize;
    }
    
    public String getModel(){
        return this.model;
    }

    public String getColor(){
        return this.color;
    }

    public int getEngineSize(){
        return this.engineSize;
    }
}


public class BuilderDesignPattern {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .setModel("Tata Safari")
                .setColor("Blue")
                .setEngineSize(3000)
                .build();
        System.out.println(car.getModel() + " " + car.getColor() + " " + car.getEngineSize());
    }
}
