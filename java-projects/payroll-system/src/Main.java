public class Main {
    public static void main(String[] args){
        PayrollManager pm = new PayrollManager();
        Employee e = new Manager("Masha", 2, 2000);
        Employee e1 = new Developer("Illia", 1, 10000);
        Employee e2 = new Intern("Lox" , 1);

        try {
            pm.addEmployee(e);
            pm.addEmployee(e1);
            pm.addEmployee(e2);
        } catch (VynimkaIndex v){
            System.out.println("Person with this id exist");
        }
        pm.printReport();
    }
}
