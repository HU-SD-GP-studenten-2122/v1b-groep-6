
import Presentiesysteem.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.print.Doc;
import java.time.LocalDate;


public class PresentieSysteem extends Application {
    public static void main(String[] args){
        try {
            SysteemGebruikers sg = new SysteemGebruikers("presentie systeem");
            Klas k1 = new Klas("KL13-A");
            Klas k2 = new Klas("KL13-B");
            Docent d1 = new Docent("Harry Haar","harry.haar@hu.nl","wachtwoordharry","docent");
            sg.gebruikerToevoegen(d1);
            School HU = new School("Hogeschool Utrecht");
            HU.klasToevoegen(k1);
            HU.klasToevoegen(k2);
            Student s1 = new Student("Bob Bouwers", "bob.bouwers@student.hu.nl", "wachtwoordbob", 1234,"student","","");
            Student s2 = new Student("Dirk Droog", "Dirk.Droog@student.hu.nl", "wachtwoorddirk", 1235,"student","","");
            Student s3 = new Student("Kate Boom", "kate.boom@student.hu.nl", "wachtwoordkate", 1236,"student","","");
            Student s4 = new Student("Piet Vis", "piet.vis@student.hu.nl", "wachtwoordpiet", 1237,"student","","");
            Student s5 = new Student("Ronald Ding", "ronald.ding@student.hu.nl", "wachtwoordRondald", 1238,"student","","");
            Student s6 = new Student("Steven Droogbrood", "steven.droogbrood@student.hu.nl", "wachtwoordsteven", 1239,"student","","");
            Student s7 = new Student("Peter Steelpan", "peter.steelpan@student.hu.nl", "wachtwoordpeter", 1240,"student","","");
            k1.studentToevoegen(s1) ;
            k1.studentToevoegen(s2);
            k1.studentToevoegen(s3);
            k1.studentToevoegen(s4);
            k1.studentToevoegen(s5);
            k1.studentToevoegen(s6);
            k1.studentToevoegen(s7);
            Student s8 = new Student("Ding Dong", "ding.dong@student.hu.nl", "wachtwoordding", 1241,"student","","");
            Student s9 = new Student("Appel Boom", "appel.boom@student.hu.nl", "wachtwoordappel", 1242,"student","","");
            Student s10 = new Student("Man Super", "man.super@student.hu.nl", "wachtwoordman", 1243,"student","","");
            Student s11 = new Student("Karel Doei", "karel.doei@student.hu.nl", "wachtwoordkarel", 1244,"student","","");
            Student s12 = new Student("Pieter Vlieger", "pieter.vlieger@student.hu.nl", "wachtwoordpieter", 1245,"student","","");
            Student s13 = new Student("Nick Bloem", "nick.bloem@student.hu.nl", "wachtwoordnick", 1246,"student","","");
            Student s14 = new Student("Jan Spons", "jan.Spons@student.hu.nl", "wachtwoordjan", 1247,"student","","");
            k2.studentToevoegen(s8);
            k2.studentToevoegen(s9);
            k2.studentToevoegen(s10);
            k2.studentToevoegen(s11);
            k2.studentToevoegen(s12);
            k2.studentToevoegen(s13);
            k2.studentToevoegen(s14);
            LocalDate datum1 = LocalDate.now().minusDays(1);
            LocalDate datum2 = LocalDate.now().minusDays(2);
            LocalDate datum3 = LocalDate.now().minusDays(3);
            LocalDate datum4 = LocalDate.now().minusDays(4);
            LocalDate datum5 = LocalDate.now().minusDays(5);
            s2.presentietoevoegen(s2.getNaam(), datum5, "present","" );
            s2.presentietoevoegen(s2.getNaam(), datum4, "absent","ziek" );
            s2.presentietoevoegen(s2.getNaam(), datum3, "present","" );
            s2.presentietoevoegen(s2.getNaam(), datum2, "present","" );
            s2.presentietoevoegen(s2.getNaam(), datum1, "Afgemeld","Doktersbezoek" );
            for(Student s : k1.getStudenten()){
                sg.gebruikerToevoegen(s);
            }
            for(Student s : k2.getStudenten()){
                sg.gebruikerToevoegen(s);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI_Presentiesysteem/inlogScherm.fxml"));
        Parent root = loader.load();
        stage.setTitle("inlogscherm");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
