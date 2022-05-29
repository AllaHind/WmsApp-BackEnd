package com.WMS.Project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Magasinier {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
    private String code;
    private String  nom;
}
