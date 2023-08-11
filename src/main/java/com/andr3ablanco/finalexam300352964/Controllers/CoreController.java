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

import java.util.List;


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



        return "home";
    }


}
