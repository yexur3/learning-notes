public abstract class Employee {
    protected String name;
    protected int id;
    protected double baseSalary = 25000;

    public Employee(String name, int id){
        this.name = name;
        if(id > 0){
            this.id = id;
        }
    }

    public abstract double calculateSalary();

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        if(id > 0){
            this.id = id;
        }
    }

    public void setBaseSalary(double baseSalary) throws Vynimka {
        if (baseSalary <= 0){
            throw new Vynimka(baseSalary);
        } else {
            this.baseSalary = baseSalary;
        }
    }
}
