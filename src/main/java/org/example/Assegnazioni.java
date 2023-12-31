package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Assegnazioni {
    private ArrayList<Tesi> thesisList;
    private ArrayList<Studente> studList;
    public Assegnazioni(){
        thesisList = new ArrayList<Tesi>();
        studList = new ArrayList<Studente>();
    }

    public void getThesis_list(){
        if(thesisList.size() == 0) System.out.println("Nessuna tesi disponibile nel sistema");
        else System.out.printf("La lista di tesi correnti è: ");

        for(int i = 0; i< thesisList.size(); i++)
            System.out.printf("[" + thesisList.get(i).getTitle() + "] - ");
        System.out.printf("\n");
    }

    public void getStud_list(){
        if(studList.size() == 0) System.out.println("Nessuno studente presente nel sistema!");
        else System.out.printf("La lista di studenti correnti è (Nome / Titolo tesi): ");

        for(int i = 0; i< studList.size(); i++)
            System.out.printf("[" + studList.get(i).getName() + "/" + studList.get(i).getThesis().getTitle() + "] - ");
        System.out.printf("\n");
    }

    public void aggiungiTesi(String thesisTitle){
        Tesi toAdd = new Tesi(thesisTitle);
        thesisList.add(toAdd);
        getThesis_list();
    }
    public void aggiungiStudente(String nomeStudente, String titoloTesi){
        boolean isHere = false;

        for(int i = 0; i< thesisList.size(); i++){
            if(Objects.equals(titoloTesi, thesisList.get(i).getTitle())){
                Studente toAdd = new Studente(nomeStudente, thesisList.get(i));
                studList.add(toAdd);
                isHere = true;
            }
        }

        if(isHere == false) {
            aggiungiTesi(titoloTesi);
            Studente toAdd = new Studente(nomeStudente, thesisList.get(thesisList.size()-1));
            studList.add(toAdd);
        }

        getStud_list();
    }
    public void laureato(String nomeStudente){
        for(int i = 0; i< studList.size(); i++){
            if(Objects.equals(nomeStudente, studList.get(i).getName())){
                studList.remove(i);
                thesisList.remove(i);
                System.out.println();
                System.out.println("Lo studente: " + nomeStudente + " risulta essere laureato. Congratulazioni!");
                getStud_list();
                getThesis_list();
                break;
            }
        }
    }
    public void liberaTesi(String titoloTesi){
        for(int i = 0; i< thesisList.size(); i++){
            if(Objects.equals(titoloTesi, thesisList.get(i).getTitle())){
                studList.remove(i);
                break;
            }
        }
        getStud_list();
        getThesis_list();
    }
    public int disponibili(){
        int diff = thesisList.size() - studList.size();
        return diff;
    }

    public static void main1() {
        Assegnazioni prima = new Assegnazioni();
        prima.aggiungiTesi("Elaborato finale");
        prima.aggiungiStudente("Andrea", "Elaborato finale");
        prima.liberaTesi("Elaborato finale");

        int remainingThesis = prima.disponibili();
        System.out.println("Le tesi rimaste libere nel sistema sono: " + remainingThesis);
        prima.aggiungiStudente("Federico", "Elaborato finale");

        remainingThesis = prima.disponibili();
        System.out.println("Le tesi rimaste libere nel sistema sono: " + remainingThesis);

        prima.aggiungiStudente("Andrea", "Neural networks and deep learning");
        prima.liberaTesi("Neural networks and deep learning");
        remainingThesis = prima.disponibili();
        System.out.println("Le tesi rimaste libere nel sistema sono: " + remainingThesis);
        prima.aggiungiStudente("Andrea", "Neural networks and deep learning");
        remainingThesis = prima.disponibili();
        System.out.println("Le tesi rimaste libere nel sistema sono: " + remainingThesis);
        prima.laureato("Andrea");
        remainingThesis = prima.disponibili();
        System.out.println("Le tesi rimaste libere nel sistema sono: " + remainingThesis);
    }
}
