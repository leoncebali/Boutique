/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.rajkat.boutique.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rajkat
 */
@Entity
@Table(name = "achats")
public class Achat implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_achat", nullable = false)
    private Date dateAchat;

    @Column(name = "remise", nullable = false)
    private double remise;

    @OneToMany(mappedBy = "achat", fetch = FetchType.LAZY, cascade = {})
    private List<ProduitAchete> produitsAchetes;

    /**
     * Default Constructor
     */
    public Achat() {
    }

    /**
     * Initialized Constructor
     * @param id
     * @param dateAchat
     * @param Remise 
     */
    public Achat(long id, Date dateAchat, double Remise) {
        this.id = id;
        this.remise = Remise;
        this.dateAchat = dateAchat;

    }

    public double getPrixTotal() {
        double prixTotal = 0d;
        for (ProduitAchete produitAchete : this.getProduitsAchetes()) {
            prixTotal += produitAchete.getPrixTotal();
        }
        return prixTotal - this.getRemiseTotale();
    }

    /**
     * 
     * @return Total of reduction
     */
    public double getRemiseTotale() {
        double total = 0;
        for (int i = 0; i < getProduitsAchetes().size(); i++) {
            total = total + getProduitsAchetes().get(i).getRemise();
        }
        return total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achat)) {
            return false;
        }
        Achat other = (Achat) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Achat{" + "id=" + getId() + ", dateAchat=" + getDateAchat() + ", remise=" + getRemise() + ", produitsAchetes=" + getProduitsAchetes() + '}';
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the dateAchat
     */
    public Date getDateAchat() {
        return dateAchat;
    }

    /**
     * @param dateAchat the dateAchat to set
     */
    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    /**
     * @return the remise
     */
    public double getRemise() {
        return remise;
    }

    /**
     * @param remise the remise to set
     */
    public void setRemise(double remise) {
        this.remise = remise;
    }

    /**
     * @return the produitsAchetes
     */
    public List<ProduitAchete> getProduitsAchetes() {
        return produitsAchetes;
    }

    /**
     * @param produitsAchetes the produitsAchetes to set
     */
    public void setProduitsAchetes(List<ProduitAchete> produitsAchetes) {
        this.produitsAchetes = produitsAchetes;
    }
    
    
}
