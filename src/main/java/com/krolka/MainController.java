package com.krolka;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class MainController {

    List<File> files = null;

    private PdfUtility pdfUtility;

    @FXML
    private Label welcomeText;

    @FXML
    private Button executeButton;

    @FXML
    private TableView<File> tableView01;
    @FXML
    private TableColumn<File, String> tableview01FileName;
    @FXML
    private TableColumn<File, String> tableview01Path;


    @FXML
    void loadFiles(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF FIles", "*.pdf"));
        files = fc.showOpenMultipleDialog(null);


        for (File file : files) {
            System.out.println(file.getAbsoluteFile());
        }

        populateTableView(files);
        executeButton.setDisable(false);
        executeButton.isFocused();
    }

    void populateTableView(List<File> files) {
        tableview01FileName.setCellValueFactory(new PropertyValueFactory<File, String>("Name"));
        tableview01Path.setCellValueFactory(new PropertyValueFactory<File, String>("path"));

        tableView01.getItems().setAll(files);
    }

    @FXML
    void clearFileList(ActionEvent event) {
        files = null;
        tableView01.getItems().clear();
        executeButton.setDisable(true);
        welcomeText.setText("");

    }

    @FXML
    void execute(ActionEvent event) throws IOException {

        pdfUtility = new PdfUtility();

        for (File file : files) {

            pdfUtility.prepare(file);

        }

        welcomeText.setText("Success!!!");
    }

}