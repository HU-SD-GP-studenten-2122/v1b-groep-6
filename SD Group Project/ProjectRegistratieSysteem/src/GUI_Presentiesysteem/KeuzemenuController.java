package GUI_Presentiesysteem;

import Presentiesysteem.Gebruiker;
import Presentiesysteem.SysteemGebruikers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class KeuzemenuController {
    @FXML
    public Label Studentnaam;

    public void initialize(){
        try {
            Studentnaam.setText(SysteemGebruikers.gethuidigegebruiker());

        }catch (Exception e){

        }
    }

    public void presentieschermOpenen(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("presentieScherm.fxml"));
            Parent root = loader.load();

            Stage newStage = new Stage();
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
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.showAndWait();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
