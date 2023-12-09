package com.example.nuvote;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LandingPageController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField fldRegisterStudentNum;

    @FXML
    private TextField fldRegisterEmail;

    @FXML
    private TextField fldRegisterPassword;

    @FXML
    private Button btnRegister;

    @FXML
    private TextField fldLogInStudentNum;
    @FXML
    private TextField fldLogInPassword;
    @FXML
    private VBox paneVerifyPopUp;
    @FXML
    private TextField fldCode1;
    @FXML
    private TextField fldCode2;
    @FXML
    private TextField fldCode3;
    @FXML
    private TextField fldCode4;
    @FXML
    private TextField fldCode5;
    @FXML
    private TextField fldCode6;



    StudentInfoMap studentInfoMap = new StudentInfoMap();
   // StudentList studentList = new StudentList();




    public void switchToRegistration (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("/registration.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToLandingPage (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAdmin (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin-login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void registerStudent() {
        String enteredStudentNum = fldRegisterStudentNum.getText();
        String enteredEmail = fldRegisterEmail.getText();
        String enteredPassword = fldRegisterPassword.getText();

        if (enteredStudentNum.isEmpty() || enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
            // Show an error popup for empty fields
            showEmptyFieldAlert();
            return;
        }

        if (studentInfoMap.containsStudentNumber(enteredStudentNum)) {
            if (studentInfoMap.isEmailMatching(enteredStudentNum, enteredEmail)) {
                if (!HelloApplication.studentList.isStudentRegistered(enteredStudentNum)) {
                    Student student = new Student(enteredStudentNum, enteredEmail, enteredPassword);
                    HelloApplication.studentList.registerStudent(student);
                    HelloApplication.studentList.saveStudentListToFile("/Users/neodavid/IdeaProjects/NUVote/src/main/java/com/example/nuvote/studentList.txt");
                    paneVerifyPopUp.setVisible(true);
                    registerUser(enteredEmail);
                } else {
                    // Show an error popup for already registered student
                    showStudentAlreadyRegisteredAlert();
                }
            } else {
                // Show an error popup for email not matching
                showEmailNotMatchingAlert();
            }
        } else {
            // Show an error popup for student number not found
            showStudentNumberNotFoundAlert();
        }
    }

    @FXML
    public void logInStudent(ActionEvent event) throws IOException {
        String enteredLogInStudNum = fldLogInStudentNum.getText();
        String enteredLogInPassword = fldLogInPassword.getText();

        System.out.println(fldLogInStudentNum.getText());
        System.out.println(fldLogInPassword.getText());
        System.out.println(HelloApplication.studentList);

        if (HelloApplication.studentList.isStudentRegistered(enteredLogInStudNum)) {
            System.out.println("Registered!");

            // Check if the entered password matches the stored password
            if (HelloApplication.studentList.isPasswordMatching(enteredLogInStudNum, enteredLogInPassword)) {
                Parent root = FXMLLoader.load(getClass().getResource("student-interface.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);

                HelloApplication.currentStudent = HelloApplication.studentList.getStudentByNum(enteredLogInStudNum);
                System.out.println(HelloApplication.currentStudent.getEmail());
                StudentSideController.currentStudent =  HelloApplication.currentStudent;
                StudentSideController.lblStudentNumber.setText(StudentSideController.currentStudent.getStudentNumber());

                stage.setScene(scene);
                stage.show();
            } else {
                // Password is incorrect, show an error popup
                showIncorrectPasswordAlert();
            }
        } else {
            // Student number is not registered, show an error popup
            showIncorrectStudentNumberAlert();
        }
    }
    String verificationCode;
    public void registerUser(String email) {
        // Generate a verification code
         verificationCode = VerificationCodeGenerator.generateVerificationCode();

        // Send the verification email
        String subject = "Verification Code for Registration";
        String messageText = "Your verification code is: " + verificationCode;
        EmailSender.sendEmail(email, subject, messageText);

        // Store the verification code temporarily (e.g., in a map or database) for later validation.
        HelloApplication.verificationCodeMap.put(email, verificationCode);
        System.out.println("Generated verification code: "+verificationCode);


    }
    public void verifyCode(ActionEvent event) throws IOException{
        String code1 = fldCode1.getText();
        String code2 = fldCode2.getText();
        String code3 = fldCode3.getText();
        String code4 = fldCode4.getText();
        String code5 = fldCode5.getText();
        String code6 = fldCode6.getText();

        String enteredCode = (code1 + code2 + code3+ code4 +code5+ code6);
        System.out.println("Entered code: "+enteredCode);
        System.out.println("Verification code: "+verificationCode);


        if (enteredCode.equals(verificationCode)){
            System.out.println("Code verified!");
            paneVerifyPopUp.setVisible(false);
            showAccountRegisteredAlert();
            clearFields();
            fldCode1.clear();
            fldCode2.clear();
            fldCode3.clear();
            fldCode4.clear();
            fldCode5.clear();
            fldCode6.clear();
        }   else{
            System.out.println("Code not verified!");
            showIncorrectCodeAlert();
        }
    }

    @FXML
    private TextField fldAdminUsername;
    @FXML
    private TextField fldAdminPassword;
    public void logInAdmin(ActionEvent event) throws IOException{
        String enteredAdminUsername = fldAdminUsername.getText();
        String enteredAdminPassword = fldAdminPassword.getText();
        if(enteredAdminUsername.equals("Neo") && enteredAdminPassword.equals("1234") ){
            System.out.println("Admin logged in!");
            enterAdminInterface(event);
        }

    }


    private void enterAdminInterface(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin-interface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        String css = this.getClass().getResource("/admin-interface.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.show();
    }

    private void showIncorrectCodeAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Code");
        alert.setHeaderText(null);
        alert.setContentText("The code entered is incorrect.");

        alert.showAndWait();
    }
    private void showAccountRegisteredAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Success! Account has been registered.");

// Show the pop-up and wait for the user to close it
        alert.showAndWait();
    }

    private void clearFields(){
        fldRegisterStudentNum.clear();
        fldRegisterEmail.clear();
        fldRegisterPassword.clear();

    }

    private void showIncorrectPasswordAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Password");
        alert.setHeaderText(null);
        alert.setContentText("The password entered is incorrect.");

        alert.showAndWait();
    }

    private void showIncorrectStudentNumberAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Student Number");
        alert.setHeaderText(null);
        alert.setContentText("The entered student number is not registered.");

        alert.showAndWait();
    }
    private void showEmptyFieldAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Empty Fields");
        alert.setHeaderText(null);
        alert.setContentText("Student number, email, and password cannot be empty.");

        alert.showAndWait();
    }

    private void showStudentNumberNotFoundAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Student Number Not Found");
        alert.setHeaderText(null);
        alert.setContentText("The entered student number is not found in the list.");

        alert.showAndWait();
    }

    private void showEmailNotMatchingAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Email Not Matching");
        alert.setHeaderText(null);
        alert.setContentText("The entered email does not match the student number.");

        alert.showAndWait();
    }

    private void showStudentAlreadyRegisteredAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Student Already Registered");
        alert.setHeaderText(null);
        alert.setContentText("The student with this student number has already been registered.");

        alert.showAndWait();
    }

    @FXML
    private VBox centerVBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
