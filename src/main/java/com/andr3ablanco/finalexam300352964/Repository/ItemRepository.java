package com.andr3ablanco.finalexam300352964.Repository;

import com.andr3ablanco.finalexam300352964.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
