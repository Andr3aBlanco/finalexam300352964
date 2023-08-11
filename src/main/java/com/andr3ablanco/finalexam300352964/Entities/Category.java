package com.andr3ablanco.finalexam300352964.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String Catcode;

    private String Catdesc;
}
