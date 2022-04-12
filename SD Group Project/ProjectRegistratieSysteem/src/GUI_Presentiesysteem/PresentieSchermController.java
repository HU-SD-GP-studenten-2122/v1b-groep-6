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
import javafx.stage.Stage;

import java.time.*;


public class PresentieSchermController {
    @FXML
    private Label Studentnaam;
    @FXML
    private ComboBox<Klas> klasKeuze;
    @FXML
    private ComboBox<String> lesKeuze;
    @FXML
    private Label datumLabel;
    @FXML
    private TableView<Student> StudentenLijst;
    @FXML
    private TableColumn<Student, String> naam;
    @FXML
    private TableColumn<Student, Integer> Studentnummer;
    @FXML
    private TableColumn<Student, Boolean> Presentie;
    @FXML
    private TableColumn<Student, String> reden;
    @FXML
    private Button accountKeuzesButton;


    ObservableList<Klas> alleKlassen = FXCollections.observableArrayList(School.getAlleKlassen());
    ObservableList<String> Lessen = FXCollections.observableArrayList();
    ObservableList<Student> studenten = FXCollections.observableArrayList();


    public void initialize() {
        try {
            for(Klas k: alleKlassen){
                for(Les l: k.getLessen()){
                    if(!Lessen.contains(l.getVak())){
                        Lessen.add(l.getVak());
                    }
                }
            }
        StudentenLijst.setItems(studenten);

        String gebruiker = SysteemGebruikers.gethuidigegebruikernaam();
        Studentnaam.setText(gebruiker);

        klasKeuze.setItems(alleKlassen);
        lesKeuze.setItems(Lessen);

        datumLabel.setText("Datum: " + LocalDate.now());
        } catch(Exception e){}
    }


    public void toonStudenten() {
        StudentenLijst.getItems().clear();
        for (Klas k : alleKlassen) {
            if (k.equals(klasKeuze.getValue())) {
                for (Student s : k.getStudenten()) {
                    studenten.add(s);
                }
                naam.setCellValueFactory(new PropertyValueFactory<Student,String>("naam"));
                Studentnummer.setCellValueFactory(new PropertyValueFactory<Student,Integer>("Studentnummer"));
                Presentie.setCellValueFactory(new PropertyValueFactory<Student,Boolean>("Presentie"));
                reden.setCellValueFactory(new PropertyValueFactory<Student,String>("Reden"));

                StudentenLijst.setItems(studenten);
                }

            }
        }

    public void indienen(ActionEvent actionEvent) {
        for(Student s : StudentenLijst.getItems()){
            String presentie = "present";
            if ( s.getPresentie()==null || !s.getPresentie().isSelected()) {
                if(s.getPresentie()==null){
                    presentie = "";
                }
                else {
                    presentie = "absent";
                }
            }

                s.presentietoevoegen(s.getNaam(),LocalDate.now(),lesKeuze.getValue(),presentie,s.getReden().getText());
        }


    }


    public void Terug(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    public void keuzeszien(MouseEvent mouseEvent) {
        boolean isZichtbaar = accountKeuzesButton.isVisible();
        if(isZichtbaar == true){
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

