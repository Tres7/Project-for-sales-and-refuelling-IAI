/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJAva.dao;
import java.util.List;
/**
 *
 * @author kpogl
 */
public interface Idao <T>  {
    public abstract  boolean enregistrer(T t);
    
    public abstract boolean modifier(T m);
    
    public abstract boolean supprimer(T m);
    
    public abstract boolean rechercher(T m);
    
    //public abstract boolean approvisionner(T m);
    
    public abstract List<T> lister();
    
    public abstract int nbrIns();
}
