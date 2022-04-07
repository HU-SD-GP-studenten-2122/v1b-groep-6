package GUI_Presentiesysteem;

import Presentiesysteem.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.time.LocalDate;

public class afmeldschermController {
    @FXML public Label Studentnaam;
    @FXML public ChoiceBox afaanmeldDropdown;
    @FXML public DatePicker afwezigheidDatumpicker;
    @FXML public ComboBox redenDropdown;
    @FXML public Label foutmeldingLabel;
    @FXML private Button accountKeuzesButton;

    ObservableList<String> Keuze = FXCollections.observableArrayList("Aanmelden", "Afmelden");
    ObservableList<String> redenen = FXCollections.observableArrayList("Ziek", "Doktersbezoek", "Afspraak met instantie", "Overlijden Familielid");
    ObservableList<Klas> alleKlassen = FXCollections.observableArrayList(School.getAlleKlassen());

    public void initialize() {
        try {
            String gebruiker = SysteemGebruikers.gethuidigegebruikernaam();
            Studentnaam.setText(gebruiker);
            afaanmeldDropdown.setItems(Keuze);
            redenDropdown.setItems(redenen);

        } catch (Exception e) {

        }
    }

    public void aanafmeldigIndienen(ActionEvent actionEvent) {
        foutmeldingLabel.setVisible(false);
        for (Klas k : alleKlassen) {
            for (Student s : k.getStudenten()) {
                if (s.getNaam().equals(SysteemGebruikers.gethuidigegebruikernaam())) {
                    if (afwezigheidDatumpicker.getValue() == null || afaanmeldDropdown.getValue() == "") {
                        foutmeldingLabel.setText("Alle velden moeten ingevuld zijn!");
                        foutmeldingLabel.setVisible(true);
                    }else if(afwezigheidDatumpicker.getValue() != null && afwezigheidDatumpicker.getValue().isBefore(LocalDate.now())) {
                        foutmeldingLabel.setText("Datum moet in de toekomst liggen!");
                        foutmeldingLabel.setVisible(true);
                    }else {
                        String afaanmelding = "";
                        String reden = "";
                        if(redenDropdown.getValue() != null){
                            reden = redenDropdown.getValue().toString();
                        }
                        if (afaanmeldDropdown.getValue().equals("Afmelden")) {
                            afaanmelding = "Afgemeld";
                        }
                        if (afaanmeldDropdown.getValue().equals("Aanmelden")) {
                            afaanmelding = "Aangemeld";
                            reden = "";
                        }
                        s.presentietoevoegen(s.getNaam(), afwezigheidDatumpicker.getValue(), afaanmelding, reden);
                        foutmeldingLabel.setTextFill(Paint.valueOf("#0080ff") );
                        foutmeldingLabel.setText(afaanmelding+ " voor "+ afwezigheidDatumpicker.getValue());
                        foutmeldingLabel.setVisible(true);
                        }
                    }
                }
            }
        }
    public void Terug (ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
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

