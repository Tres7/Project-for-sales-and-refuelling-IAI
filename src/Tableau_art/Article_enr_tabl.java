/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tableau_art;
import java.util.List;                                                          
import javax.swing.table.DefaultTableModel;                                     
import ProjetJAva.dao.Enregistrer;           
import projet.entite.Article;
/**
 *
 * @author kpogl
 */
public class Article_enr_tabl {
    private static DefaultTableModel tableau;
    
    public static DefaultTableModel afficher_tableau() {
        
        String[] en_tete= {"id","Code","Libelle","Prix","Quantite","date"};
                                                                                
        tableau=new DefaultTableModel();                                        
        tableau.setColumnIdentifiers(en_tete);//Ajouter les en-têtes            
        List<Article> list_article= new Enregistrer().lister();        
                                                                                
        for (Article a : list_article) {                                                         
            String [] data = {String.valueOf(a.getId()),a.getCode(),a.getLibelle(),""+a.getPrix(),""+a.getQuantite(),""+a.getDate()};
            tableau.addRow(data);
            
        }
        
        return tableau;
    
    }
}
