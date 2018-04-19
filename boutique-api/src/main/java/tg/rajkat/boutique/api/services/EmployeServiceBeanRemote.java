/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.rajkat.boutique.api.services;

import java.util.List;
import javax.ejb.Remote;
import tg.rajkat.boutique.api.entities.Employe;

/**
 *
 * @author rajkat
 */
@Remote
public interface EmployeServiceBeanRemote {
    
    /**
     * Créer une nouvelle occurrence dans la base
     * @param emp to create
     * @throws java.lang.Exception
     */
    public void ajouter(final Employe emp) throws Exception;

    /**
     * Met à jour une occurrence dans la base
     * @param emp to update
     * @throws java.lang.Exception
     */
    public void modifier(final Employe emp) throws Exception;
    
    /**
     * Supprime une occurrence dans la base
     * @param emp to delete
     * @throws java.lang.Exception
     */
    public void supprimer(final Employe emp) throws Exception;
    
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
    public Employe recuperer(long id) throws Exception;
    
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
    public List<Employe> lister() throws Exception;

    /**
     * Trouve une liste d'entités
     * @param proprieteTri
     * @param triAsc
     * @return the result list
     * @throws java.lang.Exception
     */
    public List<Employe> lister(final String proprieteTri, final boolean triAsc) throws Exception;

    /**
     * Trouve une liste d'entités
     * @param debut
     * @param taille
     * @param proprieteTri
     * @param triAsc
     * @return the result list
     * @throws java.lang.Exception
     */
    public List<Employe> lister(final int debut, final int taille, final String proprieteTri, final boolean triAsc) throws Exception;

}
