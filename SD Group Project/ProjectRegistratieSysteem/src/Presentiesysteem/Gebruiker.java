package Presentiesysteem;


  public abstract class Gebruiker {
      protected String naam;
      protected String email;
      protected String wachtwoord;


    public Gebruiker(String nm, String ml, String ww){
        this.naam = nm;
        this.email = ml;
        this.wachtwoord = ww;
    }


    public String getNaam() {
        return naam;
    }

    public String getEmail() {
        return email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }


}