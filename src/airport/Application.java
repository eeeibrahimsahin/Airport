package airport;

import airport.model.Airplane;

public class Application {
    public static void main(String[] args) {
        System.out.println("Test");
        Airplane airplane1 = new Airplane("ABC123", 60,
                0, false, 600);
        Airplane airplane2 = new Airplane("DDD888", 60,
                0, false, 600);

        System.out.println(airplane1.loadPassengersWithNumberOfPassengers(43));
        System.out.println(airplane1.takeOff());
        System.out.println(airplane2.loadPassengersWithNumberOfPassengers(23));
        System.out.println(airplane1.land());
        System.out.println(airplane1.unloadPassengers());
        System.out.println(airplane2.takeOff());
        System.out.println(airplane1.land());
        System.out.println(airplane2.unloadPassengers());
    }
}
