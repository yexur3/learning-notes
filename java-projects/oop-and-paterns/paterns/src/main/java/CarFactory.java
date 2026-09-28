public class CarFactory {
    public static Car createCat(String type){
        return switch(type) {
            case "sedan" -> new Car.CarBuilder()
                    .model(type)
                    .color("white")
                    .hasSunroof(false)
                    .numberOfDoors(4)
                    .build();
            case "sport" -> new Car.CarBuilder()
                    .model(type)
                    .color("black")
                    .hasSunroof(true)
                    .numberOfDoors(2)
                    .build();
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}
