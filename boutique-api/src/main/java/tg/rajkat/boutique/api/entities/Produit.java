/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.rajkat.boutique.api.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rajkat
 */
@Entity
@Table(name = "produits")
public class Produit implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "libelle", nullable = false, unique = true, length = 100)
    private String libelle;

    @Column(name = "prix_unitaire", nullable = false)
    private double prixUnitaire;

    @Column(name = "date_peremption", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datePeremption;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "categorie", nullable = false)
    private Categorie categorie;

    /**
     * Default constructor
     */
    public Produit() {
    }

    /**
     * Constructor with parameter
     * @param libelle
     * @param prixUnitaire
     * @param datePeremption 
     */
    public Produit(String libelle, double prixUnitaire, Date datePeremption) {
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePeremption = datePeremption;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produits{" + "id=" + id + ", libelle=" + libelle + ", prixUnitaire=" + prixUnitaire + ", datePeremption=" + datePeremption + ", categorie=" + categorie + '}';
    }

    /**
     * Renvoie true si le produit est périmé par rapport à l'heure actuel
     *
     * @return <c>True</c> si le produit est périmé.<c>false</c> sinon
     * @throws NullPointerException quand la date actuelle est nulle
     */
    public boolean estPerime() {
        Date dateReference = new Date();
        return dateReference == null && this.getDatePeremption() != null && this.getDatePeremption().before(dateReference);
    }
    
    /**
     * Renvoie true si le produit est périmé par rapport a la date de Reference.
     *
     * @param dateReference la date de réference
     * @return<c>true</c> si le produit est périmé.<c>false</c> sinon
     * @throws NullPointerException quand la date de référence ou la date de
     * péremption est nulle.
     */
    public boolean estPerime(Date dateReference) {
        return dateReference == null && this.getDatePeremption() != null && this.getDatePeremption().before(dateReference);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    
}
