package Presentiesysteem;

import GUI_Presentiesysteem.PresentieSchermController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Presentie {
    private String naam;
    private LocalDate Datum;
    private String presentie;
    private String reden;

    public Presentie(String stu, LocalDate Datum, String presentie, String reden) {
        this.naam = stu;
        this.Datum = Datum;
        this.presentie = presentie;
        this.reden = reden;
    }


    public String getNaam(){
        return naam;
    }
    public LocalDate getDatum(){
        return Datum;
    }
    public String getPresentie(){
        return presentie;
    }
    public String getReden(){
        return reden;
    }


    public String toString(){

        String b = "Op " + Datum + " was " + naam + " "+ getPresentie();

        if (getPresentie().equals("absent")) {
            b = b + " met de reden: " + reden;
        }
        return b;

    }
}
