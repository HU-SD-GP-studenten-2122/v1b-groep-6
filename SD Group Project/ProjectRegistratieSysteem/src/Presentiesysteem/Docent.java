package Presentiesysteem;

public class Docent extends Gebruiker{
    public Docent(String nm, String ml, String ww){
        super(nm, ml, ww);
    }

    public boolean equals(Object obj){
        boolean b = false;
        if (obj instanceof Docent){
            Docent d = (Docent) obj;
            if(d.naam.equals(naam) && d.email.equals(email) && d.wachtwoord == wachtwoord){
                b = true;
            }
        }
        return b;
    }

    public String toString(){
        return "Docent: "+naam+" heeft een account met email: "+ email+ "en wachtwoord"+ wachtwoord;
    }
}
