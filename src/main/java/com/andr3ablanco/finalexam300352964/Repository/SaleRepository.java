package com.andr3ablanco.finalexam300352964.Repository;

import com.andr3ablanco.finalexam300352964.Entities.Display;
import com.andr3ablanco.finalexam300352964.Entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT c.Catcode, c.Catdesc, SUM(s.qty) FROM Sale s " +
            "JOIN Item i ON i.Icode = s.icode " +
            "JOIN Category c ON c.Catcode = i.Catcode " +
            "GROUP BY c.Catcode, c.Catdesc")
    List<Object[]> getSumOfQtyByCatdesc();


    @Modifying
    @Query("UPDATE Sale c SET c.qty = :quantity, c.icode = :itemCode WHERE c.id = :id")
    void updateSAle(@Param("id") Long id, @Param("quantity") double productQty, @Param("itemCode") String itemCode);

}
