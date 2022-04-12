package GUI_Presentiesysteem;

import Presentiesysteem.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

public class aanwezigheidInzienController {
    @FXML public Label Studentnaam;
    @FXML private TableView<Presentie> weekpresentieView;
    @FXML private TableColumn<Presentie, LocalDate> Datum;
    @FXML private TableColumn<Presentie, String> vak;
    @FXML private TableColumn<Presentie,String> presentie;
    @FXML private TableColumn<Presentie,String> Reden;
    @FXML private PieChart presentieTaart;
    @FXML private Button accountKeuzesButton;
    @FXML private ComboBox<String> filterkeus;

    ObservableList<Klas> alleKlassen = FXCollections.observableArrayList(School.getAlleKlassen());
    ObservableList<Presentie> allePresenties = FXCollections.observableArrayList();
    ObservableList<Presentie> allePresentiesditJaar = FXCollections.observableArrayList();
    ObservableList<String> Filterkeuzes = FXCollections.observableArrayList("Alle Presenties","Presenties dit jaar");
    ObservableList<Presentie> leeg = FXCollections.observableArrayList();
    ObservableList<Presentie> keus = allePresenties;




    public void initialize(){
        filterkeus.setValue("Alle Presenties");
        int aantalPresent =0;
        int aantalAbsent =0;
        try {
            filterkeus.setItems(Filterkeuzes);
            String gebruiker =SysteemGebruikers.gethuidigegebruikernaam();
            Studentnaam.setText(gebruiker);
        for (Klas k : alleKlassen) {
            for(Student s : k.getStudenten()){
                if(s.getNaam().equals(SysteemGebruikers.gethuidigegebruikernaam())){
                    for (Presentie p : s.getAllePresenties()) {
                        allePresenties.add(p);
                        if(p.getDatum().getYear() == LocalDate.now().getYear()){
                            allePresentiesditJaar.add(p);
                        }
                    }

                    Datum.setCellValueFactory(new PropertyValueFactory<Presentie,LocalDate>("Datum"));
                    vak.setCellValueFactory(new PropertyValueFactory<Presentie,String>("vak"));
                    presentie.setCellValueFactory(new PropertyValueFactory<Presentie,String>("Presentie"));
                    Reden.setCellValueFactory(new PropertyValueFactory<Presentie,String>("Reden"));
                    Collections.reverse(allePresenties);
                    Collections.reverse(allePresentiesditJaar);
                    weekpresentieView.setItems(allePresenties);
                }
            }
        }

        for (Klas k : alleKlassen) {
            for (Student s : k.getStudenten()) {
                if (s.getNaam().equals(SysteemGebruikers.gethuidigegebruikernaam())) {
                    for (Presentie p : s.getAllePresenties()) {
                        if (p.getPresentie().equals("absent")) {
                            aantalAbsent++;
                        }else{
                            aantalPresent ++;
                        }

                    }
                }
            }
        }
        ObservableList<PieChart.Data> taartData = FXCollections.observableArrayList(new PieChart.Data("Absent",aantalAbsent),new PieChart.Data("Present",aantalPresent));
        presentieTaart.setData(taartData);

        }catch (Exception e){

        }
    }
    public void filteren(ActionEvent actionEvent){
        System.out.println(allePresenties);
        System.out.println(allePresentiesditJaar);
        weekpresentieView.setItems(leeg);
        Datum.setCellValueFactory(new PropertyValueFactory<Presentie,LocalDate>("Datum"));
        vak.setCellValueFactory(new PropertyValueFactory<Presentie,String>("vak"));
        presentie.setCellValueFactory(new PropertyValueFactory<Presentie,String>("Presentie"));
        Reden.setCellValueFactory(new PropertyValueFactory<Presentie,String>("Reden"));
        if(filterkeus.getValue().equals("Alle Presenties")){
            weekpresentieView.setItems(allePresenties);
        } else if(filterkeus.getValue().equals("Presenties dit jaar")){
            weekpresentieView.setItems(allePresentiesditJaar);
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