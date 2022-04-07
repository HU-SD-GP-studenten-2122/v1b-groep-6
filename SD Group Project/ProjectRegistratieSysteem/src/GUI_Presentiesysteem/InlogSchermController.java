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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class InlogSchermController {

   @FXML public Button inlogButton;
   @FXML public Label foutmeldingLabel;
   @FXML public TextField wachtwoordVeld;
   @FXML public TextField gebruikersnaamVeld;
   ObservableList<Gebruiker> alleGebruikers = FXCollections.observableArrayList(SysteemGebruikers.getAlleGebruikers());

    public void gebruikersnaam(ActionEvent actionEvent) {    }
    public void wachtwoord(ActionEvent actionEvent) {    }



    public void inlog(ActionEvent actionEvent){
        if(wachtwoordVeld.getText().equals("") || gebruikersnaamVeld.getText().equals("")){
            foutmeldingLabel.setText("alle velden moeten ingevuld zijn!");
            foutmeldingLabel.setVisible(true);
        }
        else {
            if (SysteemGebruikers.gebruikerBestaat(gebruikersnaamVeld.getText(), wachtwoordVeld.getText())) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Keuzemenu.fxml"));
                    Parent root = loader.load();
                    Stage newStage = new Stage();
                    newStage.setTitle("Keuzemenu");
                    newStage.setScene(new Scene(root));
                    newStage.initModality(Modality.APPLICATION_MODAL);
                    newStage.showAndWait();

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                foutmeldingLabel.setText("Wachtwoord of gebruikersnaam is incorrect!");
                foutmeldingLabel.setVisible(true);
            }
        }
    }


}
