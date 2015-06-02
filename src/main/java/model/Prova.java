/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author cedsobral
 */
@Entity
@Table(name = "prova")
public class Prova implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    

   

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
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
        final Prova other = (Prova) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
