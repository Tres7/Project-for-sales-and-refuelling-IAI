/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kpogl
 */
public class Connexion {
    Connection cone=null;
    ResultSet Rs=null;
    PreparedStatement ps=null;
    public static Connection SeConnecter(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url="jdbc:mysql://localhost:3306/premierpas";
        String user="root";
        String mdp="";
        
        try {
            Connection cone =DriverManager.getConnection(url, user,mdp);
            //JOptionPane.showMessageDialog(null,"Connexion réussie");
            return cone;
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
}
