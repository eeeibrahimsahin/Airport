package airport.builderpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirportNew {
    private String name;
    private List<Plane> planes;

    public static class Builder {
        private String name = "No name";
        private List<Plane> planes = new ArrayList<>();

        public Builder name(String value) {
            name = value;
            return this;
        }

        public Builder planes(List<Plane> planes) {
            this.planes.addAll(planes);
            return this;
        }

        public AirportNew build() {
            return new AirportNew(this);
        }
    }

    private AirportNew(Builder builder) {
        name = builder.name;
        planes = builder.planes;
    }

    public void printAirplanesInAirport() {
        System.out.printf("Passenger planes from airport %s:\n", this.name);
        planes.stream().filter(plane -> plane instanceof PassengerPlane)
                .forEach(System.out::println);

        System.out.printf("Cargo aircraft from airport %s:\n", this.name);
        planes.stream().filter(plane -> plane instanceof CargoPlaneNew)
                .forEach(System.out::println);
    }

    public String getAnAvailablePeoplePlane() {
        Optional<Plane> optionalAirplane = planes.stream().filter(plane -> !plane.isFlying())
                .filter(plane -> plane instanceof PassengerPlane)
                .filter(plane ->
                        ((PassengerPlane) plane).getMaximumNumberOfPassengers() > ((PassengerPlane) plane).getCurrentNumberOfPassengers())
                .findFirst();
        if (optionalAirplane.isEmpty())
            return "There is no an available airplane.";
        return "Passenger Plane " + optionalAirplane.get().getId() + " requested. Is not flying, still room for " +
                (((PassengerPlane) optionalAirplane.get()).getMaximumNumberOfPassengers()
                        - ((PassengerPlane) optionalAirplane.get()).getCurrentNumberOfPassengers())
                + " passengers.";
    }

    public String getAnAvailableCargoPlane() {
        Optional<Plane> optionalAirplane = planes.stream().filter(plane -> !plane.isFlying())
                .filter(plane -> plane instanceof CargoPlaneNew)
                .filter(plane -> ((CargoPlaneNew) plane).getMaximumLoad() > ((CargoPlaneNew) plane).getCurrentLoad())
                .findFirst();
        if (optionalAirplane.isEmpty())
            return "There is no an available Cargo plane.";
        return "Cargo plane " + optionalAirplane.get().getId() + " requested. Is not flying, still room for " +
                (((CargoPlaneNew) optionalAirplane.get()).getMaximumLoad()
                        - ((CargoPlaneNew) optionalAirplane.get()).getCurrentLoad())
                + " tons of freight..";
    }
}
