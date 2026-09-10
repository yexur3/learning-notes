public class GoldMine extends Building{
    public GoldMine(){
        super("Goldmine", 300);
    }

    @Override
    public void applyEffect(City city) {
        city.addGold(20.0);
    }
}
