package org.example;

public class Studente {
    private String name;
    private Tesi thesis;

    public Studente(String name, Tesi thesis){
        this.name = name;
        this.thesis = thesis;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThesis(Tesi thesis) {
        this.thesis = thesis;
    }

    public String getName(){
        return name;
    }

    public Tesi getThesis() {
        return thesis;
    }
}
