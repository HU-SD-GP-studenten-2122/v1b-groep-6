package Presentiesysteem;

import java.util.ArrayList;

public class Klas {
    private String klasCode;
    private ArrayList<Student> Studenten;

    public Klas(String klascode){
        this.klasCode = klascode;
        Studenten  = new ArrayList<Student>();

    }

    public void studentToevoegen(Student s){
        Studenten.add(s);
    }

    public ArrayList<Student> getStudenten(){
        return Studenten;
    }

    public String getKlasCode() {
        return klasCode;
    }

    public boolean equals(Object obj){
        boolean b = false;
        if (obj instanceof Klas){
            Klas k = (Klas) obj;
            if(k.klasCode.equals(klasCode) ){
                b = true;
            }
        }
        return b;
    }

    public String toString(){
       return "Klas: "+klasCode;

    }

}



