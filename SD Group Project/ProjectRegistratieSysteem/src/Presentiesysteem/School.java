package Presentiesysteem;

import java.util.ArrayList;

public class School {
    private String naam;
    private static ArrayList<Klas> alleKlassen;

    public School(String naam){
        this.naam = naam;
        alleKlassen  = new ArrayList<Klas>();
    }

    public void klasToevoegen(Klas k){
        alleKlassen.add(k);
    }

    public static ArrayList<Klas> getAlleKlassen(){
        return alleKlassen;
    }

}
