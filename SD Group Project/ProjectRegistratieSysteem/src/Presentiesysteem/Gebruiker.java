package Presentiesysteem;


  public abstract class Gebruiker {
      protected String naam;
      protected String email;
      protected String wachtwoord;
      protected String rol;


    public Gebruiker(String nm, String ml, String ww, String rl){
        this.naam = nm;
        this.email = ml;
        this.wachtwoord = ww;
        this.rol=rl;
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

    public String getRol(){return rol;}

}