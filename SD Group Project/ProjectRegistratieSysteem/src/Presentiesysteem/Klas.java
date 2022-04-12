package Presentiesysteem;

import java.util.ArrayList;

public class Klas {
    private String klasCode;
    private ArrayList<Student> Studenten;
    private ArrayList<Les> alleLessen;

    public Klas(String klascode){
        this.klasCode = klascode;
        Studenten  = new ArrayList<Student>();
        alleLessen = new ArrayList<Les>();

    }

    public void studentToevoegen(Student s){
        Studenten.add(s);
    }

    public void lesToevoegen(Les l){
        alleLessen.add(l);
    }

    public ArrayList<Student> getStudenten(){
        return Studenten;
    }

    public ArrayList<Les> getLessen(){
        return alleLessen;
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



