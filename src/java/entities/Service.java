/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Lachgar
 */
@Entity
public class Service {

    @Id
    @GeneratedValue
    private int id;
    private String code;
    private String libelle;

    public Service() {
    }

    public Service(int id) {
        this.id = id;
    }

    public Service(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;

    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", code=" + code + ", libelle=" + libelle + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
