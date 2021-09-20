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
        if (numberOfPassengers > this.maximumNumberOfPassengers) {
            this.currentNumberOfPassengers = this.maximumNumberOfPassengers;
            return "Airplane " + this.id + " charges " + this.maximumNumberOfPassengers + " passengers, "
                    + (numberOfPassengers - this.maximumNumberOfPassengers) + " do not fit.";
        }
        this.currentNumberOfPassengers = numberOfPassengers;
        return "Airplane " + this.id + " charges " + this.currentNumberOfPassengers + " passengers.";

    }

    public String unloadPassengers() {
        String returnText = "Airplane " + this.id + " discharges " + this.currentNumberOfPassengers + " passengers.";
        this.currentNumberOfPassengers = 0;
        return returnText;
    }

    public String takeOff() {
        if (isFlying) {
            return "Airplane " + this.id + " can not take off, because we are already flying.";
        } else if (!isFlying) {
            return "Airplane " + this.id + " can not land, because we are still on the ground.";
        }
        this.isFlying = true;
        return "Airplane " + this.id + " rises.";
    }

    public String land() {
        if (isFlying) {
            return "Airplane " + this.id + " can not take off, because we are already flying.";
        }
        this.isFlying = false;
        return "Airplane " + this.id + " lands.";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaximumNumberOfPassengers() {
        return maximumNumberOfPassengers;
    }

    public void setMaximumNumberOfPassengers(int maximumNumberOfPassengers) {
        this.maximumNumberOfPassengers = maximumNumberOfPassengers;
    }

    public int getCurrentNumberOfPassengers() {
        return currentNumberOfPassengers;
    }

    public void setCurrentNumberOfPassengers(int currentNumberOfPassengers) {
        this.currentNumberOfPassengers = currentNumberOfPassengers;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public double getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(double cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    private String id;
    private int maximumNumberOfPassengers;
    private int currentNumberOfPassengers;
    private boolean isFlying;
    private double cruiseSpeed;
}
