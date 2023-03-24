// 2.4 Program to load class dynamically

public class DynamicLoading {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class<?> c = Class.forName("DemoClass"); // Dynamically load the class

        Object obj = c.newInstance(); // Create an instance of the loaded class

        DemoClass myObj = (DemoClass) obj; // Cast the object
        myObj.printName();
    }
}

class DemoClass {
    public void printName() {
        System.out.println("Abhishek Mehta");
    }
}
