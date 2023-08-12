package com.andr3ablanco.finalexam300352964.Controllers;

import com.andr3ablanco.finalexam300352964.Entities.Category;
import com.andr3ablanco.finalexam300352964.Entities.Item;
import com.andr3ablanco.finalexam300352964.Entities.Sale;
import com.andr3ablanco.finalexam300352964.Repository.CategoryRepository;
import com.andr3ablanco.finalexam300352964.Repository.ItemRepository;
import com.andr3ablanco.finalexam300352964.Repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
@AllArgsConstructor
public class CoreController {


    @Autowired

    private CategoryRepository categoryRepository;


    @Autowired
    private ItemRepository itemRepository;


    @Autowired
    private SaleRepository saleRepository;

    @GetMapping("/")
    public String showHome(Model model){

        List<Sale> theSales = saleRepository.findAll();
        List<Item> theItems = itemRepository.findAll();
        List<Category> theCategories = categoryRepository.findAll();

        model.addAttribute("sales", theSales);
        model.addAttribute("items", theItems);
        model.addAttribute("category", theCategories);

        return "home";
    }


    @GetMapping("/index")
    public String showHome2(Model model){


        List<Sale> theSales = saleRepository.findAll();
        List<Item> theItems = itemRepository.findAll();
        List<Category> theCategories = categoryRepository.findAll();

        model.addAttribute("sales", theSales);
        model.addAttribute("items", theItems);
        model.addAttribute("category", theCategories);

        return "home";
    }



    //save at the beggining

    @PostMapping("/saveSale") // This is the name that goes in the button not the one in the method
    public String saveSale(Model model, @RequestParam("receiptNumber") int receiptNumber, @RequestParam("saleDate") String saleDate , @RequestParam("quantity") double quantity, @RequestParam("itemCode") String itemCode, HttpSession session ) throws ParseException {


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateToSave = format.parse(saleDate);


        Sale sale = new Sale(receiptNumber,itemCode, quantity, dateToSave, null  );

        //save to db

        saleRepository.save(sale);


        return "redirect:/index"; // I need this for redirect but it's the same as /
    }

}
