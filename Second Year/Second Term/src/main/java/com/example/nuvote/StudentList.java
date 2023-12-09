package com.example.nuvote;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentList {
    public Map<String, Student> studentList = new HashMap<>();

    public StudentList(){

    }
    public List<Student> getStudentsAsList() {
        List<Student> studentListAsList = new ArrayList<>(studentList.values());
        return studentListAsList;
    }

    public void registerStudent(Student student){
        studentList.put(student.getStudentNumber(), student);
        System.out.println("Student has been registered: "+studentList.get(student.getStudentNumber()).getStudentNumber());
        System.out.println(studentList);
    }
    public boolean isStudentRegistered(String studentNumber){
        return studentList.containsKey(studentNumber);
    }
    public void saveStudentListToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Student student : studentList.values()) {
                String line = student.getStudentNumber() + "," + student.getEmail() + "," + student.getPassword() +
                        "," + student.isVotedPresident() + "," + student.isVotedVicePresident() +
                        "," + student.isVotedSecretary() + "," + student.isVotedTreasurer() +
                        "," + student.isVotedPIO() + "," + student.isVotedAuditor() +
                        "," + student.getStatus();  // Include status
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StudentList loadStudentListFromFile(String filename) {
        StudentList studentList = new StudentList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 10) {  // Check if there are 10 elements in the line
                    Student student = new Student(parts[0], parts[1], parts[2]);
                    student.setVotedPresident(Boolean.parseBoolean(parts[3]));
                    student.setVotedVicePresident(Boolean.parseBoolean(parts[4]));
                    student.setVotedSecretary(Boolean.parseBoolean(parts[5]));
                    student.setVotedTreasurer(Boolean.parseBoolean(parts[6]));
                    student.setVotedPIO(Boolean.parseBoolean(parts[7]));
                    student.setVotedAuditor(Boolean.parseBoolean(parts[8]));
                    student.setStatus(parts[9]);  // Load status
                    studentList.studentList.put(parts[0], student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }




    public void printStudentList() {
        for (Student student : studentList.values()) {
            System.out.println("Student Number: " + student.getStudentNumber());
            System.out.println("Email: " + student.getEmail());

            System.out.println();
        }
    }
  public Student getStudentByNum(String studentNumber){
        System.out.println(studentList.get(studentNumber));
         return studentList.get(studentNumber);
  }

    public boolean isPasswordMatching(String studentNumber, String enteredPassword) {
        Student student = studentList.get(studentNumber);
        if (student != null) {
            String storedPassword = student.getPassword();
            return storedPassword.equals(enteredPassword);
        }
        return false;
    }







}
