/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.rajkat.boutique.api.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rajkat
 */
@Entity
@Table(name = "produits_achetes")
public class ProduitAchete implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private ProduitAchetePK produitAchetePK;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    @Column(name = "remise", nullable = false)
    private double remise;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "id_produit", nullable = false, insertable = false, updatable = false)
    private Produit produit;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "id_achat", nullable = false, insertable = false, updatable = false)
    private Achat achat;

    /**
     * Default constructor
     */
    public ProduitAchete() {
    }

    /**
     * Initialized Constructor
     * @param quantite
     * @param remise 
     */
    public ProduitAchete(Integer quantite, double remise) {
        this.quantite = quantite;
        this.remise = remise;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.produitAchetePK);
        hash = 19 * hash + Objects.hashCode(this.quantite);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.remise) ^ (Double.doubleToLongBits(this.remise) >>> 32));
        hash = 19 * hash + Objects.hashCode(this.produit);
        hash = 19 * hash + Objects.hashCode(this.achat);
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
        final ProduitAchete other = (ProduitAchete) obj;
        if (!Objects.equals(this.produitAchetePK, other.produitAchetePK)) {
            return false;
        }
        if (!Objects.equals(this.quantite, other.quantite)) {
            return false;
        }
        if (Double.doubleToLongBits(this.remise) != Double.doubleToLongBits(other.remise)) {
            return false;
        }
        if (!Objects.equals(this.produit, other.produit)) {
            return false;
        }
        if (!Objects.equals(this.achat, other.achat)) {
            return false;
        }
        return true;
    }

    public double getPrixTotal() {
        return this.produit.getPrixUnitaire() * quantite - remise;
    }
     
    @Override
    public String toString() {
        return "ProduitAchete{" + "produitAchetePK=" + produitAchetePK + ", quantite=" + quantite + ", remise=" + remise + ", produit=" + produit + ", achat=" + achat + '}';
    }

    public ProduitAchetePK getProduitAchetePK() {
        return produitAchetePK;
    }

    public void setProduitAchetePK(ProduitAchetePK produitAchetePK) {
        this.produitAchetePK = produitAchetePK;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

}
