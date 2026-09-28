public class Car {

    private final String model;
    private final String color;
    private final boolean hasSunroof;
    private final int numberOfDoors;

    private Car(CarBuilder carBuilder){
        this.model = carBuilder.model;
        this.color = carBuilder.color;
        this.hasSunroof = carBuilder.hasSunroof;
        this.numberOfDoors = carBuilder.numberOfDoors;
    }

    static class CarBuilder {
        private String model;
        private String color;
        private boolean hasSunroof = false;
        private int numberOfDoors;

        CarBuilder model(String model){
            this.model = model;
            return this;
        }

        CarBuilder color(String color){
            this.color = color;
            return this;
        }

        CarBuilder hasSunroof(boolean hasSunroof){
            this.hasSunroof = hasSunroof;
            return this;
        }

        CarBuilder numberOfDoors(int numberOfDoors){
            this.numberOfDoors = numberOfDoors;
            return this;
        }

        Car build(){
            return new Car(this);
        }

    }

}
