package airport.model;

public class Airplane {

    public Airplane(String id, int maximumNumberOfPassengers, int currentNumberOfPassengers, boolean isFlying, double cruiseSpeed) {
        this.id = id;
        this.maximumNumberOfPassengers = maximumNumberOfPassengers;
        this.currentNumberOfPassengers = currentNumberOfPassengers;
        this.isFlying = isFlying;
        this.cruiseSpeed = cruiseSpeed;
    }

    public String loadPassengersWithNumberOfPassengers(int numberOfPassengers) {
        this.currentNumberOfPassengers = numberOfPassengers;
        return "Airplane " + this.id + " loads " + this.currentNumberOfPassengers + " passengers.";
    }

    public String unloadPassengers() {
        String returnText = "Airplane " + this.id + " unloads " + this.currentNumberOfPassengers + " passengers.";
        this.currentNumberOfPassengers = 0;
        return returnText;
    }

    public String takeOff() {
        this.isFlying = true;
        return "Airplane " + this.id + " takes off.";
    }

    public String land() {
        this.isFlying = false;
        return "Airplane " + this.id + " lands.";
    }



    private String id;
    private int maximumNumberOfPassengers;
    private int currentNumberOfPassengers;
    private boolean isFlying;
    private double cruiseSpeed;
}
