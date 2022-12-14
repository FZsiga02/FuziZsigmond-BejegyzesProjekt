package hu.petrik.oop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Bejegyzes> bejegyzesek = new ArrayList<>();
    private static List<Bejegyzes> bejegyzesek2 = new ArrayList<>();

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

        String fajlNev = "bejegyzesek.csv";

        try{
            fajlBeolvasas("bejegyzesek.csv");
        }catch(FileNotFoundException e){
            System.out.println("A megadott fájl nem létezik");
        }catch(IOException e){
            System.out.println("Ismeretlen hiba történt a fájl beolvasásakor");
        }

        likeOsztas();
        szovegKeres();

        System.out.println(bejegyzesek.toString());

        nepszeru();
        System.out.println("");
        tobbLike();
        System.out.println("");
        kevesebbLike();
        System.out.println("");
        rendezes();
    }

    private static void rendezes() {
        int index = 0;
        int max = 0;
        while(bejegyzesek2.size() != bejegyzesek.size()){
            max = 0;
            for (int i = 0; i < bejegyzesek.size(); i++) {
                if (bejegyzesek.get(i).getLikeok()>max && !bejegyzesek2.contains(bejegyzesek.get(i))){
                    index = i;
                    max=bejegyzesek.get(i).getLikeok();
                }
            }
            bejegyzesek2.add(bejegyzesek.get(index));
        }
        System.out.println(bejegyzesek2.toString());
    }

    private static void kevesebbLike() {

        int szamlalo = 0;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() < 15){
                szamlalo++;
            }
        }
        System.out.printf("%d db bejegyzés kapott 15-nél kevesebb likeot", szamlalo);

    }

    private static void tobbLike() {

        boolean tobb = false;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > 35){
                tobb = true;
            }
        }
        if (tobb){
            System.out.println("Van 35-nél több likeot szerző bejegyzés");
        }else {
            System.out.println("Nincs 35-nél több likeot szerző bejegyzés");
        }

    }

    private static void nepszeru() {
        int topLike = 0;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > topLike){
                topLike = bejegyzesek.get(i).getLikeok();
            }
        }
        System.out.printf("A legtöbb like: %d", topLike);
    }

    private static void szovegKeres() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Kérem adjon meg egy szöveget: ");
        String szoveg = sc.nextLine();

        bejegyzesek.get(1).setTartalom(szoveg);

    }

    private static void likeOsztas() {
        for (int i = 0; i < bejegyzesek.size()*20; i++) {
            int bejegyzesSorszam = (int)(Math.random()*bejegyzesek.size());
            bejegyzesek.get(bejegyzesSorszam).like();
        }
    }

    private static void fajlBeolvasas(String fajlNev) throws IOException {

        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while(sor != null && !sor.equals("")){
            String[] t = sor.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(t[0], t[1]);
            bejegyzesek.add(bejegyzes);
            sor = br.readLine();
        }
        br.close();
        fr.close();

    }

    private static void konzolosBekeres() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Kérem adja meg hány bejegyzés legyen felvéve: ");
        int db = sc.nextInt();
        sc.nextLine();
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
