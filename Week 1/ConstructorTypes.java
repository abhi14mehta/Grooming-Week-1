// 2.3 Types of constructor and one sample program for each

class Employee{
    String name;
    String hobby;

    public Employee(){
        System.out.println("This is default constructor!");
    }

    public Employee(String name, String hobby){
        this.name=name;
        this.hobby=hobby;
        System.out.println("This is parameterized constructor!");
    }

    public void display(){
        System.out.println("Name is " + name + " and he likes to " + hobby);
    }
}


public class ConstructorTypes{
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.display();

        emp = new Employee("Abhishek","Travel");
        emp.display();
    }
}