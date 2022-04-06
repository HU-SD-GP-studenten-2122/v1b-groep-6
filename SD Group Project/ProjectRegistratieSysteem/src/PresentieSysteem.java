
import Presentiesysteem.School;
import Presentiesysteem.SysteemGebruikers;
import Presentiesysteem.Klas;
import Presentiesysteem.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PresentieSysteem extends Application {
    public static void main(String[] args){
        try {
            SysteemGebruikers sg = new SysteemGebruikers("presentie systeem");
            Klas k1 = new Klas("KL13-A");
            Klas k2 = new Klas("KL13-B");

            School HU = new School("Hogeschool Utrecht");
            HU.klasToevoegen(k1);
            HU.klasToevoegen(k2);
            Student s1 = new Student("Bob Bouwers", "bob.bouwers@student.hu.nl", "wachtwoordbob", 1234,"","");
            Student s2 = new Student("Dirk Droog", "Dirk.Droog@student.hu.nl", "wachtwoorddirk", 1235,"","");
            Student s3 = new Student("Kate Boom", "kate.boom@student.hu.nl", "wachtwoordkate", 1236,"","");
            Student s4 = new Student("Piet Vis", "piet.vis@student.hu.nl", "wachtwoordpiet", 1237,"","");
            Student s5 = new Student("Ronald Ding", "ronald.ding@student.hu.nl", "wachtwoordRondald", 1238,"","");
            Student s6 = new Student("Steven Droogbrood", "steven.droogbrood@student.hu.nl", "wachtwoordsteven", 1239,"","");
            Student s7 = new Student("Peter Steelpan", "peter.steelpan@student.hu.nl", "wachtwoordpeter", 1240,"","");
            k1.studentToevoegen(s1) ;
            k1.studentToevoegen(s2);
            k1.studentToevoegen(s3);
            k1.studentToevoegen(s4);
            k1.studentToevoegen(s5);
            k1.studentToevoegen(s6);
            k1.studentToevoegen(s7);
            Student s8 = new Student("Ding Dong", "ding.dong@student.hu.nl", "wachtwoordding", 1241,"","");
            Student s9 = new Student("Appel Boom", "appel.boom@student.hu.nl", "wachtwoordappel", 1242,"","");
            Student s10 = new Student("Man Super", "man.super@student.hu.nl", "wachtwoordman", 1243,"","");
            Student s11 = new Student("Karel Doei", "karel.doei@student.hu.nl", "wachtwoordkarel", 1244,"","");
            Student s12 = new Student("Pieter Vlieger", "pieter.vlieger@student.hu.nl", "wachtwoordpieter", 1245,"","");
            Student s13 = new Student("Nick Bloem", "nick.bloem@student.hu.nl", "wachtwoordnick", 1246,"","");
            Student s14 = new Student("Jan Spons", "jan.Spons@student.hu.nl", "wachtwoordjan", 1247,"","");
            k2.studentToevoegen(s8);
            k2.studentToevoegen(s9);
            k2.studentToevoegen(s10);
            k2.studentToevoegen(s11);
            k2.studentToevoegen(s12);
            k2.studentToevoegen(s13);
            k2.studentToevoegen(s14);
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
        stage.show();
    }
}
