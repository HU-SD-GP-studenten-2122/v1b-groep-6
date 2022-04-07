package Presentiesysteem;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Student extends Gebruiker{
    private int studentnummer;
    private CheckBox Presentiechkbx;
    private TextField reden;
    private ArrayList<Presentie> Presenties;

    public Student(String nm, String ml, String ww, int sn,String rl,String Presentie, String reden){
        super(nm, ml, ww, rl);
        this.studentnummer = sn;
        this.Presentiechkbx = new CheckBox();
        this.reden = new TextField();
        rl = "student";
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
        return Presentiechkbx;
    }

    public void setPresentie(CheckBox presentie){
        this.Presentiechkbx = presentie;
    }

    public void presentietoevoegen(String stu, LocalDate Datum, String presentie, String reden) {
        Presenties.add(new Presentie(stu,Datum,presentie,reden));
    }

    public ArrayList<Presentie> getAllePresenties(){
        return Presenties;
    }

    public TextField getReden(){
        return reden;
    }

    public void setreden(TextField reden){
        this.reden = reden;
    }

    public String toString(){
        return naam;
    }
}
