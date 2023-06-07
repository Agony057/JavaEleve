package org.example;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EleveDAO {
    public List<Eleve> getEleves() {

        List<Eleve> eleves = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/agozzino3u_tpBonus", "agozzino3u_appli", "32222926");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from televe");

            while (rs.next()) {
                eleves.add(new Eleve(rs.getString(1), rs.getString(2)));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    return eleves;
    }

    public Eleve recupererId(Eleve eleve){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/agozzino3u_tpBonus", "agozzino3u_appli", "32222926");

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT MAX(id) FROM televe");

            rs.next();
            eleve.setId(rs.getString(1));

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return eleve;
    }

    public void ajouterEleve(Eleve eleve){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/agozzino3u_tpBonus", "agozzino3u_appli", "32222926");

            PreparedStatement statement = con.prepareStatement("INSERT INTO televe(nom, prenom) VALUES(?,?);");
            statement.setString(1, eleve.getNom());
            statement.setString(2, eleve.getPrenom());

            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        recupererId(eleve);
    }

    public void supprimerEleve(Eleve eleve){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/agozzino3u_tpBonus", "agozzino3u_appli", "32222926");

            PreparedStatement statement = con.prepareStatement("DELETE FROM televe WHERE id = (?)");
            statement.setString(1, eleve.getId());

            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void modifierEleve(Eleve eleve, String nom, String prenom){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/agozzino3u_tpBonus", "agozzino3u_appli", "32222926");

            PreparedStatement statement = con.prepareStatement("UPDATE televe " +
                    "SET nom = ?, prenom = ? WHERE id = ?");
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, eleve.getId());

            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Eleve> elevesAvecNotes(){
        List<Eleve> eleves = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/agozzino3u_tpBonus", "agozzino3u_appli", "32222926");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from televe join tnot t on televe.id = t.eleveid");

            while (rs.next()) {
                eleves.add(new Eleve(rs.getString(1), rs.getString(2)));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return eleves;
    }
}


