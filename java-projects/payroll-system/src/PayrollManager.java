import java.util.ArrayList;

public class PayrollManager {
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public void addEmployee(Employee e) throws VynimkaIndex{
        boolean isDuplicate = false;
        for(Employee em : employees){
            if(e.getId() == em.getId()){
                isDuplicate = true;
                break;
            }
        }
        if(isDuplicate != true){
            employees.add(e);
        } else{
            throw new VynimkaIndex();
        }
    }

    public void printReport(){
        System.out.println("=== ЗВІТ ПО ЗАРПЛАТАХ ===");
        double totalCompanyExpenses = 0;
        for(Employee e : employees){
            System.out.println("[" + e.id + "] " + e.name + " - " + e.getClass().getSimpleName() + " : " + e.calculateSalary() + " uah");
            totalCompanyExpenses += e.calculateSalary();
        }
        System.out.println("РАЗОМ ДО ВИПЛАТИ: " + totalCompanyExpenses + " uah");
    }
}
