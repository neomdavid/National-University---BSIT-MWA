package com.example.nuvote;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class HelloApplication extends Application {
    public static StudentList studentList = new StudentList();
    public static Map<String, String> verificationCodeMap = new HashMap<>();
    public static CandidateModel candidateList = new CandidateModel();
    public static ArrayList<Candidate> candidates = new ArrayList<>();

    public static Student currentStudent;


    public static ElectionControlApp electionController = new ElectionControlApp();



    @Override
    public void start(Stage stage) throws IOException {
        studentList = StudentList.loadStudentListFromFile("/Users/neodavid/IdeaProjects/NUVote/src/main/java/com/example/nuvote/studentList.txt");
        candidateList.loadFromFile("/Users/neodavid/IdeaProjects/NUVote/src/main/java/com/example/nuvote/candidates.txt");
        AdminSideController.loadElectionDetails("/Users/neodavid/IdeaProjects/NUVote/src/main/java/com/example/nuvote/election_details.txt");

       /* for (Candidate candidate : c<VBox fx:id="vBoxLayout" alignment="CENTER" prefHeight="224.0" prefWidth="162.0" style="-fx-background-color: linear-gradient(to bottom right, rgba(255, 212, 28, 1) 66%, rgba(255, 255, 255, 1) 94%); -fx-border-color: white; -fx-border-width: 2; -fx-border-radius: 4; -fx-background-radius: 8;">andidates) {
            System.out.println(candidate.toString()+"bobo");
        }*/
        studentList.printStudentList();
        System.out.println(HelloApplication.candidateList.getCandidates()+"hi");
        //loadAndRecreateVBox();


        //  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("landing-page.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


   }

    public static void main(String[] args) {
        launch();
    }
}