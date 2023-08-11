package com.andr3ablanco.finalexam300352964.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {




    private int recno;

    private String icode;

    private double qty;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dot;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
