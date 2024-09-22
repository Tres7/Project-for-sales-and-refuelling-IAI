/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJAva.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projet.Affichages;
import projet.Connexion;
import projet.entite.Article;
/**
 *
 * @author kpogl
 */
public class Enregistrer implements Idao<Article> {

    @Override
    public boolean enregistrer(Article t) {
        Connection cone= Connexion.SeConnecter();
      
      String insertion= "insert into article(Code,Libelle,Prix,Quantite,date) values(?,?,?,?,?)";
      boolean test= false;
      
        try {
            PreparedStatement ps= cone.prepareStatement(insertion);
            
            ps.setString(1,t.getCode());
            ps.setString(2,t.getLibelle());
            ps.setInt(3,t.getPrix());
            ps.setInt(4,t.getQuantite());
            ps.setDate(5, new java.sql.Date(t.getDate().getTime()) );
            ps.execute();
            test=true;
            JOptionPane.showMessageDialog(null, "ENREGISTREMENT REUSSI");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      
        return test;
    }

    @Override
    public boolean modifier(Article m) {
        Connection cone= Connexion.SeConnecter();
      
      String modif= "update article set Code=?,Libelle=?,Prix=?,Quantite=? where id=?";
      //Article Art=new Article();
      boolean test= false;
      //Article Art=new Article();
      
        try {
            PreparedStatement ps= cone.prepareStatement(modif);
            //ps.setInt(1,m.getId());
            ps.setString(1,m.getCode());
            ps.setString(2,m.getLibelle());
            ps.setInt(3,m.getPrix());
            ps.setInt(4,m.getQuantite());
            ps.setInt(5,m.getId());
            //ps.setString(5,m.getCode());
            //ps.setDate(6, m.getDate());
            ps.execute();
            test=true;
            JOptionPane.showMessageDialog(null, "LA MODIFICATION A REUSSI");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
      
        return test;  
        
    }

    @Override
    public boolean supprimer(Article m) { 
       Connection cone= Connexion.SeConnecter();
      
      String suppression= "delete from article where id=?";
      Article Art=new Article();
      boolean test= false;
      
      
        try {
            PreparedStatement ps= cone.prepareStatement(suppression);
            ps.setInt(1,m.getId());
            ps.execute();
            test=true;
            JOptionPane.showMessageDialog(null, "LA SUPPRESSION A REUSSI");JOptionPane.showMessageDialog(null, "LA SUPPRESSION A REUSSI");
            return test;
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
      
        
     //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Article> lister() {
        Connection cone= Connexion.SeConnecter();
      
      String liste= "select * from article";
      List<Article> listE = new ArrayList<Article>() ;
        ResultSet rs = null;
        try {
            Statement state= cone.createStatement();
            rs=state.executeQuery(liste);
            while (rs.next()) {
                //Affichage Af=new Affichage();
                Article Art = new Article();
                Art.setId(rs.getInt("id"));
                Art.setCode(rs.getString("Code"));
                Art.setLibelle(rs.getString("Libelle"));
                Art.setPrix(rs.getInt("Prix"));
                Art.setQuantite(rs.getInt("Quantite"));
                Art.setDate(rs.getDate("date"));
                listE.add(Art);  
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
        return listE;
        
    }

    @Override
    public boolean rechercher(Article m) {
        Connection cone= Connexion.SeConnecter();
      
      String rechercher= "select * from article where Libelle=?";
      Article Art=new Article();
      boolean test= false;
       try {
            PreparedStatement ps= cone.prepareStatement(rechercher);
            ps.setString(1,m.getLibelle());
            ps.execute();
            test=true;
            //JOptionPane.showMessageDialog(null, "LA SUPPRESSION A REUSSI");JOptionPane.showMessageDialog(null, "LA SUPPRESSION A REUSSI");
            return test;
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        
         //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public boolean approvisionner(String nom,int chiffre) throws SQLException {
        Connection cone= Connexion.SeConnecter();
        Statement st;
        ResultSet rs;
        st=cone.createStatement();
        String requete="update article set Quantite=? +(Select Quantite from article where Libelle=?) where Libelle=?";
        try{
            PreparedStatement ps=cone.prepareStatement(requete);
            ps.setInt(1, chiffre);
            ps.setString(2, nom);
            ps.setString(3, nom);
            if(chiffre>0){
                ps.execute();
            }
            return true;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean Vente(int nom,int chiffre) throws SQLException {
        Connection cone= Connexion.SeConnecter();
        Statement st;
        ResultSet rs;
        st=cone.createStatement();
        String requete="update article set Quantite=(Select Quantite from article where id=?)-? where id=?";
        try{
            PreparedStatement ps=cone.prepareStatement(requete);
            ps.setInt(1, nom);
            ps.setInt(2, chiffre);
            ps.setInt(3, nom);
            
           
            
            if(chiffre>0){
                ps.execute();
            }
            return true;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    

    @Override
    public int nbrIns() {
        return lister().size(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
