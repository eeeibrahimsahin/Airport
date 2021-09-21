package airport.model;

public class CargoPlane extends Airplane {
    public CargoPlane(String id, int maximumNumberOfPassengers, int currentNumberOfPassengers, boolean isFlying, double cruiseSpeed) {
        super(id, maximumNumberOfPassengers, currentNumberOfPassengers, isFlying, cruiseSpeed);
    }

    @Override
    protected String loadPlane(int amount) {
        if (amount > this.getMaximumNumberOfLoad()) {
            this.setCurrentNumberOfLoad(this.getMaximumNumberOfLoad());
            return "Cargo Plane " + this.getId() + " loads " + amount+ " tons of cargo,"
                    + (amount - this.getMaximumNumberOfLoad()) + " tons do not fit.";
        }
        this.setCurrentNumberOfLoad(amount);
        return "Cargo Plane " + this.getId() + " loads " + this.getCurrentNumberOfLoad() + " tons of cargo.";
    }

    @Override
    protected String unloadPlane() {
        String returnText = "Cargo Plane " + this.getId() + " unloads " + this.getCurrentNumberOfLoad() + " tons of cargo.";
        this.setCurrentNumberOfLoad(0);
        return returnText;
    }

}
