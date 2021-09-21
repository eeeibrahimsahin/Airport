package airport.model;

import java.util.Arrays;
import java.util.Optional;

public class Airport {
    private String name;
    private Airplane[] airplanes;

    public Airport(String name, Airplane[] airplanes) {
        this.name = name;
        this.airplanes = new Airplane[airplanes.length];
        for (int i = 0; i < airplanes.length; i++) {
            this.airplanes[i] = airplanes[i];
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airplane[] getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(Airplane[] airplanes) {
        this.airplanes = airplanes;
    }

    public void printAirplanesInAirport() {
        System.out.printf("Passenger planes from airport %s:\n", this.name);
        Arrays.stream(airplanes).filter(airplane -> airplane instanceof PeoplePlane)
                .forEach(System.out::println);

        System.out.printf("Cargo aircraft from airport %s:\n", this.name);
        Arrays.stream(airplanes).filter(airplane -> airplane instanceof CargoPlane)
                .forEach(System.out::println);
    }

    public String getAnAvailablePeoplePlane() {
        Optional<Airplane> optionalAirplane = Arrays.stream(airplanes).filter(airplane -> !airplane.isFlying())
                .filter(airplane -> airplane instanceof PeoplePlane)
                .filter(airplane -> airplane.getMaximumNumberOfLoad() > airplane.getCurrentNumberOfLoad())
                .findFirst();
        if (optionalAirplane.isEmpty())
            return "There is no an available airplane.";
        return "Passenger Plane " + optionalAirplane.get().getId() + " requested. Is not flying, still room for " +
                (optionalAirplane.get().getMaximumNumberOfLoad()
                        - optionalAirplane.get().getCurrentNumberOfLoad())
                + " passengers.";
    }

    public String getAnAvailableCargoPlane() {
        Optional<Airplane> optionalAirplane = Arrays.stream(airplanes).filter(airplane -> !airplane.isFlying())
                .filter(airplane -> airplane instanceof CargoPlane)
                .filter(airplane -> airplane.getMaximumNumberOfLoad() > airplane.getCurrentNumberOfLoad())
                .findFirst();
        if (optionalAirplane.isEmpty())
            return "There is no an available Cargo plane.";
        return "Cargo plane " + optionalAirplane.get().getId() + " requested. Is not flying, still room for " +
                (optionalAirplane.get().getMaximumNumberOfLoad()
                        - optionalAirplane.get().getCurrentNumberOfLoad())
                + " tons of freight..";
    }

    public String loadingAnAirplane(String id, int amount) {
        Optional<Airplane> optionalAirplane = Arrays.stream(airplanes).filter(airplane -> airplane.getId().equals(id))
                .findFirst();
        if (optionalAirplane.isEmpty())
            return "There is no airplane with id: " + id;

        return optionalAirplane.get().loadPlane(amount);
    }

}
