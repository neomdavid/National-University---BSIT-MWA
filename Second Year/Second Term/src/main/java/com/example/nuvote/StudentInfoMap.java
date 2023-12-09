package com.example.nuvote;

import java.util.HashMap;
import java.util.HashSet;

public class StudentInfoMap {
    HashMap<String, String> list = new HashMap<>();

    public StudentInfoMap(){
        list.put("2023-000000", "davidnm@students.national-u.edu.ph");
        list.put("2023-111300", "catapanggm@students.national-u.edu.ph");
    }
    public boolean containsStudentNumber(String studentNumber){
        return list.containsKey(studentNumber);
    }
    public boolean isEmailMatching(String studentNumber, String email){
        String storedEmail = list.get(studentNumber);
        return storedEmail != null && email.equals(storedEmail);
    }
}
