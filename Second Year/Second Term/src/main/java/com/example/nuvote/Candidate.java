package com.example.nuvote;

public class Candidate {
    private String name;
    private String party;

    private String course;
    private String imgSrc;
    private String position;


    public int voteCount = 0;



    public Candidate(String position, String name, String party, String course, String imgSrc){
        this.position = position;
        this.name = name;
        this.party = party;
        this.course = course;
        this.imgSrc = imgSrc;
    }

    public String toString() {
        // Include voteCount in the format
        return position + "," + name + "," + party + "," + course + "," + imgSrc + "," + voteCount;
    }

    public static Candidate fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 6) { // Make sure you have 6 parts (including voteCount)
            Candidate candidate = new Candidate(parts[0], parts[1], parts[2], parts[3], parts[4]);
            candidate.voteCount = Integer.parseInt(parts[5]); // Parse voteCount
            return candidate;
        }
        System.out.println("Error here");
        return null;
    }


    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
