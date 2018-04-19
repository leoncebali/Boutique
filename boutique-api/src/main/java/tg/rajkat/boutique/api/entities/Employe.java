/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.rajkat.boutique.api.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rajkat
 */
@Entity
@Table(name = "employes")
@DiscriminatorValue("E")
public class Employe extends Personne implements Serializable{
    
    @Column(name = "date_naissance", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Column(name = "cnss", nullable = false)
    private String cnss;

    /**
     * Default Constructor
     */
    public Employe() {
    }

    /**
     * INitialized Constructor
     * @param dateNaissance
     * @param cnss 
     */
    public Employe(Date dateNaissance, String cnss) {
        this.cnss = cnss;
        this.dateNaissance = dateNaissance;
    }

    /**
     * Constructor inheritance of class Personne
     * @param dateNaissance
     * @param cnss
     * @param id
     * @param nom
     * @param prenom 
     */
    public Employe(Date dateNaissance, String cnss, Long id, String nom, String prenom) {
        super(id, nom, prenom);
        this.dateNaissance = dateNaissance;
        this.cnss = cnss;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.dateNaissance);
        hash = 11 * hash + Objects.hashCode(this.cnss);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employe other = (Employe) obj;
        if (!Objects.equals(this.dateNaissance, other.dateNaissance)) {
            return false;
        }
        if (!Objects.equals(this.cnss, other.cnss)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employe{" + "dateNaissance=" + dateNaissance + ", cnss=" + cnss + '}';
    }

    public int getAge() {
        Calendar c = Calendar.getInstance();
        String str = dateNaissance.toString();
        int taille = str.length();
        String s;
        s = String.valueOf(str.charAt(taille - 4));
        s = s + String.valueOf(str.charAt(taille - 3));
        s = s + String.valueOf(str.charAt(taille - 2));
        s = s + String.valueOf(str.charAt(taille - 1));
        int age = c.get(Calendar.YEAR) - Integer.valueOf(s);
        return age;
    }

    public int getAge(Date ref) throws ParseException {

        // en premier on essaie d'avoir le nombre de jour entre les deux dates et 68400 est le nombre de secondes en une journée
        long age = ((ref.getTime() / 1000 - dateNaissance.getTime() / 1000) / (3600 * 24));
        age -= age * 47 / (86400);
        age = age / 365;
        /* Ensuite on ajoute 47 qui est 
         * issue du fait qu'on est reparti le 29 ème jour du mois de fevrier sur tout les jours de lannée 
         * 31536000 est le nombre de secondes en une année
         */
        System.out.println("Voici la date saisie :" + age);

        return (int) age;
    }
    
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCnss() {
        return cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }
    
}
