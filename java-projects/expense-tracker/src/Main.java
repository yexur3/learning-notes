import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Expense> expenses = new ArrayList<Expense>();
        Scanner ch = new Scanner(System.in);

        while(true){
            System.out.println("1. Add new expense");
            System.out.println("2. Show all expenses");
            System.out.println("3. Delete expense");
            System.out.println("0. Exit");
            System.out.println("Choose one of the function");

            int choose = ch.nextInt();
            ch.nextLine();

            switch (choose){
                case 1:
                    System.out.println("Enter sum of expense: ");
                    Double enter1 = ch.nextDouble();
                    ch.nextLine();

                    System.out.println("Enter a category of expense: ");
                    String enter2 = ch.nextLine();

                    expenses.add(new Expense(enter1, enter2));
                    System.out.println("New expense added!");
                    break;
                case 2:
                    double sum = 0;
                    int i = 1;
                    for(Expense e : expenses){
                        System.out.println(i + ". [" + e.getCategory() + "] - " + e.getAmount() + " grn (" + e.getDate() + ")");
                        sum = sum + e.getAmount();
                        i++;
                    }
                    System.out.println("-----------------");
                    System.out.println("Sum of all expenses: " + sum);
                    break;
                case 3:
                    for(Expense e : expenses){
                        System.out.println("[" + e.getCategory() + "] - " + e.getAmount() + " grn (" + e.getDate() + ")");
                    }
                    System.out.println("-----------------");
                    System.out.println("Enter number of expense you want to delete: ");
                    int enter = ch.nextInt();
                    ch.nextLine();
                    expenses.remove(enter - 1);
                    System.out.println("Expense deleted!");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Wrong choice!");
            }
        }
    }
}
