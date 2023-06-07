package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

    public static List<Note> getNotes() {

        List<Note> notes = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/agozzino3u_tpBonus", "agozzino3u_appli", "32222926");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select matiere, valeur, eleveid from tnot");


            while (rs.next()) {
                notes.add(new Note(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return notes;
    }


    public static List<Note> getNotesByEleve(Eleve eleve) {

        List<Note> notes = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/agozzino3u_tpBonus", "agozzino3u_appli", "32222926");

            PreparedStatement st = con.prepareStatement("select matiere, valeur, eleveid from tnot where eleveid = ?");
            st.setString(1, eleve.getId());

            ResultSet rs = st.executeQuery(st.toString());

            while (rs.next()) {
                notes.add(new Note(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return notes;
    }


    public static void ajouterNote(Note note, Eleve eleve){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/agozzino3u_tpBonus", "agozzino3u_appli", "32222926");

            PreparedStatement statement = con.prepareStatement("INSERT INTO tnot(matiere, valeur, eleveid) VALUES(?, ?, ?);");
            statement.setString(1, note.getMatiere());
            statement.setString(2, note.getNote());
            statement.setString(3, eleve.getId());

            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
