public class Main {
    public static void main(String[] args){
        City myCity = new City();

        myCity.addBuilding(new Farm());
        myCity.addBuilding(new Barracks());
        myCity.addBuilding(new GoldMine());
        myCity.addBuilding(new Market());

        for(int i = 1; i <= 3; i++){
            System.out.println("--- Хід " + i + " ---");
            myCity.proccesTurn();
            myCity.showStatus();
        }
    }
}
