package com.example.nuvote;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateModel {
    private List<Candidate> candidates = new ArrayList<>();

    public void addCandidate(Candidate candidate){
        candidates.add(candidate);
    }
    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void saveToFile(String filename){
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("/Users/neodavid/IdeaProjects/NUVote/src/main/java/com/example/nuvote/candidates.txt"));
            for (Candidate candidate: candidates ){
                writer.println(candidate.toString());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadFromFile(String filename){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/neodavid/IdeaProjects/NUVote/src/main/java/com/example/nuvote/candidates.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                Candidate candidate = Candidate.fromString(line);
                if (candidate !=null){
                    candidates.add(candidate);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}