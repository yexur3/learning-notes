public class Intern extends Employee{

    public Intern(String name, int id){
        super(name, id);
    }

    @Override
    public double calculateSalary() {
        return baseSalary * 0.8;
    }
}
