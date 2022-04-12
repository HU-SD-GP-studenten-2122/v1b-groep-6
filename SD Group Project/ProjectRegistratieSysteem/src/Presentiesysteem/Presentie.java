package Presentiesysteem;

import java.time.LocalDate;

public class Presentie {
    private String naam;
    private LocalDate Datum;
    private String vak;
    private String presentie;
    private String reden;

    public Presentie(String stu, LocalDate Datum,String vak, String presentie, String reden) {
        this.naam = stu;
        this.Datum = Datum;
        this.vak = vak;
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
    public String getVak() {return vak;
    }

    public String toString(){

        String b = "Op " + Datum + " was " + naam + " "+ getPresentie();

        if (getPresentie().equals("absent")) {
            b = b + " met de reden: " + reden;
        }
        return b;

    }
}
