public class Market extends Building{
    public Market(){
        super("Market", 200);
    }

    @Override
    public void applyEffect(City city) {
        city.addGold(10.0);
    }
}
