package com.example.nuvote;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AdminSideController implements Initializable {

    @FXML
    private TableView<Candidate> presidentCandidates;

    @FXML
    private TableColumn<Candidate, String> presidentColumnName;

    @FXML
    private TableColumn<Candidate, String> presidentColumnParty;

    @FXML
    private TableColumn<Candidate, String> presidentColumnCourse;
    @FXML
    private TableView<Candidate> vicePresidentCandidates;

    @FXML
    private TableColumn<Candidate, String> vicePresidentColumnName;

    @FXML
    private TableColumn<Candidate, String> vicePresidentColumnParty;

    @FXML
    private TableColumn<Candidate, String> vicePresidentColumnCourse;
    @FXML
    private TableView<Candidate> secretaryCandidates;

    @FXML
    private TableColumn<Candidate, String> secretaryColumnName;

    @FXML
    private TableColumn<Candidate, String> secretaryColumnParty;

    @FXML
    private TableColumn<Candidate, String> secretaryColumnCourse;
    @FXML
    private TableView<Candidate> treasurerCandidates;

    @FXML
    private TableColumn<Candidate, String> treasurerColumnName;

    @FXML
    private TableColumn<Candidate, String> treasurerColumnParty;

    @FXML
    private TableColumn<Candidate, String> treasurerColumnCourse;
    @FXML
    private TableView<Candidate> PIOCandidates;

    @FXML
    private TableColumn<Candidate, String> PIOColumnName;

    @FXML
    private TableColumn<Candidate, String> PIOColumnParty;

    @FXML
    private TableColumn<Candidate, String> PIOColumnCourse;
    @FXML
    private TableView<Candidate> auditorCandidates;

    @FXML
    private TableColumn<Candidate, String> auditorColumnName;

    @FXML
    private TableColumn<Candidate, String> auditorColumnParty;

    @FXML
    private TableColumn<Candidate, String> auditorColumnCourse;
    static ObservableList<Candidate> list = FXCollections.observableArrayList(HelloApplication.candidateList.getCandidates());
    static List<Candidate> presidentCandidatesList = list.stream()
            .filter(candidate -> "President".equals(candidate.getPosition()))
            .collect(Collectors.toList());
    static List<Candidate> vicePresidentCandidatesList = list.stream()
            .filter(candidate -> "Vice President".equals(candidate.getPosition()))
            .collect(Collectors.toList());
    static List<Candidate> secretaryCandidatesList = list.stream()
            .filter(candidate -> "Secretary".equals(candidate.getPosition()))
            .collect(Collectors.toList());
    static List<Candidate> treasurerCandidatesList = list.stream()
            .filter(candidate -> "Treasurer".equals(candidate.getPosition()))
            .collect(Collectors.toList());
    static List<Candidate> PIOCandidatesList = list.stream()
            .filter(candidate -> "PIO".equals(candidate.getPosition()))
            .collect(Collectors.toList());
    static List<Candidate> auditorCandidatesList = list.stream()
            .filter(candidate -> "Auditor".equals(candidate.getPosition()))
            .collect(Collectors.toList());

    ObservableList<Candidate> presidentCandidatesObservable = FXCollections.observableArrayList(presidentCandidatesList);
    ObservableList<Candidate> vicePresidentCandidatesObservable = FXCollections.observableArrayList(vicePresidentCandidatesList);
    ObservableList<Candidate> secretaryCandidatesObservable = FXCollections.observableArrayList(secretaryCandidatesList);
    ObservableList<Candidate> treasurerCandidatesObservable = FXCollections.observableArrayList(treasurerCandidatesList);
    ObservableList<Candidate> PIOCandidatesObservable = FXCollections.observableArrayList(PIOCandidatesList);
    ObservableList<Candidate> auditorCandidatesObservable = FXCollections.observableArrayList(auditorCandidatesList);

    @FXML
    private Button btnAddPresident;
    @FXML
    private Button btnAddVicePresident;
    @FXML
    private Button btnAddSecretary;
    @FXML
    private Button btnAddTreasurer;
    @FXML
    private Button btnAddPIO;
    @FXML
    private Button btnAddAuditor;

    @FXML
    private VBox presidentPopUpAdd;
    @FXML
    private VBox vicePresidentPopUpAdd;
    @FXML
    private VBox secretaryPopUpAdd;
    @FXML
    private VBox treasurerPopUpAdd;
    @FXML
    private VBox PIOPopUpAdd;
    @FXML
    private VBox auditorPopUpAdd;

    @FXML
    private void presidentShowPopUpAdd(){
        presidentPopUpAdd.setVisible(true);
    }
    @FXML
    private void vicePresidentShowPopUpAdd(){
        vicePresidentPopUpAdd.setVisible(true);
    }
    @FXML
    private void secretaryShowPopUpAdd(){
        secretaryPopUpAdd.setVisible(true);
    }
    @FXML
    private void treasurerShowPopUpAdd(){
        treasurerPopUpAdd.setVisible(true);
    }
    @FXML
    private void PIOShowPopUpAdd(){
        PIOPopUpAdd.setVisible(true);
    }
    @FXML
    private void auditorShowPopUpAdd(){
        auditorPopUpAdd.setVisible(true);
    }
    @FXML
    private TextField presidentfldName;
    @FXML
    private TextField presidentfldParty;
    @FXML
    private TextField presidentfldCourse;
    @FXML
    private TextField vicePresidentfldName;
    @FXML
    private TextField vicePresidentfldParty;
    @FXML
    private TextField vicePresidentfldCourse;
    @FXML
    private TextField secretaryfldName;
    @FXML
    private TextField secretaryfldParty;
    @FXML
    private TextField secretaryfldCourse;
    @FXML
    private TextField treasurerfldName;
    @FXML
    private TextField treasurerfldParty;
    @FXML
    private TextField treasurerfldCourse;
    @FXML
    private TextField PIOfldName;
    @FXML
    private TextField PIOfldParty;
    @FXML
    private TextField PIOfldCourse;
    @FXML
    private TextField auditorfldName;
    @FXML
    private TextField auditorfldParty;
    @FXML
    private TextField auditorfldCourse;
    @FXML
    private void addCandidatePresident(){
        if (HelloApplication.electionController.isElectionDate()){
            String name = presidentfldName.getText();
            String party = presidentfldParty.getText();
            String course = presidentfldCourse.getText();

            Candidate newCandidate = new Candidate("President", name, party, course, null);
            System.out.println(newCandidate.toString());
            HelloApplication.candidateList.addCandidate(newCandidate);
            HelloApplication.candidateList.saveToFile("candidates.txt");

            list = FXCollections.observableArrayList(HelloApplication.candidateList.getCandidates());
            presidentCandidatesList = list.stream()
                    .filter(candidate -> "President".equals(candidate.getPosition()))
                    .collect(Collectors.toList());
            presidentCandidatesObservable = FXCollections.observableArrayList(presidentCandidatesList);
            presidentCandidates.setItems(presidentCandidatesObservable);
            updateCandidatesChart();

            presidentPopUpAdd.setVisible(false);
        } else {
            showAlert("Election Not Started", "Election has not started yet.");
            presidentPopUpAdd.setVisible(false);
        }



    }
    @FXML
    private void addCandidateVicePresident(){
        if (HelloApplication.electionController.isElectionDate()){
            String name = vicePresidentfldName.getText();
            String party = vicePresidentfldParty.getText();
            String course = vicePresidentfldCourse.getText();

            Candidate newCandidate = new Candidate("Vice President", name, party, course, null);
            System.out.println(newCandidate.toString());
            HelloApplication.candidateList.addCandidate(newCandidate);
            HelloApplication.candidateList.saveToFile("candidates.txt");

            list = FXCollections.observableArrayList(HelloApplication.candidateList.getCandidates());
            vicePresidentCandidatesList = list.stream()
                    .filter(candidate -> "Vice President".equals(candidate.getPosition()))
                    .collect(Collectors.toList());
            vicePresidentCandidatesObservable = FXCollections.observableArrayList(vicePresidentCandidatesList);
            vicePresidentCandidates.setItems(vicePresidentCandidatesObservable);
            updateCandidatesChart();


            vicePresidentPopUpAdd.setVisible(false);
        } else {
            showAlert("Election Not Started", "Election has not started yet.");
            vicePresidentPopUpAdd.setVisible(false);
        }


    }
    @FXML
    private void addCandidateSecretary(){
        if (HelloApplication.electionController.isElectionDate()){
            String name = secretaryfldName.getText();
            String party = secretaryfldParty.getText();
            String course = secretaryfldCourse.getText();

            Candidate newCandidate = new Candidate("Secretary", name, party, course, null);
            System.out.println(newCandidate.toString());
            HelloApplication.candidateList.addCandidate(newCandidate);
            HelloApplication.candidateList.saveToFile("candidates.txt");

            list = FXCollections.observableArrayList(HelloApplication.candidateList.getCandidates());
            secretaryCandidatesList = list.stream()
                    .filter(candidate -> "Secretary".equals(candidate.getPosition()))
                    .collect(Collectors.toList());
            secretaryCandidatesObservable = FXCollections.observableArrayList(secretaryCandidatesList);
            secretaryCandidates.setItems(secretaryCandidatesObservable);
            updateCandidatesChart();

            secretaryPopUpAdd.setVisible(false);
        } else{
            showAlert("Election Not Started", "Election has not started yet.");
            secretaryPopUpAdd.setVisible(false);
        }

    }
    @FXML
    private void addCandidateTreasurer(){
        if (HelloApplication.electionController.isElectionDate()){
            String name = treasurerfldName.getText();
            String party = treasurerfldParty.getText();
            String course = treasurerfldCourse.getText();

            Candidate newCandidate = new Candidate("Treasurer", name, party, course, null);
            System.out.println(newCandidate.toString());
            HelloApplication.candidateList.addCandidate(newCandidate);
            HelloApplication.candidateList.saveToFile("candidates.txt");

            list = FXCollections.observableArrayList(HelloApplication.candidateList.getCandidates());
            treasurerCandidatesList = list.stream()
                    .filter(candidate -> "Treasurer".equals(candidate.getPosition()))
                    .collect(Collectors.toList());
            treasurerCandidatesObservable = FXCollections.observableArrayList(treasurerCandidatesList);
            treasurerCandidates.setItems(treasurerCandidatesObservable);
            updateCandidatesChart();

            treasurerPopUpAdd.setVisible(false);
        } else {
            showAlert("Election Not Started", "Election has not started yet.");
            treasurerPopUpAdd.setVisible(false);
        }

    }
    @FXML
    private void addCandidatePIO(){
        if (HelloApplication.electionController.isElectionDate()){
            String name = PIOfldName.getText();
            String party = PIOfldParty.getText();
            String course = PIOfldCourse.getText();

            Candidate newCandidate = new Candidate("PIO", name, party, course, null);
            System.out.println(newCandidate.toString());
            HelloApplication.candidateList.addCandidate(newCandidate);
            HelloApplication.candidateList.saveToFile("candidates.txt");

            list = FXCollections.observableArrayList(HelloApplication.candidateList.getCandidates());
            PIOCandidatesList = list.stream()
                    .filter(candidate -> "PIO".equals(candidate.getPosition()))
                    .collect(Collectors.toList());
            PIOCandidatesObservable = FXCollections.observableArrayList(PIOCandidatesList);
            PIOCandidates.setItems(PIOCandidatesObservable);
            updateCandidatesChart();


            PIOPopUpAdd.setVisible(false);
        } else {
            showAlert("Election Not Started", "Election has not started yet.");
            PIOPopUpAdd.setVisible(false);
        }

    }
    @FXML
    private void addCandidateAuditor(){
        if(HelloApplication.electionController.isElectionDate()){
            String name = auditorfldName.getText();
            String party = auditorfldParty.getText();
            String course = auditorfldCourse.getText();

            Candidate newCandidate = new Candidate("Auditor", name, party, course, null);
            System.out.println(newCandidate.toString());
            HelloApplication.candidateList.addCandidate(newCandidate);
            HelloApplication.candidateList.saveToFile("candidates.txt");

            list = FXCollections.observableArrayList(HelloApplication.candidateList.getCandidates());
            auditorCandidatesList = list.stream()
                    .filter(candidate -> "Auditor".equals(candidate.getPosition()))
                    .collect(Collectors.toList());
            auditorCandidatesObservable = FXCollections.observableArrayList(auditorCandidatesList);
            auditorCandidates.setItems(auditorCandidatesObservable);
            updateCandidatesChart();

            auditorPopUpAdd.setVisible(false);
        } else {
            showAlert("Election Not Started", "Election has not started yet.");
            auditorPopUpAdd.setVisible(false);
        }

    }
    @FXML
    private VBox presidentVBox;
    @FXML
    private VBox vicePresidentVBox;
    @FXML
    private VBox secretaryVBox;
    @FXML
    private VBox treasurerVBox;
    @FXML
    private VBox PIOVBox;
    @FXML
    private VBox auditorVBox;
    @FXML
    private void showPresident(MouseEvent event){
        presidentVBox.setVisible(true);
        vicePresidentVBox.setVisible(false);
        secretaryVBox.setVisible(false);
        treasurerVBox.setVisible(false);
        PIOVBox.setVisible(false);
        auditorVBox.setVisible(false);
    }
    @FXML
    private void showVicePresident(MouseEvent event){
        vicePresidentVBox.setVisible(true);
        presidentVBox.setVisible(false);
        secretaryVBox.setVisible(false);
        treasurerVBox.setVisible(false);
        PIOVBox.setVisible(false);
    }

    @FXML
    private void showSecretary(MouseEvent event){
        secretaryVBox.setVisible(true);
        presidentVBox.setVisible(false);
        vicePresidentVBox.setVisible(false);
        treasurerVBox.setVisible(false);
        PIOVBox.setVisible(false);
        auditorVBox.setVisible(false);
    }
    @FXML
    private void showTreasurer(MouseEvent event){
        treasurerVBox.setVisible(true);
        secretaryVBox.setVisible(false);
        presidentVBox.setVisible(false);
        vicePresidentVBox.setVisible(false);
        PIOVBox.setVisible(false);
        auditorVBox.setVisible(false);
    }
    @FXML
    private void showPIO(MouseEvent event){
        PIOVBox.setVisible(true);
        treasurerVBox.setVisible(false);
        secretaryVBox.setVisible(false);
        presidentVBox.setVisible(false);
        vicePresidentVBox.setVisible(false);
        auditorVBox.setVisible(false);
    }
    @FXML
    private void showAuditor(MouseEvent event){
        auditorVBox.setVisible(true);
        PIOVBox.setVisible(false);
        treasurerVBox.setVisible(false);
        secretaryVBox.setVisible(false);
        presidentVBox.setVisible(false);
        vicePresidentVBox.setVisible(false);

    }
    @FXML
    private HBox popLogOut;
    @FXML
    private Label lblAdmin;
    private boolean isLogOutShow = false;
    @FXML
    private void showLogOut(MouseEvent event){
        if(isLogOutShow != true){
            popLogOut.setVisible(true);
            isLogOutShow = true;
        } else {
            popLogOut.setVisible(false);
            isLogOutShow = false;
        }
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private void logOut(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private TableView<Student> students;

    @FXML
    private TableColumn<Student, String> studentNumberColumn;

    @FXML
    private TableColumn<Student, String> studentStatusColumn;

    static ObservableList<Student> observableStudentList = FXCollections.observableArrayList(HelloApplication.studentList.getStudentsAsList());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCandidatesChart();

        studentNumberColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("studentNumber"));
        studentStatusColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("status"));

        studentNumberColumn.setStyle(
                "-fx-font-size: 16px; " + // Adjust font size as needed
                        "-fx-font-weight: bold; " +
                        // Optional: Change text color
                        "-fx-alignment: center; "+ // Optional: Change text alignment
                        "-fx-border-color: black; " +
                        "-fx-border-width: 1px; "
        );
        studentStatusColumn.setStyle(
                "-fx-font-size: 16px; " + // Adjust font size as needed
                        "-fx-font-weight: bold; " +
                       // Optional: Change text color
                        "-fx-alignment: center; "+ // Optional: Change text alignment
                       "-fx-border-color: black; " +
                        "-fx-border-width: 1px; "
        );

        students.setItems(observableStudentList);
        System.out.println("students:"+observableStudentList);


        presidentColumnName.setCellValueFactory(new PropertyValueFactory<Candidate, String>("name"));
        presidentColumnParty.setCellValueFactory(new PropertyValueFactory<Candidate, String>("party"));
        presidentColumnCourse.setCellValueFactory(new PropertyValueFactory<Candidate, String>("course"));

        presidentCandidatesObservable = FXCollections.observableArrayList(presidentCandidatesList);
        presidentCandidates.setItems(presidentCandidatesObservable);
        System.out.println("presidents:"+presidentCandidatesObservable);


        vicePresidentColumnName.setCellValueFactory(new PropertyValueFactory<Candidate, String>("name"));
        vicePresidentColumnParty.setCellValueFactory(new PropertyValueFactory<Candidate, String>("party"));
        vicePresidentColumnCourse.setCellValueFactory(new PropertyValueFactory<Candidate, String>("course"));

        vicePresidentCandidatesObservable = FXCollections.observableArrayList(vicePresidentCandidatesList);
        vicePresidentCandidates.setItems(vicePresidentCandidatesObservable);
        System.out.println("vice:"+vicePresidentCandidatesObservable);

        secretaryColumnName.setCellValueFactory(new PropertyValueFactory<Candidate, String>("name"));
        secretaryColumnParty.setCellValueFactory(new PropertyValueFactory<Candidate, String>("party"));
        secretaryColumnCourse.setCellValueFactory(new PropertyValueFactory<Candidate, String>("course"));

        secretaryCandidatesObservable = FXCollections.observableArrayList(secretaryCandidatesList);
        secretaryCandidates.setItems(secretaryCandidatesObservable);
        System.out.println("secretary:"+secretaryCandidatesObservable);

        treasurerColumnName.setCellValueFactory(new PropertyValueFactory<Candidate, String>("name"));
        treasurerColumnParty.setCellValueFactory(new PropertyValueFactory<Candidate, String>("party"));
        treasurerColumnCourse.setCellValueFactory(new PropertyValueFactory<Candidate, String>("course"));

        treasurerCandidatesObservable = FXCollections.observableArrayList(treasurerCandidatesList);
        treasurerCandidates.setItems(treasurerCandidatesObservable);
        System.out.println("treasurer:"+treasurerCandidatesObservable);

        PIOColumnName.setCellValueFactory(new PropertyValueFactory<Candidate, String>("name"));
        PIOColumnParty.setCellValueFactory(new PropertyValueFactory<Candidate, String>("party"));
        PIOColumnCourse.setCellValueFactory(new PropertyValueFactory<Candidate, String>("course"));

        PIOCandidatesObservable = FXCollections.observableArrayList(PIOCandidatesList);
        PIOCandidates.setItems(PIOCandidatesObservable);
        System.out.println("PIO:"+PIOCandidatesObservable);

        auditorColumnName.setCellValueFactory(new PropertyValueFactory<Candidate, String>("name"));
        auditorColumnParty.setCellValueFactory(new PropertyValueFactory<Candidate, String>("party"));
        auditorColumnCourse.setCellValueFactory(new PropertyValueFactory<Candidate, String>("course"));

        auditorCandidatesObservable = FXCollections.observableArrayList(auditorCandidatesList);
        auditorCandidates.setItems(auditorCandidatesObservable);
        System.out.println("Auditor:"+auditorCandidatesObservable);

        presidentColumnName.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        presidentColumnParty.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        presidentColumnCourse.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });

        vicePresidentColumnName.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        vicePresidentColumnParty.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        vicePresidentColumnCourse.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });

        secretaryColumnName.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        secretaryColumnParty.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        secretaryColumnCourse.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });

        treasurerColumnName.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        treasurerColumnParty.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        treasurerColumnCourse.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });

        PIOColumnName.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        PIOColumnParty.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        PIOColumnCourse.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });

        auditorColumnName.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        auditorColumnParty.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });
        auditorColumnCourse.setCellFactory(column -> {
            return new TableCell<>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle(""); // Clear the cell style
                    } else {
                        setText(item);
                        setStyle("-fx-background-color: radial-gradient(center 10% 10%, radius 100%, rgba(53, 64, 142, 1) 9%, rgba(53, 64, 128, 1) 66%, rgba(80, 65, 6, 0.7) 94%); " +
                                "-fx-font-size: 14px; " +
                                "-fx-font-weight: bold; " +
                                "-fx-font-family: 'Arial'; " +
                                "-fx-text-fill: white; " +
                                "-fx-alignment: center;");
                    }
                }
            };
        });

    }

    @FXML
    private BarChart chartPresident;
    @FXML
    private BarChart chartVicePresident;
    @FXML
    private BarChart chartSecretary;
    @FXML
    private BarChart chartTreasurer;
    @FXML
    private BarChart chartPIO;
    @FXML
    private BarChart chartAuditor;


    private void updateCandidatesChart() {
        XYChart.Series<String, Integer> presidentCandidates = new XYChart.Series<>();
        presidentCandidates.setName("President Candidates");

        for (Candidate candidate : AdminSideController.presidentCandidatesList) {
            String label = candidate.getName() + "\n"+candidate.getParty()+ "\n"+candidate.getCourse();
            presidentCandidates.getData().add(new XYChart.Data<>(label, candidate.voteCount));
        }

        XYChart.Series<String, Integer> vicePresidentCandidates = new XYChart.Series<>();
        vicePresidentCandidates.setName("Vice President Candidates");

        for (Candidate candidate : AdminSideController.vicePresidentCandidatesList) {
            String label = candidate.getName() + "\n"+candidate.getParty()+ "\n"+candidate.getCourse();
            vicePresidentCandidates.getData().add(new XYChart.Data<>(label, candidate.voteCount));
        }

        XYChart.Series<String, Integer> secretaryCandidates = new XYChart.Series<>();
        secretaryCandidates.setName("Secretary Candidates");

        for (Candidate candidate : AdminSideController.secretaryCandidatesList) {
            String label = candidate.getName() + "\n"+candidate.getParty()+ "\n"+candidate.getCourse();
            secretaryCandidates.getData().add(new XYChart.Data<>(label, candidate.voteCount));
        }

        XYChart.Series<String, Integer> treasurerCandidates = new XYChart.Series<>();
        treasurerCandidates.setName("Treasurer Candidates");

        for (Candidate candidate : AdminSideController.treasurerCandidatesList) {
            String label = candidate.getName() + "\n"+candidate.getParty()+ "\n"+candidate.getCourse();
            treasurerCandidates.getData().add(new XYChart.Data<>(label, candidate.voteCount));
        }

        XYChart.Series<String, Integer> PIOCandidates = new XYChart.Series<>();
        PIOCandidates.setName("Public Information Officer Candidates");

        for (Candidate candidate : AdminSideController.PIOCandidatesList) {
            String label = candidate.getName() + "\n"+candidate.getParty()+ "\n"+candidate.getCourse();
            PIOCandidates.getData().add(new XYChart.Data<>(label, candidate.voteCount));
        }

        XYChart.Series<String, Integer> auditorCandidates = new XYChart.Series<>();
        auditorCandidates.setName("Chief Auditor Candidates");

        for (Candidate candidate : AdminSideController.auditorCandidatesList) {
            String label = candidate.getName() + "\n"+candidate.getParty()+ "\n"+candidate.getCourse();
            auditorCandidates.getData().add(new XYChart.Data<>(label, candidate.voteCount));
        }

        chartPresident.getData().setAll(presidentCandidates);
        chartVicePresident.getData().setAll(vicePresidentCandidates);
        chartSecretary.getData().setAll(secretaryCandidates);
        chartTreasurer.getData().setAll(treasurerCandidates);
        chartPIO.getData().setAll(PIOCandidates);
        chartAuditor.getData().setAll(auditorCandidates);

        NumberAxis yAxisPresident = (NumberAxis) chartPresident.getYAxis();
        yAxisPresident.setTickUnit(1);
        yAxisPresident.setAutoRanging(false);
        yAxisPresident.setLowerBound(0);
        yAxisPresident.setUpperBound(10);

        NumberAxis yAxisVicePresident = (NumberAxis) chartVicePresident.getYAxis();
        yAxisVicePresident.setTickUnit(1);
        yAxisVicePresident.setAutoRanging(false);
        yAxisVicePresident.setLowerBound(0);
        yAxisVicePresident.setUpperBound(10);

        NumberAxis yAxisSecretary = (NumberAxis) chartSecretary.getYAxis();
        yAxisSecretary.setTickUnit(1);
        yAxisSecretary.setAutoRanging(false);
        yAxisSecretary.setLowerBound(0);
        yAxisSecretary.setUpperBound(10);

        NumberAxis yAxisTreasurer = (NumberAxis) chartTreasurer.getYAxis();
        yAxisTreasurer.setTickUnit(1);
        yAxisTreasurer.setAutoRanging(false);
        yAxisTreasurer.setLowerBound(0);
        yAxisTreasurer.setUpperBound(10);

        NumberAxis yAxisPIO= (NumberAxis) chartPIO.getYAxis();
        yAxisPIO.setTickUnit(1);
        yAxisPIO.setAutoRanging(false);
        yAxisPIO.setLowerBound(0);
        yAxisPIO.setUpperBound(10);

        NumberAxis yAxisAuditor = (NumberAxis) chartAuditor.getYAxis();
        yAxisAuditor.setTickUnit(1);
        yAxisAuditor.setAutoRanging(false);
        yAxisAuditor.setLowerBound(0);
        yAxisAuditor.setUpperBound(10);
    }

    @FXML
    private Pane ballotPane;
    @FXML
    private Pane tallyPane;
    @FXML
    private Pane votersPane;

    @FXML
    private void showBallotPane(MouseEvent event){
        ballotPane.setVisible(true);
        tallyPane.setVisible(false);
        votersPane.setVisible(false);
    }
    @FXML
    private void showTallyPane(MouseEvent event){
        tallyPane.setVisible(true);
        ballotPane.setVisible(false);
        votersPane.setVisible(false);
    }
    @FXML
    private void showVotersPane(MouseEvent event){
        votersPane.setVisible(true);
        tallyPane.setVisible(false);
        ballotPane.setVisible(false);
    }

    @FXML
    private VBox presidentTally;
    @FXML
    private VBox vicePresidentTally;
    @FXML
    private VBox secretaryTally;
    @FXML
    private VBox treasurerTally;
    @FXML
    private VBox PIOTally;
    @FXML
    private VBox auditorTally;

    @FXML
    private void showPresidentTally(MouseEvent event){
        presidentTally.setVisible(true);
        vicePresidentTally.setVisible(false);
        secretaryTally.setVisible(false);
        treasurerTally.setVisible(false);
        PIOTally.setVisible(false);
        auditorTally.setVisible(false);
    }
    @FXML
    private void showVicePresidentTally(MouseEvent event){
        vicePresidentTally.setVisible(true);
        presidentTally.setVisible(false);
        secretaryTally.setVisible(false);
        treasurerTally.setVisible(false);
        PIOTally.setVisible(false);
        auditorTally.setVisible(false);
    }
    @FXML
    private void showSecretaryTally(MouseEvent event){
        secretaryTally.setVisible(true);
        vicePresidentTally.setVisible(false);
        presidentTally.setVisible(false);
        treasurerTally.setVisible(false);
        PIOTally.setVisible(false);
        auditorTally.setVisible(false);
    }
    @FXML
    private void showTreasurerTally(MouseEvent event){
        treasurerTally.setVisible(true);
        secretaryTally.setVisible(false);
        vicePresidentTally.setVisible(false);
        presidentTally.setVisible(false);
        PIOTally.setVisible(false);
        auditorTally.setVisible(false);
    }
    @FXML
    private void showPIOTally(MouseEvent event){
        PIOTally.setVisible(true);
        treasurerTally.setVisible(false);
        secretaryTally.setVisible(false);
        vicePresidentTally.setVisible(false);
        presidentTally.setVisible(false);
        auditorTally.setVisible(false);
    }
    @FXML
    private void showAuditorTally(MouseEvent event){
        auditorTally.setVisible(true);
        PIOTally.setVisible(false);
        treasurerTally.setVisible(false);
        secretaryTally.setVisible(false);
        vicePresidentTally.setVisible(false);
        presidentTally.setVisible(false);
    }

    @FXML
    public DatePicker pckrStart;
    @FXML
    public DatePicker pckrEnd;
    @FXML
    public CheckBox chckbxAgree;
    @FXML
    public VBox paneElectionDetails;
    @FXML
    public void showElectionDetails(){
        paneElectionDetails.setVisible(true);
    }
    @FXML
    public void saveElectionDetails() {
        if (chckbxAgree.isSelected()) {
            LocalDate startDate = pckrStart.getValue();
            LocalDate endDate = pckrEnd.getValue();

            // Check if start date and end date are valid
            if (startDate != null && endDate != null && !startDate.isAfter(endDate)) {
                HelloApplication.electionController.electionStartDate = startDate;
                HelloApplication.electionController.electionEndDate = endDate;

                // Save the election details to a text file
                saveElectionDetailsToFile(startDate, endDate);

                showAlert("Details Saved", "Election details have been saved to a text file.");
                paneElectionDetails.setVisible(false);
            } else {
                showAlert("Invalid Dates", "Please select valid start and end dates.");
            }
        } else {
            showAlert("Agreement Required", "You must agree to the terms before saving.");
        }
    }

    private void saveElectionDetailsToFile(LocalDate startDate, LocalDate endDate) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/neodavid/IdeaProjects/NUVote/src/main/java/com/example/nuvote/election_details.txt"))) {
            writer.write("Election Start Date: " + startDate);
            writer.newLine();
            writer.write("Election End Date: " + endDate);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error Saving Details", "An error occurred while saving the election details.");
        }
    }

    public static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void loadElectionDetails(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read the election details from the file
            String startDateStr = reader.readLine();
            String endDateStr = reader.readLine();

            if (startDateStr != null && endDateStr != null) {
                LocalDate electionStartDate = parseDate(startDateStr);
                LocalDate electionEndDate = parseDate(endDateStr);

                if (electionStartDate != null && electionEndDate != null) {
                    // Update your application's election start and end dates
                    HelloApplication.electionController.electionStartDate = electionStartDate;
                    HelloApplication.electionController.electionEndDate = electionEndDate;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load election details.");
        }
    }
    private static LocalDate parseDate(String dateStr) {
        String[] parts = dateStr.split(": ");
        if (parts.length == 2) {
            String dateString = parts[1];
            return LocalDate.parse(dateString);
        }
        return null; // Return null if the format is not as expected
    }





}
