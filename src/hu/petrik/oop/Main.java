package hu.petrik.oop;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Bejegyzes> bejegyzesek = new ArrayList<>();

    public static void main(String[] args) {

        Bejegyzes bejegyzes = new Bejegyzes("Kiss István", "Valami tartalom");
        Bejegyzes bejegyzes2 = new Bejegyzes("Gipsz Jakab", "Ez is tartalom");

        bejegyzesek.add(bejegyzes);
        bejegyzesek.add(bejegyzes2);

    }
}
