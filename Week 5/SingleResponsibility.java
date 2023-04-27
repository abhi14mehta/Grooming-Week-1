import java.util.ArrayList;
import java.util.List;

class Employee{
    private String name;
    private int id;
    Employee(String name, int id){
        this.name=name;
        this.id=id;
    }

    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }
}

class PrintEmployees{
    public void printEmps(){
        for(Employee emp : SingleResponsibility.empList){
            System.out.println(emp.getName() + " " + emp.getId());
        }
    }
}

class AddEmployee{
    public void addEmp(Employee emp){
        SingleResponsibility.empList.add(emp);
    }
}

public class SingleResponsibility {
    static List<Employee> empList = new ArrayList<>();
    public static void main(String[] args) {
        Employee abhishek = new Employee("Abhishek", 0);
        Employee raj = new Employee("Raj", 1);
        Employee ankit = new Employee("Ankit", 2);

        PrintEmployees pe = new PrintEmployees();
        

        AddEmployee ad = new AddEmployee();
        ad.addEmp(abhishek);
        ad.addEmp(ankit);
        ad.addEmp(raj);
        ad.addEmp(new Employee("Rahul",3));

        pe.printEmps();
    }
}
