package airport.model;

import java.util.Arrays;
import java.util.Optional;

public class Airport {

    public Airport(String name, Airplane[] airplanes) {
        this.name = name;
        this.airplanes = new Airplane[airplanes.length];
        for (int i = 0; i < airplanes.length; i++) {
            this.airplanes[i] = airplanes[i];
        }
    }

    public void printAirplanesInAirport() {
        System.out.printf("Aircraft from airport %s:\n", this.name);
        Arrays.stream(airplanes).map(airplane -> airplane.getId())
                .forEach(id -> System.out.println("Airplane " + id));
    }

    public String getAnAvailableAirplane() {
        Optional<Airplane> optionalAirplane = Arrays.stream(airplanes).filter(airplane -> !airplane.isFlying())
                .filter(airplane ->
                        airplane.getCurrentNumberOfPassengers() < airplane.getMaximumNumberOfPassengers())
                .findFirst();
        if (optionalAirplane.isEmpty())
            return "There is no an available airplane.";
        return "Plane " + optionalAirplane.get().getId() + " requested. Is not flying, still room for " +
                (optionalAirplane.get().getMaximumNumberOfPassengers()
                        - optionalAirplane.get().getCurrentNumberOfPassengers())
                + " passengers.";
    }

    public String loadingAnAirplane(String id, int numberOfPassengers) {
        Optional<Airplane> optionalAirplane = Arrays.stream(airplanes).filter(airplane -> airplane.getId().equals(id))
                .findFirst();
        if (optionalAirplane.isEmpty())
            return "There is no airplane with id: " + id;

        return optionalAirplane.get().loadPassengersWithNumberOfPassengers(numberOfPassengers);
    }

    private String name;
    private Airplane[] airplanes;
}
