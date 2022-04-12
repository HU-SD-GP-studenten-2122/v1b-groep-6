package Presentiesysteem;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Gebruiker{
    private int studentnummer;
    private CheckBox Presentiechkbx;
    private TextField reden;
    private ArrayList<Presentie> Presenties;
    private String afaanmelding;

    public Student(String nm, String ml, String ww, int sn,String rl,String Presentie, String reden,String afg){
        super(nm, ml, ww, rl);
        this.studentnummer = sn;
        this.Presentiechkbx = new CheckBox();
        this.reden = new TextField();
        rl = "student";
        this.afaanmelding = afg;
        Presenties = new ArrayList<Presentie>();

    }


    public String getNaam(){return naam;}
    public int getStudentnummer(){return studentnummer;}
    public boolean equals(Object obj){
        boolean b = false;
        if (obj instanceof Student){
            Student s = (Student) obj;
            if(s.naam.equals(naam) && s.email.equals(email) && s.wachtwoord == wachtwoord && s.studentnummer == studentnummer){
                b = true;
            }
        }
        return b;
    }

    public CheckBox getPresentie(){
        CheckBox b = null;
        if(getAfgemeld().equals("Aangemeld")){
            b = Presentiechkbx;
        }
        return b;
    }

    public void setPresentie(CheckBox presentie){
        this.Presentiechkbx = presentie;
    }

    public void presentietoevoegen(String stu, LocalDate Datum,String vak, String presentie, String reden) {
        Presenties.add(new Presentie(stu,Datum,vak,presentie,reden));
        if(presentie.equals("Afgemeld")){
            setAfgemeld("Afgemeld");
        }
    }

    public ArrayList<Presentie> getAllePresenties(){
       return Presenties;
    }

    public TextField getReden(){
        if(getAfgemeld().equals("Afgemeld")){
            reden.setText("AFGEMELD");
        }
        else if (getAfgemeld().equals("Aangemeld")){
            reden.setText("");
        }
        return reden;
    }

    public void setAfgemeld(String a){
        this.afaanmelding = a;
    }
    public String getAfgemeld(){
        return afaanmelding;
    }

    public void setreden(TextField reden){
        this.reden = reden;

    }

    public String toString(){
        return naam;
    }
}
