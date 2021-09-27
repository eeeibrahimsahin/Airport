package airport.model;

public class CargoPlaneNew extends Plane {
    private int maximumLoad;
    private int currentLoad;

    public static class Builder extends Plane.Builder<Builder> {
        private int maximumLoad;
        private int currentLoad;

        public Builder maximumLoad(int value) {
            maximumLoad = value;
            return this;
        }

        public Builder currentLoad(int value) {
            currentLoad = value;
            return this;
        }

        @Override
        public CargoPlaneNew build() {
            return new CargoPlaneNew(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public CargoPlaneNew(Builder builder) {
        super(builder);
        maximumLoad = builder.maximumLoad;
        currentLoad = builder.currentLoad;
    }

    @Override
    public String load(int value) {
        if ((currentLoad += value) > maximumLoad) {
            return "Cargo Plane " + getId() + " loads " + currentLoad + " tons of cargo,"
                    + (currentLoad - maximumLoad) + " tons do not fit.";
        }
        return "Cargo Plane " + getId() + " loads " + (currentLoad += value) + " tons of cargo.";
    }

    @Override
    public String unLoad() {
        String returnText = "Cargo Plane " + this.getId() + " unloads " + currentLoad + " tons of cargo.";
        currentLoad = 0;
        return returnText;
    }

    @Override
    public String toString() {
        return "CargoPlaneNew{" +
                super.toString() +
                ", maximumLoad=" + maximumLoad +
                ", currentLoad=" + currentLoad +
                '}';
    }
}
