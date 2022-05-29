package com.WMS.Project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String type;
    private LocalDate dateCreation;
    private String fournisseur;
    private String transporteur;
    private double noCamio;
    @OneToOne(cascade=CascadeType.ALL)
    private Commande commande;
    private  String  etat;



}
