package genericassignment;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    List<T> boxList = new ArrayList<>();

    public void add(T t) {
        boxList.add(t);
    }

    public static void main(String[] args) {
        Box<Beer> beerBox = new Box<>();
        beerBox.add(new Beer());
        System.out.println("beerBox = " + beerBox);
        Box<Wine> wineBox = new Box<>();
        wineBox.add(new Wine());
        System.out.println("wineBox = " + wineBox);
        Box<Beverage> beverageBox = new Box<>();
        beverageBox.add(new Beer());
        beverageBox.add(new Wine());
        System.out.println("beverageBox = " + beverageBox);
    }
}

interface Beverage {
}

class Beer implements Beverage {

}

class Wine implements Beverage {

}
