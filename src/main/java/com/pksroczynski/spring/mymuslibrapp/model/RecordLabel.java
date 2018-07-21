package com.pksroczynski.spring.mymuslibrapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
public class RecordLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String www;
    private String email;
    private String address;

    public RecordLabel(String name, String www, String email, String address) {
        this.name = name;
        this.www = www;
        this.email = email;
        this.address = address;
    }

}
