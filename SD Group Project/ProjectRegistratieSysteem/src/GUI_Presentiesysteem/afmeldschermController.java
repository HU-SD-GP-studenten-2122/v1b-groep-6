package GUI_Presentiesysteem;

import Presentiesysteem.SysteemGebruikers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class afmeldschermController {
    @FXML
    public Label Studentnaam;

    public void initialize(){
        try {
            Studentnaam.setText(SysteemGebruikers.gethuidigegebruiker());

        }catch (Exception e){

        }
    }

    public void afwezigheidDatumIngeven(ActionEvent actionEvent) {
    }

    public void redeningeven(ActionEvent actionEvent) {
    }

    public void aanafmeldigIndienen(ActionEvent actionEvent) {
    }
}
