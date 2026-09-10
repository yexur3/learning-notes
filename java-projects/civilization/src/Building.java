public abstract class Building {
    protected String name;
    protected double cost;

    public Building(String name, double cost){
        this.cost = cost;
        this.name = name;
    }

    public abstract void applyEffect(City city);

    public String getName(){
        return this.name;
    }

    public double getCost(){
        return this.cost;
    }


}
