import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        Employee e1 = Employee.create("Anna", "IT", 2500.0);
        Employee e2 = Employee.create("Olha", "HR", 1700.0);
        Employee e3 = Employee.create("Illia", "IT", 1950.0);

        List<Employee> employees = new ArrayList<>(List.of(e1, e2, e3));

        System.out.println(findMax(employees));

        employees.sort(Comparator.comparing(Employee::getDepartment).thenComparing(Comparator.comparing(Employee::getSalary).reversed()));

        System.out.println(employees);

        System.out.println(findHighestPaidInDepartment(employees, "HR"));

        System.out.println(groupByDepartment(employees));

    }

    public static <T extends Comparable<T>> T findMax(List<T> list){
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .findFirst().get();
    }

    public static Optional<Employee> findHighestPaidInDepartment(List<Employee> list, String department){
        return list.stream()
                .filter(x -> x.getDepartment().equals(department))
                .max(Employee::compareTo);
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> list){
        Map<String, List<Employee>> map = list.stream().collect(Collectors.groupingBy(x -> x.getDepartment()));
        return map;
    }

}
