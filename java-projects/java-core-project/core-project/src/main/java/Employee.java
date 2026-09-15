import java.nio.DoubleBuffer;
import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != getClass()) return false;
        Employee other = (Employee) o;
        return name.equals(other.name) && department.equals(other.department) && Double.compare(salary, other.salary) == 0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, department, salary);
    }

    @Override
    public String toString(){
        return "[ Name: " + name + " from department: " + department + ", salary: " + salary + "]";
    }


    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }

    public static Employee create(String name, String department, double salary){
        if(salary < 0) throw new InvalidSalaryException("Salary need to be not 0");

        return new Employee(name, department, salary);
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
