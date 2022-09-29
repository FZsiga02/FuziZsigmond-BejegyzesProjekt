package hu.petrik.oop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Bejegyzes> bejegyzesek = new ArrayList<>();

    public static void main(String[] args) {

        Bejegyzes bejegyzes = new Bejegyzes("Kiss István", "Valami tartalom");
        Bejegyzes bejegyzes2 = new Bejegyzes("Gipsz Jakab", "Ez is tartalom");

        bejegyzesek.add(bejegyzes);
        bejegyzesek.add(bejegyzes2);

        try{
            konzolosBekeres();
        }catch(InputMismatchException e){
            System.out.println("Nem számot adott meg");
        }

    }

    private static void konzolosBekeres() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Kérem adja meg hány bejegyzés legyen felvéve: ");
        int db = sc.nextInt();
        for (int i = 0; i < db; i++) {
            System.out.print("Szerző: ");
            String szerzo = sc.nextLine();
            System.out.print("Tartalom: ");
            String tartalom = sc.nextLine();
            Bejegyzes bejegyzes = new Bejegyzes(szerzo, tartalom);
            bejegyzesek.add(bejegyzes);
        }

    }
}
