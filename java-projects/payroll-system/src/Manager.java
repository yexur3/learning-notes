public class Manager extends Employee{
    private double bonus;

    public Manager(String name, int id, double bonus){
        super(name, id);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    public double getBonus(){
        return bonus;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }
}
