package com.WMS.Project.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String nom;
    private String description;
    @OneToMany(mappedBy = "categorie",fetch = FetchType.LAZY)
    @JsonManagedReference(value="user-movement")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Article> articles;
}
