package airport.model;

public class PeoplePlane extends Airplane {
    public PeoplePlane(String id, int maximumNumberOfPassengers, int currentNumberOfPassengers, boolean isFlying, double cruiseSpeed) {
        super(id, maximumNumberOfPassengers, currentNumberOfPassengers, isFlying, cruiseSpeed);
    }

    public void sayHelloFromPeoplePlane() {
        System.out.println("Hello from people plane " + this.getId());
    }

    @Override
    protected String loadPlane(int amount) {
        setupPlane(this,amount);
        if (amount > this.getMaximumNumberOfLoad()) {
            return "Airplane " + this.getId() + " charges " + amount + " passengers, "
                    + (amount - this.getMaximumNumberOfLoad()) + " do not fit.";
        }
        return "Airplane " + this.getId() + " charges " + this.getCurrentNumberOfLoad() + " passengers.";
    }

    @Override
    protected String unloadPlane() {
        String returnText = "Airplane " + this.getId() + " discharges " + this.getCurrentNumberOfLoad() + " passengers.";
        setupPlane(this,0);
        return returnText;
    }

    @Override
    public String toString() {
        return "PeoplePlane{" +
                "id='" + this.getId() + '\'' +
                ", isFlying=" + this.isFlying() +
                ", cruiseSpeed=" + this.getCruiseSpeed() +
                ", maximumNumberOfLoad=" + this.getMaximumNumberOfLoad() +
                ", currentNumberOfLoad=" + this.getCurrentNumberOfLoad() +
                '}';
    }
}
