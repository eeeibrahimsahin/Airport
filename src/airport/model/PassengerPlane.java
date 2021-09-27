package airport.model;

public class PassengerPlane extends Plane {
    private int maximumNumberOfPassengers;
    private int currentNumberOfPassengers;


    public static class Builder extends Plane.Builder<Builder> {
        private int maximumNumberOfPassengers = 0;
        private int currentNumberOfPassengers = 0;

        public Builder maximumNumberOfPassengers(int value) {
            maximumNumberOfPassengers = value;
            return this;
        }

        public Builder currentNumberOfPassengers(int value) {
            currentNumberOfPassengers = value;
            return this;
        }

        @Override
        public PassengerPlane build() {
            return new PassengerPlane(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private PassengerPlane(Builder builder) {
        super(builder);
        maximumNumberOfPassengers = builder.maximumNumberOfPassengers;
        currentNumberOfPassengers = builder.currentNumberOfPassengers;
    }


    @Override
    public String load(int value) {
        if ((value + currentNumberOfPassengers) > maximumNumberOfPassengers) {
            return "Airplane " + this.getId() + " charges " + (value + currentNumberOfPassengers) + " passengers, "
                    + (value + currentNumberOfPassengers - maximumNumberOfPassengers) + " do not fit.";
        }
        return "Airplane " + getId() + " charges " + (value + currentNumberOfPassengers) + " passengers.";
    }

    @Override
    public String unLoad() {
        String returnText = "Airplane " + this.getId() + " discharges " + currentNumberOfPassengers + " passengers.";
        currentNumberOfPassengers = 0;
        return returnText;
    }

    @Override
    public String toString() {
        return "PassengerPlane{" +
                super.toString() +
                ", maximumNumberOfPassengers=" + maximumNumberOfPassengers +
                ", currentNumberOfPassengers=" + currentNumberOfPassengers +
                '}';
    }
}
