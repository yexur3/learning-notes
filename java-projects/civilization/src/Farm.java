public class Farm extends Building {

    public Farm(){
        super("Farm", 120);
    }

    @Override
    public void applyEffect(City city) {
        city.addFood(5.5);
    }


}
