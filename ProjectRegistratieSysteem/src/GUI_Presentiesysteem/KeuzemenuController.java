package GUI_Presentiesysteem;

import Presentiesysteem.Docent;
import Presentiesysteem.Gebruiker;
import Presentiesysteem.Student;
import Presentiesysteem.SysteemGebruikers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class KeuzemenuController {
    @FXML public Label Studentnaam;
    @FXML private Button accountKeuzesButton;
    @FXML private Button keuzePresentieButton;
    @FXML private Button keuzeAanwezigheidButton;
    @FXML private Button keuzeAanafmeldenButton;

    public void initialize(){
        try {
            String gebruiker =SysteemGebruikers.gethuidigegebruikernaam();
            Studentnaam.setText(gebruiker);

            if(SysteemGebruikers.getHuidigegebruikerRol().equals("student")){
                keuzePresentieButton.setVisible(false) ;
            }else{
                keuzeAanwezigheidButton.setVisible(false);
                keuzeAanafmeldenButton.setVisible(false);
            }

        }catch (Exception e){

        }
    }

    public void presentieschermOpenen(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("presentieScherm.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Presentie ingeven");
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.showAndWait();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void aanwezigheidinzienschermOpenen(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("aanwezigheidInzien.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Aanwezigheid inzien");
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.showAndWait();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void aanafmeldenschermOpenen(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afmeldScherm.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Aan en- afmelden");
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.showAndWait();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void keuzeszien(MouseEvent mouseEvent) {
        boolean isZichtbaar = accountKeuzesButton.isVisible();
        if(isZichtbaar == true){
            System.out.println("hoi");
            accountKeuzesButton.setVisible(false);
        }else {accountKeuzesButton.setVisible(true);}
    }

    public void Uitloggen(ActionEvent actionEvent) {
        try {
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
