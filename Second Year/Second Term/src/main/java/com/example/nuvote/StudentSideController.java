package com.example.nuvote;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentSideController implements Initializable {

    @FXML
    private Label lblAdmin;

    @FXML
    private FlowPane presidentFlowPane;
    @FXML
    private FlowPane vicePresidentFlowPane;
    @FXML
    private FlowPane secretaryFlowPane;
    @FXML
    private FlowPane PIOFlowPane;
    @FXML
    private FlowPane treasurerFlowPane;
    @FXML
    private FlowPane auditorFlowPane;

    @FXML
    private VBox vBoxLayout;

    @FXML
    private Label lblName;

    @FXML
    private Label lblParty;

    @FXML
    private Label lblCourse;

    @FXML
    private Button btnSelectCandidate;
    public static Label lblStudentNumber = new Label();
    @FXML
    private VBox containerStudentNum;



    private String selectedCandidate;

    private void createCandidateLayouts() {
        presidentFlowPane.getChildren().clear();
        vicePresidentFlowPane.getChildren().clear();
        secretaryFlowPane.getChildren().clear();
        treasurerFlowPane.getChildren().clear();
        PIOFlowPane.getChildren().clear();
        auditorFlowPane.getChildren().clear();

        for (Candidate candidate : HelloApplication.candidateList.getCandidates()) {
            VBox vBoxLayout = new VBox();
            vBoxLayout.setSpacing(10);

            Label lblName = new Label(candidate.getName());
            Label lblParty = new Label(candidate.getParty());
            Label lblCourse = new Label(candidate.getCourse());
            Button btnSelectCandidate = new Button("Select " + candidate.getName());

            VBox.setMargin(lblName, new Insets(0, 0, 5, 0));
            VBox.setMargin(lblParty, new Insets(0, 0, 5, 0));
            VBox.setMargin(lblCourse, new Insets(0, 0, 5, 0));
            VBox.setMargin(btnSelectCandidate, new Insets(0, 0, 5, 0));

            // Set up the event handler for the btnSelectCandidate button
            btnSelectCandidate.setOnAction(event -> handleSelectCandidate(event));
            vBoxLayout.setAlignment(Pos.CENTER);
            vBoxLayout.setMinWidth(162);
            vBoxLayout.setMinHeight(224);
            vBoxLayout.setStyle("-fx-background-color: linear-gradient(to bottom right, rgba(255, 212, 28, 1) 66%, rgba(255, 255, 255, 1) 94%); " +
                    "-fx-border-color: white; " +
                    "-fx-border-width: 2; " +
                    "-fx-border-radius: 4; " +
                    "-fx-background-radius: 8;");

            lblName.setAlignment(Pos.TOP_LEFT);
            lblName.setMinHeight(30);
            lblName.setMinWidth(140);
            lblName.setStyle("-fx-background-color: #35408E; " +
                    "-fx-border-color: white; " +
                    "-fx-border-width: 2; " +
                    "-fx-max-width: 140; " +
                    "-fx-min-height: 30; " +
                    "-fx-alignment: center;");
            lblName.setTextFill(javafx.scene.paint.Color.WHITE);

            // Set the font for the Label
            lblName.setFont(Font.font("Arial Bold", 13.0));

            lblParty.setAlignment(Pos.TOP_LEFT);
            lblParty.setMinHeight(30);
            lblParty.setMinWidth(140);
            lblParty.setStyle("-fx-background-color: #35408E; " +
                    "-fx-border-color: white; " +
                    "-fx-border-width: 2; " +
                    "-fx-max-width: 140; " +
                    "-fx-min-height: 30; " +
                    "-fx-alignment: center;");
            lblParty.setTextFill(javafx.scene.paint.Color.WHITE);

            // Set the font for the Label
            lblParty.setFont(Font.font("Arial Bold", 13.0));

            lblCourse.setAlignment(Pos.TOP_LEFT);
            lblCourse.setMinHeight(30);
            lblCourse.setMinWidth(140);
            lblCourse.setStyle("-fx-background-color: #35408E; " +
                    "-fx-border-color: white; " +
                    "-fx-border-width: 2; " +
                    "-fx-max-width: 140; " +
                    "-fx-min-height: 30; " +
                    "-fx-alignment: center;");
            lblCourse.setTextFill(javafx.scene.paint.Color.WHITE);

            // Set the font for the Label
            lblParty.setFont(Font.font("Arial Bold", 13.0));

            btnSelectCandidate.setStyle("-fx-background-color: white; -fx-border-color: #35408E; -fx-border-width: 1; -fx-background-radius: 9; -fx-border-radius: 5; -fx-text-fill: #35408E;");

            vBoxLayout.getChildren().addAll(lblName, lblParty, lblCourse, btnSelectCandidate);

            if ("President".equals(candidate.getPosition())) {
                presidentFlowPane.getChildren().add(vBoxLayout);
            } else if ("Vice President".equals(candidate.getPosition())) {
                vicePresidentFlowPane.getChildren().add(vBoxLayout);
            } else if ("Secretary".equals(candidate.getPosition())) {
                secretaryFlowPane.getChildren().add(vBoxLayout);
            } else if ("Treasurer".equals(candidate.getPosition())) {
                treasurerFlowPane.getChildren().add(vBoxLayout);
            } else if ("PIO".equals(candidate.getPosition())) {
                PIOFlowPane.getChildren().add(vBoxLayout);
            } else if ("Auditor".equals(candidate.getPosition())) {
                auditorFlowPane.getChildren().add(vBoxLayout);
            }
        }
    }
    public static Student currentStudent;


    @FXML
    private void handleSelectCandidate(ActionEvent event) {
        if (HelloApplication.electionController.isElectionDate()){
            if (event.getSource() instanceof Button) {
                Button clickedButton = (Button) event.getSource();
                String buttonText = clickedButton.getText();

                // Extract the candidate's name from the button's text
                String candidateName = buttonText.replace("Select ", "");

                // Find the corresponding Candidate object based on the candidate's name
                Candidate selectedCandidate = findCandidateByName(candidateName);

                if (selectedCandidate != null) {
                    // Now you have the selected candidate (selectedCandidate)
                    // You can work with it, e.g., update voteCount or do other operations
                    selectedCandidate.voteCount++;
                    System.out.println(selectedCandidate.voteCount);
                    System.out.println(currentStudent.getStudentNumber());
                    currentStudent.setStatus("Already Voted");
                    System.out.println(currentStudent.getStatus());
                    //AdminSideController.updateStudentTable();
                    updateCandidatesChart();

                    // Find the corresponding FlowPane based on the selected candidate's position
                    FlowPane targetFlowPane = findFlowPaneByPosition(selectedCandidate.getPosition());
                    HelloApplication.candidateList.saveToFile("candidates.txt");
                    HelloApplication.studentList.saveStudentListToFile("/Users/neodavid/IdeaProjects/NUVote/src/main/java/com/example/nuvote/studentList.txt");

                    // Disable all buttons in the target FlowPane
                    disableButtonsInFlowPane(targetFlowPane);
                }
            }
        } else {
            AdminSideController.showAlert("Election Not Started", "Election has not started yet.");
        }

    }

    private FlowPane findFlowPaneByPosition(String position) {
        if ("President".equals(position)) {
            currentStudent.votedPresident = true;
            return presidentFlowPane;
        } else if ("Vice President".equals(position)) {
            currentStudent.votedVicePresident = true;
            return vicePresidentFlowPane;
        } else if ("Secretary".equals(position)) {
            currentStudent.votedSecretary = true;
            return secretaryFlowPane;
        } else if ("Treasurer".equals(position)) {
            currentStudent.votedTreasurer = true;
            return treasurerFlowPane;
        } else if ("PIO".equals(position)) {
            currentStudent.votedPIO = true;
            return PIOFlowPane;
        } else if ("Auditor".equals(position)) {
            currentStudent.votedAuditor = true;
            return auditorFlowPane;
        }
        return null;
    }

    private void disableButtonsInFlowPane(FlowPane flowPane) {
        if (flowPane != null) {
            flowPane.getChildren().forEach(node -> {
                if (node instanceof VBox) {
                    ((VBox) node).getChildren().forEach(innerNode -> {
                        if (innerNode instanceof Button) {
                            ((Button) innerNode).setDisable(true);
                        }
                    });
                }
            });
        }
    }


    private Candidate findCandidateByName(String candidateName) {
        // Iterate through your candidates and find the one with the matching name
        for (Candidate candidate : HelloApplication.candidateList.getCandidates()) {
            if (candidateName.equals(candidate.getName())) {
                return candidate;
            }
        }

        // If no matching candidate is found, return null or handle the case as needed
        return null;
    }
    public void disableVotedPanes(){
        System.out.println("Current student in disable: "+currentStudent);
        if (currentStudent.votedPresident == true){
            disableButtonsInFlowPane(presidentFlowPane);
        }
        if(currentStudent.votedVicePresident == true) {
            disableButtonsInFlowPane(vicePresidentFlowPane);
        }
        if(currentStudent.votedSecretary == true) {
            disableButtonsInFlowPane(secretaryFlowPane);
        }
        if(currentStudent.votedTreasurer == true) {
            disableButtonsInFlowPane(treasurerFlowPane);
        }
        if(currentStudent.votedPIO == true) {
            disableButtonsInFlowPane(PIOFlowPane);
        }
        if(currentStudent.votedAuditor == true) {
            disableButtonsInFlowPane(auditorFlowPane);
        }
    }
    @FXML
    private VBox presidentVBox;
    public void showPresident(MouseEvent event ){
        System.out.println("stud after log in: "+currentStudent.getEmail());
        presidentVBox.setVisible(true);
        vicePresidentVBox.setVisible(false);
        secretaryVBox.setVisible(false);
        treasurerVBox.setVisible(false);
        PIOVBox.setVisible(false);
        auditorVBox.setVisible(false);
        System.out.println("Voted President: "+currentStudent.votedPresident);
        System.out.println("Voted Vice President: "+currentStudent.votedVicePresident);

        disableVotedPanes();
    }
    @FXML
    private VBox vicePresidentVBox;
    public void showVicePresident(MouseEvent event ){
        vicePresidentVBox.setVisible(true);
        presidentVBox.setVisible(false);
        secretaryVBox.setVisible(false);
        treasurerVBox.setVisible(false);
        PIOVBox.setVisible(false);
        System.out.println("Voted President: "+currentStudent.votedPresident);
        System.out.println("Voted Vice President: "+currentStudent.votedVicePresident);
        auditorVBox.setVisible(false);
        disableVotedPanes();

    }
    @FXML
    private VBox secretaryVBox;
    public void showSecretary(MouseEvent event ){
        secretaryVBox.setVisible(true);
        presidentVBox.setVisible(false);
        vicePresidentVBox.setVisible(false);
        treasurerVBox.setVisible(false);
        PIOVBox.setVisible(false);
        auditorVBox.setVisible(false);
    }
    @FXML
    private VBox treasurerVBox;
    public void showTreasurer(MouseEvent event ){
        treasurerVBox.setVisible(true);
        secretaryVBox.setVisible(false);
        presidentVBox.setVisible(false);
        vicePresidentVBox.setVisible(false);
        PIOVBox.setVisible(false);
        auditorVBox.setVisible(false);
    }
    @FXML
    private VBox PIOVBox;
    public void showPIO(MouseEvent event ){
        PIOVBox.setVisible(true);
        treasurerVBox.setVisible(false);
        secretaryVBox.setVisible(false);
        presidentVBox.setVisible(false);
        vicePresidentVBox.setVisible(false);
        auditorVBox.setVisible(false);
    }
    @FXML
    private VBox auditorVBox;
    public void showAuditor(MouseEvent event ){
        auditorVBox.setVisible(true);
        PIOVBox.setVisible(false);
        treasurerVBox.setVisible(false);
        secretaryVBox.setVisible(false);
        presidentVBox.setVisible(false);
        vicePresidentVBox.setVisible(false);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createCandidateLayouts();
        containerStudentNum.getChildren().add(lblStudentNumber);

        updateCandidatesChart();
        if (HelloApplication.electionController.isElectionDate()){

        } else {
            AdminSideController.showAlert("Election Not Started", "Election has not started yet.");
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/Users/neodavid/IdeaProjects/NUVote/src/main/resources/com/example/nuvote/landing-page.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage)(containerStudentNum.getScene().getWindow());
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
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
    private void showBallotPane(MouseEvent event){
        ballotPane.setVisible(true);
        tallyPane.setVisible(false);
    }
    @FXML
    private void showTallyPane(MouseEvent event){
        tallyPane.setVisible(true);
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
    private Button popLogOut;
    @FXML
    private boolean isLogOutShow = false;
    @FXML
    private void showLogOut(MouseEvent event){
        System.out.println("Student  side!");
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
    private void logOut(ActionEvent event) throws IOException {
        System.out.println("Logging out!");
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
