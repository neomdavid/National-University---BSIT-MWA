package com.example.nuvote;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.time.LocalDate;

public class ElectionControlApp extends Application {

    public LocalDate electionStartDate = LocalDate.of(2023, 11, 15); // Set your election start date
    public LocalDate electionEndDate = LocalDate.of(2023, 11, 20);   // Set your election end date

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Election Control App");
        primaryStage.setScene(scene);

        // Example: Show the pop-up when a button is clicked
        showUnliPopUpElectionNotStart();

        primaryStage.show();
    }

    private void showUnliPopUpElectionNotStart() {
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isBefore(electionStartDate)) {
            showAlert("Election Not Started", "Election has not started yet.");
        } else if (currentDate.isAfter(electionEndDate)) {
            showAlert("Election Ended", "Election has already ended.");
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Election Ongoing");
            alert.setHeaderText("You have two options:");

            ButtonType logoutButton = new ButtonType("Logout");
            ButtonType adjustDateButton = new ButtonType("Adjust Election Date");

            alert.getButtonTypes().setAll(logoutButton, adjustDateButton);

            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == logoutButton) {
                    // Handle "Logout" action
                    System.out.println("Logout clicked");
                } else if (buttonType == adjustDateButton) {
                    // Handle "Adjust Election Date" action
                    System.out.println("Adjust Election Date clicked");
                }
            });
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setElectionStartDate(LocalDate startDate) {
        this.electionStartDate = startDate;
    }

    public void setElectionEndDate(LocalDate endDate) {
        this.electionEndDate = endDate;
    }
    public boolean isElectionDate() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isEqual(electionStartDate) || (currentDate.isAfter(electionStartDate) && currentDate.isBefore(electionEndDate));
    }

}
