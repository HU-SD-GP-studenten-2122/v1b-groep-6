package Presentiesysteem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
public class SysteemGebruikers {


    private String systeemnaam;
    private static ArrayList<Gebruiker> alleGebruikers;
    private static Student huidigegebruiker;
    private static String huidigegebruikernaam;
    private static String huidigegebruikerRol;

    public SysteemGebruikers(String systeemnaam) {
        this.systeemnaam = systeemnaam;
        alleGebruikers = new ArrayList<>();
    }

    public void gebruikerToevoegen(Gebruiker g) {
        if (!alleGebruikers.contains(g)) {
            alleGebruikers.add(g);
        }
    }

    public static ArrayList<Gebruiker> getAlleGebruikers() {
        return alleGebruikers;
    }

    public static Student gethuidigegebruiker() {
        return huidigegebruiker;
    }
    public static String gethuidigegebruikernaam() {
        return huidigegebruikernaam;
    }
    public static String getHuidigegebruikerRol() {
        return huidigegebruikerRol;
    }


    public static boolean gebruikerBestaat(String gb, String ww){
        boolean b = false;
        for(Gebruiker g : SysteemGebruikers.getAlleGebruikers()){
            if(g.getEmail().equals(gb) && g.getWachtwoord().equals(ww)){
                b=true;
                huidigegebruikernaam =g.getNaam();
                huidigegebruikerRol = g.getRol();
            }
        }
        return b;
    }
}

