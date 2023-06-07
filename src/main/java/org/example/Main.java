package org.example;

import java.sql.*;
import java.util.List;

import static org.example.NoteDAO.getNotesByEleve;

public class Main {
    public static void main(String[] args) {
      afficherEleves();
      Eleve eleve1 = new Eleve("Ago", "Anthony");
      new EleveDAO().ajouterEleve(eleve1);
      Eleve eleve2 = new Eleve("ZELL", "RENAUD");
      new EleveDAO().ajouterEleve(eleve2);
        System.out.println(eleve1.getId());

      new EleveDAO().modifierEleve(eleve1, "Viardot", "Thibault");

      afficherEleves();

      getNotesByEleve(eleve1);

    }


    public static void afficherEleves(){
        List<Eleve> eleves = new EleveDAO().getEleves();
        eleves.stream().forEach(eleve -> System.out.println(eleve.toString()));
    }
}