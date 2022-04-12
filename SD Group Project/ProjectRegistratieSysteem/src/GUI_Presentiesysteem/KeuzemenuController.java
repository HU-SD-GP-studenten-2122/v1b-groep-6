package GUI_Presentiesysteem;

import Presentiesysteem.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;

public class KeuzemenuController {
    @FXML public Label Studentnaam;
    @FXML private Button accountKeuzesButton;
    @FXML private Button keuzePresentieButton;
    @FXML private Button keuzeAanwezigheidButton;
    @FXML private Button keuzeAanafmeldenButton;

    @FXML private TableView<Les> Maandag;
    @FXML private TableColumn<Les, String> columnMaandagVak;
    @FXML private TableColumn<Les, String> columnMaandagBt;
    @FXML private TableColumn<Les, String> columnMaandagEt;

    @FXML private TableView<Les> Dinsdag;
    @FXML private TableColumn<Les, String> columnDinsdagVak;
    @FXML private TableColumn<Les, String> columnDinsdagBt;
    @FXML private TableColumn<Les, String> columnDinsdagEt;

    @FXML private TableView<Les> Woensdag;
    @FXML private TableColumn<Les, String> columnWoensdagVak;
    @FXML private TableColumn<Les, String> columnWoensdagBt;
    @FXML private TableColumn<Les, String> columnWoensdagEt;

    @FXML private TableView<Les> Donderdag;
    @FXML private TableColumn<Les, String> columnDonderdagVak;
    @FXML private TableColumn<Les, String> columnDonderdagBt;
    @FXML private TableColumn<Les, String> columnDonderdagEt;

    @FXML private TableView<Les> Vrijdag;
    @FXML private TableColumn<Les, String> columnVrijdagVak;
    @FXML private TableColumn<Les, String> columnVrijdagBt;
    @FXML private TableColumn<Les, String> columnVrijdagEt;




    ObservableList<Klas> alleKlassen = FXCollections.observableArrayList(School.getAlleKlassen());
    ObservableList<Les> lessenMaandag = FXCollections.observableArrayList();
    ObservableList<Les> lessenDinsdag = FXCollections.observableArrayList();
    ObservableList<Les> lessenWoensdag = FXCollections.observableArrayList();
    ObservableList<Les> lessenDonderdag = FXCollections.observableArrayList();
    ObservableList<Les> lessenVrijdag = FXCollections.observableArrayList();

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




            // rooster vullen
            for (Klas k : alleKlassen) {
                for (Student s : k.getStudenten()) {
                    if (s.getNaam().equals(SysteemGebruikers.gethuidigegebruikernaam())) {
                        for(Les l : k.getLessen()){
                            if(l.getDag().equals(DayOfWeek.MONDAY)){
                                lessenMaandag.add(l);
                            }
                            if(l.getDag().equals(DayOfWeek.TUESDAY)){
                                lessenDinsdag.add(l);
                            }
                            if(l.getDag().equals(DayOfWeek.WEDNESDAY)){
                                lessenWoensdag.add(l);
                            }
                            if(l.getDag().equals(DayOfWeek.THURSDAY)){
                                lessenDonderdag.add(l);
                            }
                            if(l.getDag().equals(DayOfWeek.FRIDAY)){
                                lessenVrijdag.add(l);
                            }

                        }
                        columnMaandagVak.setCellValueFactory(new PropertyValueFactory<Les, String>("tekst"));
                        columnMaandagBt.setCellValueFactory(new PropertyValueFactory<Les, String>("lesBegin"));
                        columnMaandagEt.setCellValueFactory(new PropertyValueFactory<Les, String>("lesEind"));
                        Maandag.setItems(lessenMaandag);

                        columnDinsdagVak.setCellValueFactory(new PropertyValueFactory<Les, String>("tekst"));
                        columnDinsdagBt.setCellValueFactory(new PropertyValueFactory<Les, String>("lesBegin"));
                        columnDinsdagEt.setCellValueFactory(new PropertyValueFactory<Les, String>("lesEind"));
                        Dinsdag.setItems(lessenDinsdag);

                        columnWoensdagVak.setCellValueFactory(new PropertyValueFactory<Les, String>("tekst"));
                        columnWoensdagBt.setCellValueFactory(new PropertyValueFactory<Les, String>("lesBegin"));
                        columnWoensdagEt.setCellValueFactory(new PropertyValueFactory<Les, String>("lesEind"));
                        Woensdag.setItems(lessenWoensdag);

                        columnDonderdagVak.setCellValueFactory(new PropertyValueFactory<Les, String>("tekst"));
                        columnDonderdagBt.setCellValueFactory(new PropertyValueFactory<Les, String>("lesBegin"));
                        columnDonderdagEt.setCellValueFactory(new PropertyValueFactory<Les, String>("lesEind"));
                        Donderdag.setItems(lessenDonderdag);

                        columnVrijdagVak.setCellValueFactory(new PropertyValueFactory<Les, String>("tekst"));
                        columnVrijdagBt.setCellValueFactory(new PropertyValueFactory<Les, String>("lesBegin"));
                        columnVrijdagEt.setCellValueFactory(new PropertyValueFactory<Les, String>("lesEind"));
                        Vrijdag.setItems(lessenVrijdag);

                    }
                }
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
