package airport.model;

public class CargoPlane extends Airplane {
    public CargoPlane(String id, int maximumNumberOfPassengers, int currentNumberOfPassengers, boolean isFlying, double cruiseSpeed) {
        super(id, maximumNumberOfPassengers, currentNumberOfPassengers, isFlying, cruiseSpeed);
    }

    public void sayHelloFromCargoPlane() {
        System.out.println("Hello from cargo plane " + this.getId());
    }

    @Override
    protected String loadPlane(int amount) {
        setupPlane(this, amount);
        if (amount > this.getMaximumNumberOfLoad()) {
            return "Cargo Plane " + this.getId() + " loads " + amount + " tons of cargo,"
                    + (amount - this.getMaximumNumberOfLoad()) + " tons do not fit.";
        }
        return "Cargo Plane " + this.getId() + " loads " + this.getCurrentNumberOfLoad() + " tons of cargo.";
    }

    @Override
    protected String unloadPlane() {
        String returnText = "Cargo Plane " + this.getId() + " unloads " + this.getCurrentNumberOfLoad() + " tons of cargo.";
        setupPlane(this, 0);
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
