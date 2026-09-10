public class Barracks extends Building{
    public Barracks(){
        super("Barracks", 500);
    }

    @Override
    public void applyEffect(City city) {
        city.addMilitaryPower(50.0);
    }
}
