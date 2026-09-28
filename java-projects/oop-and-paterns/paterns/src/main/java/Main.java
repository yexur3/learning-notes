public class Main {
    public static void main(String[] args){
        Car car = new Car.CarBuilder()
                .model("Bugatti Chiron")
                .color("black")
                .hasSunroof(true)
                .numberOfDoors(2)
                .build();


    }
}
