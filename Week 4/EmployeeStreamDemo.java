import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// 3. Given a list of Employee objects, sort the list based on employee salary? 
// Assume Employee class having id, name, salary fields.
// 4. Given a list of Employee objects, group the list based on employee salary?
// 6. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?



class Employee{
	int id;
	String name;
	int salary;
	Employee(int id, String name,int salary){
		this.id = id;
		this.name=name;
		this.salary=salary;
	}

	int getId(){
        return this.id;
    }
    String getName(){
        return this.name;
    }
    int getSalary(){
        return this.salary;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.salary;
    }
}

public class EmployeeStreamDemo {
    public static void main(String[] args) {
        List<Employee> emplist = new ArrayList<>();
		emplist.add(new Employee(1, "Niraj",  1023));
		emplist.add(new Employee(2, "Dheeraj", 1045));
		emplist.add(new Employee(3, "Nirav", 1078));
		emplist.add(new Employee(4, "Aman", 1065));
		emplist.add(new Employee(5, "Ram", 1034));
		emplist.add(new Employee(6, "Rahul", 1023));
		emplist.add(new Employee(7, "Sam", 1091));
		emplist.add(new Employee(8, "Sandy", 1045));
		emplist.add(new Employee(9, "Mahesh", 1078));
		emplist.add(new Employee(10, "Nitin", 1034));

        // 3
        emplist.sort(Comparator.comparingInt(Employee::getSalary));
        System.out.println(emplist);

        // 4
        Map<Integer, List<Employee>> groupEmps = emplist.stream().collect(Collectors.groupingBy(Employee::getSalary));

        groupEmps.forEach((salary, list) -> {
            System.out.println("Salary: " + salary);
            list.forEach(emp -> System.out.println("\tID: " + emp.getId() + " Name: " + emp.getName()));
        });

        // 6
        Optional<List<Employee>> optionalEmployees = Optional.ofNullable(emplist);
        optionalEmployees.ifPresent(list -> {
            list.forEach(emp -> System.out.println("ID: " + emp.getId() + " Name: " + emp.getName() + ", Salary: " + emp.getSalary()));
        });

    }
}
