package com.andr3ablanco.finalexam300352964.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")

public class Item {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;


    private String Catcode;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String Icode;

    private String Idesc;

    private double Price;
}
