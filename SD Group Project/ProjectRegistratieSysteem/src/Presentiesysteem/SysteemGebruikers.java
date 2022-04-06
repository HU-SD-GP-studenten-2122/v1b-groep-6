package Presentiesysteem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
public class SysteemGebruikers {

    @FXML
    public TextField wachtwoordVeld;
    @FXML
    public TextField gebruikersnaamVeld;
    @FXML
    public Label foutmeldingLabel;
    private String systeemnaam;
    private static ArrayList<Gebruiker> alleGebruikers;
    private static String huidigegebruiker;
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

    public static String gethuidigegebruiker() {
        return huidigegebruiker;
    }


    public static boolean gebruikerBestaat(String gb, String ww){
        boolean b = false;
        for(Gebruiker g : SysteemGebruikers.getAlleGebruikers()){
            if(g.getEmail().equals(gb) && g.getWachtwoord().equals(ww)){
                b=true;
                huidigegebruiker =g.getNaam();
            }
        }
        return b;
    }
}

