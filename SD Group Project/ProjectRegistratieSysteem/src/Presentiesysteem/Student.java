package Presentiesysteem;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Student extends Gebruiker{
    private int studentnummer;
    private Klas klas;
    private CheckBox Presentie;
    private TextField reden;

    public Student(String nm, String ml, String ww, int sn,String Presentie, String reden){
        super(nm, ml, ww);
        this.studentnummer = sn;
        this.Presentie = new CheckBox();
        this.reden = new TextField();

    }


    public String getNaam(){return naam;}
    public int getStudentnummer(){return studentnummer;}

    public boolean equals(Object obj){
        boolean b = false;
        if (obj instanceof Student){
            Student s = (Student) obj;
            if(s.naam.equals(naam) && s.email.equals(email) && s.wachtwoord == wachtwoord && s.studentnummer == studentnummer && s.klas == klas){
                b = true;
            }
        }
        return b;
    }

    public CheckBox getPresentie(){
        return Presentie;
    }

    public void setPresentie(CheckBox presentie){
        this.Presentie = presentie;
    }

    public TextField getReden(){
        return reden;
    }

    public void setreden(TextField reden){
        this.reden = reden;
    }

    public String toString(){
        return naam+ studentnummer;
    }
}
