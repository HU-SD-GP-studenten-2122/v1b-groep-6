package Presentiesysteem;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.DayOfWeek;

public class Les {
    private String vak;
    private DayOfWeek dag;
    private String lesBegin;
    private String lesEind;
    private Docent docent;
    private String lokaal;
    private String tekst;



    public Les(String vk,DayOfWeek dag, String lb,String le,Docent dcnt, String lok,String txt){
        this.vak = vk;
        this.dag = dag;
        this.lesBegin = lb;
        this.lesEind = le;
        this.docent = dcnt;
        this.lokaal = lok;
        this.tekst = txt;

    }

    public String getVak() {
        return vak;
    }

    public DayOfWeek getDag(){
        return dag;
    }

    public String getLesBegin() {
        return lesBegin;
    }

    public String getLesEind() {
        return lesEind;
    }

    public Docent getDocent() {
        return docent;
    }

    public String getTekst() {
        return vak+ "\n"+lokaal+ "\n"+docent.getNaam();
    }

    public String toString(){
        return lesBegin+" tot "+lesEind+"\n"+vak+" van "+getDocent().getNaam()+"\n";
    }

}
