package org.example;

public class Note {

    public enum Matiere {
        MATHS, ANGLAIS, PHYSIQUE, INFORMATIQUE;
    }
    private String matiere;
    private String id;
    private String note;
    private String eleveid;

    public Note(String matiere, String note, String eleveId) {
        this.matiere = matiere;
        this.note = note;
        this.eleveid = eleveId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEleveid() {
        return eleveid;
    }

    public void setEleveid(String eleveid) {
        this.eleveid = eleveid;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
}
