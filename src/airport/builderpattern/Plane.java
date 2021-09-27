package airport.builderpattern;

public abstract class Plane {
    private String id;
    private boolean isFlying;
    private double cruiseSpeed;
    private boolean isCleaned;

    abstract static class Builder<T extends Builder<T>> {
        private String id = "No Name";
        private boolean isFlying = false;
        private double cruiseSpeed = 0.0;
        private boolean isCleaned = false;

        public T flightId(String value) {
            id = value;
            return self();
        }

        public T isFlying(boolean value) {
            isFlying = value;
            return self();
        }

        public T cruiseSpeed(int value) {
            cruiseSpeed = value;
            return self();
        }

        public T isCleaned(boolean value) {
            isCleaned = value;
            return self();
        }


        public abstract Plane build();

        protected abstract T self();
    }

    Plane(Builder<?> builder) {
        id = builder.id;
        isFlying = builder.isFlying;
        cruiseSpeed = builder.cruiseSpeed;
        isCleaned = builder.isCleaned;
    }

    public abstract String load(int value);

    public abstract String unLoad();

    public String getId() {
        return id;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public double getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void clean(){}

    @Override
    public String toString() {
        return "Plane{" +
                "id='" + id + '\'' +
                ", isFlying=" + isFlying +
                ", cruiseSpeed=" + cruiseSpeed +
                '}';
    }
}
