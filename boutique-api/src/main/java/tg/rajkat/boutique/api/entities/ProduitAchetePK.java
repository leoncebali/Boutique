/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.rajkat.boutique.api.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author rajkat
 */
@Embeddable
public class ProduitAchetePK implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "id_produit")
    private Long produitId;

    @Column(name = "id_achat")
    private Long AchatId;

    /**
     * Default constructor
     */
    public ProduitAchetePK() {
    }

    /**
     * Initialized Constructor
     * @param produitId
     * @param AchatId 
     */
    public ProduitAchetePK(Long produitId, Long AchatId) {
        this.produitId = produitId;
        this.AchatId = AchatId;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.produitId);
        hash = 73 * hash + Objects.hashCode(this.AchatId);
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
        final ProduitAchetePK other = (ProduitAchetePK) obj;
        if (!Objects.equals(this.produitId, other.produitId)) {
            return false;
        }
        if (!Objects.equals(this.AchatId, other.AchatId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProduitAchetePK{" + "produitId=" + produitId + ", AchatId=" + AchatId + '}';
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }

    public Long getAchatId() {
        return AchatId;
    }

    public void setAchatId(Long AchatId) {
        this.AchatId = AchatId;
    }

}
