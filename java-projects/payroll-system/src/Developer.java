public class Developer extends Employee{
    private int linesCode;

    public Developer(String name, int id, int linesCode){
        super(name, id);
        this.linesCode = linesCode;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (linesCode * 0.5);
    }

    public int getLinesCode(){
        return linesCode;
    }

    public void setLinesCode(int linesCode){
        this.linesCode = linesCode;
    }
}
