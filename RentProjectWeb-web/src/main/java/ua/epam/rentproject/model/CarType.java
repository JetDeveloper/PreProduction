/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.epam.rentproject.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Dmytro_Svynarenko
 */
@Entity
@Table(name = "CarType")
@NamedQueries({
    @NamedQuery(name = "CarType.getAll", query = "SELECT c from CarType c"),
    @NamedQuery(name = "CarType.getById", query = "SELECT c from CarType c WHERE c.id = :id"),
    @NamedQuery(name = "CarType.getByType", query = "SELECT c from CarType c WHERE c.type = :type")
})
public class CarType implements Serializable {
    
    @Id
    @Column(name="carTypeId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    
    @Column(name="carTypeName")
    private String type;

    public CarType() {
    }

    public CarType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
