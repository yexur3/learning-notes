public class Vynimka extends Exception{
    public Vynimka(double nespravneSalary){
        super("Nespravne zadane salary! ne moze byt salary " + nespravneSalary);
    }
}
