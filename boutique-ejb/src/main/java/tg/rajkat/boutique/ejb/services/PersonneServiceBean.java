/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.rajkat.boutique.ejb.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import tg.rajkat.boutique.api.entities.Personne;
import tg.rajkat.boutique.api.services.PersonneServiceBeanRemote;

/**
 *
 * @author Leonce
 */
@Stateless
public class PersonneServiceBean implements PersonneServiceBeanRemote {

    private static final String DEFAULT_PU = "boutique2PU";
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory(DEFAULT_PU);
    
//    @PersistenceContext(name = DEFAULT_PU)
    private EntityManager em = emf.createEntityManager();
    
    private EntityTransaction et = em.getTransaction();

    /**
     * Créer une nouvelle occurrence dans la base
     * 
     * @param personne
     * @throws Exception 
     */
    @Override
    public void ajouter(final Personne personne) throws Exception {
        et.begin();
        try {
            this.em.persist(personne);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    /**
     * Met à jour une occurrence dans la base
     * 
     * @param personne
     * @throws Exception 
     */
    @Override
    public void modifier(final Personne personne) throws Exception {
        et.begin();
        try {
            this.em.merge(personne);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }
    
    /**
     * Supprime une occurrence dans la base
     * 
     * @param personne
     * @throws Exception 
     */
    @Override
    public void supprimer(Personne personne) throws Exception{
        et.begin();
        try {
            this.em.remove(personne);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    /**
     * Supprime une occurrence dans la base a partir d'un identifiant
     * 
     * @param id
     * @throws Exception 
     */
    @Override
    public void supprimer(long id) throws Exception{
        et.begin();
        try {
            this.em.remove(this.recuperer(id));
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    /**
     * Retrouve une entité par son identifiant
     * 
     * @param id
     * @return une entite a partir un identifiant
     * @throws Exception 
     */
    @Override
    public Personne recuperer(long id) throws Exception{
        return this.em.find(Personne.class, id);
    }

    /**
     * 
     * Retrouve une entité par son identifiant
     * 
     * @return un nombre
     * @throws Exception 
     */
    @Override
    public long compter() throws Exception {
        return (long) this.lister().size();
    }

    /**
     * Trouve une liste d'entités
     * 
     * @return une liste
     * @throws Exception 
     */
    @Override
    public List<Personne> lister() throws Exception {
        String jpql = "SELECT e FROM personnes e";
        Query query = this.em.createQuery(jpql);
        return query.getResultList();
    }

    /**
     * Trouve une liste d'entités
     * 
     * @param proprieteTri
     * @param triAsc
     * @return une liste
     * @throws Exception 
     */
    @Override
    public List<Personne> lister(String proprieteTri, boolean triAsc) throws Exception {
        String jpql = "";
        triAsc = false;
        if (triAsc) {
            jpql = "SELECT e FROM personnes e ORDER BY e." + proprieteTri + " ASC";
        } else {
            jpql = "SELECT e FROM personnes e ORDER BY e." + proprieteTri + " DESC";
        }
        Query query = this.em.createQuery(jpql);
        return query.getResultList();
    }

    /**
     * Trouve une liste d'entités
     * 
     * @param debut
     * @param taille
     * @param proprieteTri
     * @param triAsc
     * @return une liste
     * @throws Exception 
     */
    @Override
    public List<Personne> lister(int debut, int taille, String proprieteTri, boolean triAsc) throws Exception {
        String jpql = "";
        triAsc = false;
        if (triAsc) {
            jpql = "SELECT e FROM personnes e ORDER BY e." + proprieteTri + " ASC";
        } else {
            jpql = "SELECT e FROM personnes e ORDER BY e." + proprieteTri + " DESC";
        }
        Query query = this.em.createQuery(jpql);
        return query.setFirstResult(debut).setMaxResults(taille).getResultList();
    }
}
