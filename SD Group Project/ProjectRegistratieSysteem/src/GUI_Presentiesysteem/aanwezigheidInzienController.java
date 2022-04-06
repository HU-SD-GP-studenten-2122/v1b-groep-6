package GUI_Presentiesysteem;

import Presentiesysteem.SysteemGebruikers;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class aanwezigheidInzienController {
    @FXML
    public Label Studentnaam;

    public void initialize(){
        try {
            Studentnaam.setText(SysteemGebruikers.gethuidigegebruiker());

        }catch (Exception e){

        }
    }
}
