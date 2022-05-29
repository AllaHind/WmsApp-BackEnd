package com.WMS.Project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String blNumero;
    private String dateReception;
    private int qttReçu;
    private String commentaire;
    private String controlleur;
    @OneToOne
    private  Attendu attendu;

}
