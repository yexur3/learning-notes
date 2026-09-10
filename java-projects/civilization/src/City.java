import java.util.ArrayList;

public class City {
    private String name = "Lox";
    private ArrayList<Building> buildings = new ArrayList<Building>();
    private double gold = 1000;
    private double food;
    private double production;
    private double militaryPower;

    public void addBuilding(Building b){
        if(this.gold >= b.getCost()){
            this.gold -= b.getCost();
            this.buildings.add(b);
            System.out.println(b.getName() + " builded!");
        } else {
            System.out.println("You dont have enough gold to bild this: " + b.getName());
        }
    }

    public void addGold(double amount){
        this.gold += amount;
    }

    public void addFood(double amount) {
        this.food += amount;
    }

    public void addProduction(double amount){
        this.production += amount;
    }

    public void addMilitaryPower(double amount){
        this.militaryPower += amount;
    }

    public void proccesTurn(){
        for(Building b : buildings){
            b.applyEffect(this);
        }
    }

    public void showStatus(){
        System.out.println("Місто: " + name + " | Золото: " + gold + " | Їжа: " + food + " | Military Power: " + militaryPower);
    }
}
