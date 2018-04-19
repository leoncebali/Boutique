/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.rajkat.boutique.api.services;

import java.util.List;
import javax.ejb.Remote;
import tg.rajkat.boutique.api.entities.Categorie;

/**
 *
 * @author rajkat
 */
@Remote
public interface CategorieServiceBeanRemote {
    
    /**
     * Créer une nouvelle occurrence dans la base
     * @param categ
     * @throws java.lang.Exception
     */
    public void ajouter(final Categorie categ) throws Exception;

    /**
     * Met à jour une occurrence dans la base
     * @param categ to update
     * @throws java.lang.Exception
     */
    public void modifier(final Categorie categ) throws Exception;
    
    /**
     * Supprime une occurrence dans la base
     * @param categ to delete
     * @throws java.lang.Exception
     */
    public void supprimer(final Categorie categ) throws Exception;
    
    /**
     * Supprime une occurrence dans la base a partir d'un identifiant
     * @param id to delete
     * @throws java.lang.Exception
     */
    public void supprimer(long id) throws Exception;
            
    /**
     * Retrouve une entité par son identifiant
     * @param id of the entity to find
     * @return une entite
     * @throws java.lang.Exception
     */
    public Categorie recuperer(long id) throws Exception;
    
    /**
     * Retrouve une entité par son identifiant
     * @return un nombre
     * @throws java.lang.Exception
     */
    public long compter() throws Exception;

    /**
     * Trouve une liste d'entités 
     * @return List un resultat de liste
     * @throws java.lang.Exception
     */
    public List<Categorie> lister() throws Exception;

    /**
     * Trouve une liste d'entités
     * @param proprieteTri
     * @param triAsc
     * @return the result list
     * @throws java.lang.Exception
     */
    public List<Categorie> lister(final String proprieteTri, final boolean triAsc) throws Exception;

    /**
     * Trouve une liste d'entités
     * @param debut
     * @param taille
     * @param proprieteTri
     * @param triAsc
     * @return the result list
     * @throws java.lang.Exception
     */
    public List<Categorie> lister(final int debut, final int taille, final String proprieteTri, final boolean triAsc) throws Exception;

}
