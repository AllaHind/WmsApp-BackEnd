package com.WMS.Project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 1, max = 6)
    private String code;
    private String nom;
    private String marque;
    private String libelle;
    private String unite;
    private String type;
    private String description;
    private int qtt;
    private double poids;
    private long cup; //CodeBarre
    private String dateExp;
    private int approv;
    @JsonBackReference
    @ManyToOne
    private Emplacement emplacement;
    private double prixPublic;
    private double prixAchat;
    @JsonBackReference(value="user-movement")
    @ManyToOne
    private Categorie categorie;

}
