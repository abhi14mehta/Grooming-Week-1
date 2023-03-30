// 2.3 Types of constructor and one sample program for each

class Employee{
    private String name;
    private String hobby;

    //no args constructor
    public Employee(){
        System.out.println("This is default constructor!");
    }

    // parameterized constructor
    public Employee(String name, String hobby){
        this.name=name;
        this.hobby=hobby;
        System.out.println("This is parameterized constructor!");
    }

    //copy constructor
    public Employee(Employee employee){
        this.name = employee.name;
        this.hobby = employee.hobby;
        System.out.println("This is copy constructor!");
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

        Employee emp2 = new Employee(emp);
        emp2.display();
    }
}