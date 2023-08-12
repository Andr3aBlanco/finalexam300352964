package com.andr3ablanco.finalexam300352964.Controllers;

import com.andr3ablanco.finalexam300352964.Repository.SaleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CoreControllerTest {

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private CoreController coreController;

    @Test
    void showHome() {
    }

    @Test
    void showHome2() {

//        Model model = new ExtendedModelMap();
//        BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "");
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date saleDate = dateFormat.parse("2023-08-10");
//
//        when(bindingResult.hasErrors()).thenReturn(false);
//
//        coreController.saveEdit(model, bindingResult, 123, "2023-08-10", 10.5, "ITEM123", 1L, null);
//
//        Sale expectedSale = new Sale(123, "ITEM123", 10.5, saleDate, null);
//        verify(saleRepository).updateSAle(1L, 10.5, "ITEM123");

    }

    @Test
    void saveSale() {
    }

    @Test
    void deleteSale() {
    }

    @Test
    void editSale() {
    }

    @Test
    void saveEdit() {
    }
}