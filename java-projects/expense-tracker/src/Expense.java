import java.time.LocalDate;
import java.util.Date;

public class Expense {
    private double amount;
    private String category;
    private LocalDate date;


    public Expense(double amount, String category){
        this.amount = amount;
        this.category = category;
        date = LocalDate.now();
    }

    public void describe(){
        System.out.println("[" + category + "] - " + amount + " grn (" + date + ")");
    }

    public String getCategory(){
        return this.category;
    }

    public double getAmount(){
        return this.amount;
    }

    public LocalDate getDate(){
        return this.date;
    }
}
