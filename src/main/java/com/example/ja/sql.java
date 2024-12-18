package com.example.ja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sql {
    public static void query() {
        // Pas je database-naam en wachtwoord hier aan
        String url = "jdbc:mysql://localhost:3306/mijn_database";
        String username = "root";
        String wachtwoord = "SkiMaskDog";

        try (Connection connection = DriverManager.getConnection(url, username, wachtwoord)) {
            System.out.println("✅ Verbonden met de database!");
        } catch (SQLException e) {
            System.out.println("❌ Fout bij verbinden met de database!");
            e.printStackTrace(); // Dit toont waar de fout zich voordoet
        }
    }

    public static void main(String[] args) {
        query(); // Roep de functie aan
    }
}



//
//
//
//
//
// package com.example.ja;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

//public class sql {
  //  public static void query()
   // {
    //    String url = "jdbc:mysql://localhost:3306/MySQL80";
        //String username = "root";
       // String wachtwoord = "SkiMaskDog";

       // try (Connection connection = DriverManager.getConnection(url, username, wachtwoord)) {
          //  System.out.println("verbinding");
       // } catch (SQLException e) {
            //e.printStackTrace();
       // }
    //}
//}
//