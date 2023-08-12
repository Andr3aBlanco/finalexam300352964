package com.andr3ablanco.finalexam300352964.Controllers;

import com.andr3ablanco.finalexam300352964.Entities.Category;
import com.andr3ablanco.finalexam300352964.Entities.Display;
import com.andr3ablanco.finalexam300352964.Entities.Item;
import com.andr3ablanco.finalexam300352964.Entities.Sale;
import com.andr3ablanco.finalexam300352964.Repository.CategoryRepository;
import com.andr3ablanco.finalexam300352964.Repository.ItemRepository;
import com.andr3ablanco.finalexam300352964.Repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

        List<Object[]> toDisplay =  saleRepository.getSumOfQtyByCatdesc();
        List<Display> toPass = new ArrayList<Display>();


        for (Object[] row : toDisplay) {
            String catcode = (String) row[0];
            System.out.println("this is catcode " +catcode);
            String catdesc = (String) row[1];
            Double sumQty = (Double) row[2];

            Display toAdd = new Display(catcode, catdesc, sumQty);
            toPass.add(toAdd);

            // You can perform further processing or store the values as needed
        }

        System.out.println("this is the legthn of to Display " + toDisplay.size());

        model.addAttribute("summary", toPass);
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

        List<Object[]> toDisplay =  saleRepository.getSumOfQtyByCatdesc();
        List<Display> toPass = new ArrayList<Display>();


        for (Object[] row : toDisplay) {
            String catcode = (String) row[0];
            System.out.println("this is catcode " +catcode);
            String catdesc = (String) row[1];
            Double sumQty = (Double) row[2];

            Display toAdd = new Display(catcode, catdesc, sumQty);
            toPass.add(toAdd);

            // You can perform further processing or store the values as needed
        }

        System.out.println("this is the legthn of to Display " + toDisplay.size());

        model.addAttribute("summary", toPass);
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

    @GetMapping("/deleteSale") // This is the name that goes in the button not the one in the method
    public String deleteSale(Long id){

        saleRepository.deleteById(id);

        return "redirect:/index"; // I need this for redirect but it's the same as /
    }


    @GetMapping("/editSale")
    public String editSale(Model model, Long id, HttpSession session){

        List<Item> theItems = itemRepository.findAll();
        Sale sale = saleRepository.findById(id).orElse(null);
        if(sale ==null) throw new RuntimeException("Student does not exist");


        model.addAttribute("sale", sale);
        model.addAttribute("items", theItems);

        return "edit";
    }



    @PostMapping("/saveEdit")
    public String saveEdit(Model model, @RequestParam("receiptNumber") int receiptNumber,
                           @RequestParam("saleDate") String saleDate , @RequestParam("quantity") double quantity,
                           @RequestParam("itemCode") String itemCode, @RequestParam("saleID") Long saleID ) throws ParseException {


//        if (bindingResult.hasErrors()) {
//            return "edit";
//        } else {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateToSave = format.parse(saleDate);


            Sale sale = new Sale(receiptNumber,itemCode, quantity, dateToSave, null  );

            //save to db

            saleRepository.updateSAle(saleID, quantity, itemCode);

//        }



        return "redirect:/index"; // I need this for redirect but it's the same as /
    }



}
