/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.rajkat.boutique.api.services;

import java.util.List;
import javax.ejb.Remote;
import tg.rajkat.boutique.api.entities.Personne;

/**
 *
 * @author rajkat
 */
@Remote
public interface PersonneServiceBeanRemote {
    
    /**
     * Créer une nouvelle occurrence dans la base
     * @param personne to create
     * @throws java.lang.Exception
     */
    public void ajouter(final Personne personne) throws Exception;

    /**
     * Met à jour une occurrence dans la base
     * @param personne to update
     * @throws java.lang.Exception
     */
    public void modifier(final Personne personne) throws Exception;
    
    /**
     * Supprime une occurrence dans la base
     * @param personne to delete
     * @throws java.lang.Exception
     */
    public void supprimer(final Personne personne) throws Exception;
    
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
    public Personne recuperer(long id) throws Exception;
    
    /**
     * Retrouve une entité par son identifiant
     * @return un nombre
     * @throws java.lang.Exception
     */
    public long compter() throws Exception;

    /**
     * Trouve une liste d'entités 
     * @return List
     * @throws java.lang.Exception
     */
    public List<Personne> lister() throws Exception;

    /**
     * Trouve une liste d'entités
     * @param proprieteTri
     * @param triAsc
     * @return the result list
     * @throws java.lang.Exception
     */
    public List<Personne> lister(final String proprieteTri, final boolean triAsc) throws Exception;

    /**
     * Trouve une liste d'entités
     * @param debut
     * @param taille
     * @param proprieteTri
     * @param triAsc
     * @return the result list
     * @throws java.lang.Exception
     */
    public List<Personne> lister(final int debut, final int taille, final String proprieteTri, final boolean triAsc) throws Exception;

}
