/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.rajkat.boutique.api.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author rajkat
 */
@Entity
@Table(name = "clients")
@DiscriminatorValue("C")
public class Client extends Personne implements Serializable {
    
    @Column(name = "cin")
    private String cin;

    /**
     * Default Constructor
     */
    public Client() {

    }

    /**
     * INitialized Constructor
     * @param cin 
     */
    public Client(String cin) {
        this.cin = cin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.cin);
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.cin, other.cin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "cin=" + cin + '}';
    }

    /**
     * @return the cin
     */
    public String getCin() {
        return cin;
    }

    /**
     * @param cin the cin to set
     */
    public void setCin(String cin) {
        this.cin = cin;
    }
}
