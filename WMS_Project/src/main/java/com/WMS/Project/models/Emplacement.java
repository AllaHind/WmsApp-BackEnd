package com.WMS.Project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Emplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;
    private String alle;
    private String travee;
    private String niveau;
    private String alveole;
    private String status;
    @OneToMany(mappedBy ="emplacement",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Article> articles;


}

