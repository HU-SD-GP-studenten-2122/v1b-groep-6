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
    @FXML private TableColumn<Presentie,String> presentie;
    @FXML private TableColumn<Presentie,String> Reden;
    @FXML private PieChart presentieTaart;
    @FXML private Button accountKeuzesButton;

    ObservableList<Klas> alleKlassen = FXCollections.observableArrayList(School.getAlleKlassen());
    ObservableList<Presentie> allePresenties = FXCollections.observableArrayList();




    public void initialize(){
        int aantalPresent =0;
        int aantalAbsent =0;
        try {
            String gebruiker =SysteemGebruikers.gethuidigegebruikernaam();
            Studentnaam.setText(gebruiker);
        }catch (Exception e){
        }
        for (Klas k : alleKlassen) {
            for(Student s : k.getStudenten()){
                if(s.getNaam().equals(SysteemGebruikers.gethuidigegebruikernaam())){
                    for (Presentie p : s.getAllePresenties()) {
                        allePresenties.add(p);
                    }
                    Datum.setCellValueFactory(new PropertyValueFactory<Presentie,LocalDate>("Datum"));
                    presentie.setCellValueFactory(new PropertyValueFactory<Presentie,String>("Presentie"));
                    Reden.setCellValueFactory(new PropertyValueFactory<Presentie,String>("Reden"));
                    Collections.reverse(allePresenties);
                    weekpresentieView.setItems(allePresenties);
                }
            }
        }

        for (Klas k : alleKlassen) {
            for (Student s : k.getStudenten()) {
                if (s.getNaam().equals(SysteemGebruikers.gethuidigegebruikernaam())) {
                    for (Presentie p : s.getAllePresenties()) {
                        if (p.getPresentie().equals("absent")||p.getPresentie().equals("Afgemeld")) {
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
    }
    public void Terug(ActionEvent actionEvent) {
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