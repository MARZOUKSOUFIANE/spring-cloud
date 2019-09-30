package com.glsid.entitites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor
@Data @ToString
@Entity
public class Societe implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private String nomSociete;

    public Societe(String nomSociete) {
        this.nomSociete = nomSociete;
    }
}
