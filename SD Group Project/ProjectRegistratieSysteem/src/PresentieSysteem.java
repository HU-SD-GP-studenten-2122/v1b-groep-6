
import Presentiesysteem.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.print.Doc;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class PresentieSysteem extends Application {
    public static void main(String[] args){
        try {
            SysteemGebruikers sg = new SysteemGebruikers();
            Klas k1 = new Klas("KL13-A");
            Klas k2 = new Klas("KL13-B");

            School HU = new School("Hogeschool Utrecht");
            HU.klasToevoegen(k1);
            HU.klasToevoegen(k2);

            //voorbeeld studenten en docenten aanmaken en aan klassen toevoegen
            Docent d1 = new Docent("Harry Haar","harry.haar@hu.nl","wachtwoordharry","docent");
            Docent d2 = new Docent("Karen Kaal","karen.kaal@hu.nl","wachtwoordkaren","docent");
            Docent d3 = new Docent("Karel Klein","karel.klein@hu.nl","wachtwoordkarel","docent");
            Docent d4 = new Docent("Harry Baals","harry.baals@hu.nl","wachtwoordharry","docent");
            Docent d5 = new Docent("Vera Plant","vera.plant@hu.nl","wachtwoordvera","docent");


            Student s1 = new Student("Bob Bouwers", "bob.bouwers@student.hu.nl", "wachtwoordbob", 1234,"student","","","Aangemeld");
            Student s2 = new Student("Dirk Droog", "Dirk.Droog@student.hu.nl", "wachtwoorddirk", 1235,"student","","","Aangemeld");
            Student s3 = new Student("Kate Boom", "kate.boom@student.hu.nl", "wachtwoordkate", 1236,"student","","","Aangemeld");
            Student s4 = new Student("Piet Vis", "piet.vis@student.hu.nl", "wachtwoordpiet", 1237,"student","","","Aangemeld");
            Student s5 = new Student("Ronald Ding", "ronald.ding@student.hu.nl", "wachtwoordRondald", 1238,"student","","","Aangemeld");
            Student s6 = new Student("Steven Droogbrood", "steven.droogbrood@student.hu.nl", "wachtwoordsteven", 1239,"student","","","Aangemeld");
            Student s7 = new Student("Peter Steelpan", "peter.steelpan@student.hu.nl", "wachtwoordpeter", 1240,"student","","","Aangemeld");
            k1.studentToevoegen(s1) ;
            k1.studentToevoegen(s2);
            k1.studentToevoegen(s3);
            k1.studentToevoegen(s4);
            k1.studentToevoegen(s5);
            k1.studentToevoegen(s6);
            k1.studentToevoegen(s7);
            Student s8 = new Student("Ding Dong", "ding.dong@student.hu.nl", "wachtwoordding", 1241,"student","","","Aangemeld");
            Student s9 = new Student("Appel Boom", "appel.boom@student.hu.nl", "wachtwoordappel", 1242,"student","","","Aangemeld");
            Student s10 = new Student("Man Super", "man.super@student.hu.nl", "wachtwoordman", 1243,"student","","","Aangemeld");
            Student s11 = new Student("Karel Doei", "karel.doei@student.hu.nl", "wachtwoordkarel", 1244,"student","","","Aangemeld");
            Student s12 = new Student("Pieter Vlieger", "pieter.vlieger@student.hu.nl", "wachtwoordpieter", 1245,"student","","","Aangemeld");
            Student s13 = new Student("Nick Bloem", "nick.bloem@student.hu.nl", "wachtwoordnick", 1246,"student","","","Aangemeld");
            Student s14 = new Student("Jan Spons", "jan.Spons@student.hu.nl", "wachtwoordjan", 1247,"student","","","Aangemeld");
            k2.studentToevoegen(s8);
            k2.studentToevoegen(s9);
            k2.studentToevoegen(s10);
            k2.studentToevoegen(s11);
            k2.studentToevoegen(s12);
            k2.studentToevoegen(s13);
            k2.studentToevoegen(s14);

            //voorbeeld student presentie inzien
            LocalDate datum1 = LocalDate.now().minusDays(1);
            LocalDate datum2 = LocalDate.now().minusDays(2);
            LocalDate datum3 = LocalDate.now().minusDays(3);
            LocalDate datum4 = LocalDate.now().minusDays(4);
            LocalDate datum5 = LocalDate.now().minusYears(5);
            s2.presentietoevoegen(s2.getNaam(), datum5, "Nederlands", "present","" );
            s2.presentietoevoegen(s2.getNaam(), datum4,"Duits", "absent","weg gestuurd" );
            s2.presentietoevoegen(s2.getNaam(), datum3,"Biologie", "present","" );
            s2.presentietoevoegen(s2.getNaam(), datum2,"Frans", "present","" );
            s2.presentietoevoegen(s2.getNaam(), datum1,"", "Afgemeld","Ziek" );

            //studenten en docenten als gebruikers toevoegen
            for(Student s : k1.getStudenten()){
                sg.gebruikerToevoegen(s);
            }
            for(Student s : k2.getStudenten()){
                sg.gebruikerToevoegen(s);
            }
            sg.gebruikerToevoegen(d1);
            sg.gebruikerToevoegen(d2);
            sg.gebruikerToevoegen(d3);
            sg.gebruikerToevoegen(d4);
            sg.gebruikerToevoegen(d5);
            //klas KL13-A
            // voorbeeld lessen maandag
            Les l1 = new Les("Nederlands", DayOfWeek.MONDAY , "09:00", "12:00", d1,"HL15-6.321","");
            Les l2 = new Les("Duits",DayOfWeek.MONDAY , "12:30", "13:20", d2,"HL15-5.085","");
            Les l3 = new Les("Rekenen",DayOfWeek.MONDAY , "13:25", "14:15", d3,"HL15-6.321","");
            Les l4 = new Les("Gym",DayOfWeek.MONDAY , "14:20", "15:10", d4,"HL15-5.085","");
            Les l5 = new Les("Biologie",DayOfWeek.MONDAY , "15:25", "16:15", d5,"HL15-5.080","");
            k1.lesToevoegen(l1);
            k1.lesToevoegen(l2);
            k1.lesToevoegen(l3);
            k1.lesToevoegen(l4);
            k1.lesToevoegen(l5);

            // voorbeeld lessen dinsdag
            Les l6 = new Les("Rekenen",DayOfWeek.TUESDAY, "12:30", "13:20", d3,"HL15-6.030","");
            Les l7 = new Les("Biologie",DayOfWeek.TUESDAY , "13:25", "14:15", d1,"HL15-6.321","");
            Les l8 = new Les("Gym",DayOfWeek.TUESDAY , "14:20", "15:10", d4,"HL15-5.080","");
            Les l9 = new Les("Frans",DayOfWeek.TUESDAY , "15:25", "16:15", d1,"HL15-5.085","");
            k1.lesToevoegen(l6);
            k1.lesToevoegen(l7);
            k1.lesToevoegen(l8);
            k1.lesToevoegen(l9);

            // voorbeeld lessen woensdag
            Les l10 = new Les("Nederlands", DayOfWeek.WEDNESDAY , "09:00", "12:00", d1,"HL15-5.080","");
            Les l12 = new Les("Duits",DayOfWeek.WEDNESDAY , "12:30", "13:20", d2,"HL15-6.030","");
            Les l13 = new Les("Rekenen",DayOfWeek.WEDNESDAY , "13:25", "14:15", d3,"HL15-6.321","");
            Les l14 = new Les("Gym",DayOfWeek.WEDNESDAY , "14:20", "15:10", d4,"HL15-5.085","");
            Les l15 = new Les("Biologie",DayOfWeek.WEDNESDAY , "15:25", "16:15", d5,"HL15-5.080","");
            k1.lesToevoegen(l10);
            k1.lesToevoegen(l12);
            k1.lesToevoegen(l13);
            k1.lesToevoegen(l14);
            k1.lesToevoegen(l15);


            // voorbeeld lessen donderdag
            Les l16 = new Les("Rekenen",DayOfWeek.THURSDAY, "12:30", "13:20", d3,"HL15-6.321","");
            Les l17 = new Les("Biologie",DayOfWeek.THURSDAY , "13:25", "14:15", d1,"HL15-5.085","");
            Les l18 = new Les("Gym",DayOfWeek.THURSDAY , "14:20", "15:10", d4,"HL15-5.080","");
            Les l19 = new Les("Frans",DayOfWeek.THURSDAY , "15:25", "16:15", d1,"HL15-6.321","");
            k1.lesToevoegen(l16);
            k1.lesToevoegen(l17);
            k1.lesToevoegen(l18);
            k1.lesToevoegen(l19);

            // voorbeeld lessen vrijdag
            Les l20 = new Les("Nederlands", DayOfWeek.FRIDAY, "09:00", "12:00", d1,"HL15-5.080","");
            Les l21 = new Les("Duits",DayOfWeek.FRIDAY , "12:30", "13:20", d2,"HL15-6.321","");
            k1.lesToevoegen(l20);
            k1.lesToevoegen(l21);

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
