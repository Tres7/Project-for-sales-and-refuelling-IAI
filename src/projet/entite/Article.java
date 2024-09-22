/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.entite;

import java.sql.Date;

/**
 *
 * @author kpogl
 */
public class Article {
    private int id;
    private String Code;
    private String Libelle;
    private int Prix;
    private int Quantite;
    private Date date;

    public Article() {
    }

    public Article(int id,String Code, String Libelle, int Prix, int Quantite, Date date) {
        this.id=id;
        this.Code = Code;
        this.Libelle = Libelle;
        this.Prix = Prix;
        this.Quantite = Quantite;
        this.date = date;
    }

    public int getId() {
        return id;
    }
    
    

    public String getCode() {
        return Code;
    }

    public String getLibelle() {
        return Libelle;
    }

    public int getPrix() {
        return Prix;
    }

    public int getQuantite() {
        return Quantite;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public void setCode(String Code) {
        this.Code = Code;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }

    public void setQuantite(int Quantite) {
        this.Quantite = Quantite;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
