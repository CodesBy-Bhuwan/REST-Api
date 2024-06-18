package com.codesbybhuwan.restfulApi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data //this is provide us Getter and Setter
public class Role {

    @Id
//    In most of the case we have less role so we needn't to autoGen but already assign roles
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

}
