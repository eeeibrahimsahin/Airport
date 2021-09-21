package airport.model;

public class PeoplePlane extends Airplane {
    public PeoplePlane(String id, int maximumNumberOfPassengers, int currentNumberOfPassengers, boolean isFlying, double cruiseSpeed) {
        super(id, maximumNumberOfPassengers, currentNumberOfPassengers, isFlying, cruiseSpeed);
    }

    @Override
    protected String loadPlane(int amount) {
        setupPlane(this);
        if (amount > this.getMaximumNumberOfLoad()) {
            this.setCurrentNumberOfLoad(this.getMaximumNumberOfLoad());
            return "Airplane " + this.getId() + " charges " + amount + " passengers, "
                    + (amount - this.getMaximumNumberOfLoad()) + " do not fit.";
        }
        this.setCurrentNumberOfLoad(amount);
        return "Airplane " + this.getId() + " charges " + this.getCurrentNumberOfLoad() + " passengers.";
    }

    @Override
    protected String unloadPlane() {
        String returnText = "Airplane " + this.getId() + " discharges " + this.getCurrentNumberOfLoad() + " passengers.";
        this.setCurrentNumberOfLoad(0);
        return returnText;
    }


}