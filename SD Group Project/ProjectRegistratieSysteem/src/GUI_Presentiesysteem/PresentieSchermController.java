package GUI_Presentiesysteem;

import Presentiesysteem.*;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;


public class PresentieSchermController {
    @FXML
    public Label Studentnaam;
    @FXML
    public ComboBox klasKeuze;
    @FXML private Label datumLabel;
    @FXML private TableView<Student> StudentenLijst;
    @FXML private TableColumn<Student,String> naam;
    @FXML private TableColumn<Student,Integer> Studentnummer;
    @FXML private TableColumn<Student, String> Presentie;
    @FXML private TableColumn<Student, String> reden;


    ObservableList<Klas> alleKlassen = FXCollections.observableArrayList(School.getAlleKlassen());
    ObservableList<Student> studenten = FXCollections.observableArrayList();

    public void initialize() {
        try {
            Studentnaam.setText(SysteemGebruikers.gethuidigegebruiker());
            klasKeuze.setItems(alleKlassen);
            datumLabel.setText("Datum: "+ LocalDate.now());


        } catch (Exception e) {


        }
    }

    public void toonStudenten() {
        StudentenLijst.getItems().clear();
        for (Klas k : alleKlassen) {
            if (k.equals(klasKeuze.getValue())) {
                for (Student s : k.getStudenten()) {studenten.add(s);}
                naam.setCellValueFactory(new PropertyValueFactory<Student,String>("naam"));
                Studentnummer.setCellValueFactory(new PropertyValueFactory<Student,Integer>("Studentnummer"));
                Presentie.setCellValueFactory(new PropertyValueFactory<Student,String>("Presentie"));
                reden.setCellValueFactory(new PropertyValueFactory<Student,String>("Reden"));

                StudentenLijst.setItems(studenten);
                }

            }
        }

    public void indienen(ActionEvent actionEvent) {
    }


    public void Cancel(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}

