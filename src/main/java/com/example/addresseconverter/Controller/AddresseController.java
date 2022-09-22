package com.example.addresseconverter.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddresseController {

    Calculator calc = new Calculator();

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/visBy")
    public String showVisBy(@RequestParam("Addresse") int addresseID, RedirectAttributes attributes){

        String Addresse = calc.getStringAddress(addresseID);

        attributes.addAttribute("Addresse",Addresse);

        return "redirect:/visBy";
    }



    @GetMapping("/visBy")
    public String showVisBy(@RequestParam("Addresse") int addresseID, Model model){

        String Addresse = calc.getStringAddress(addresseID);

        model.addAttribute("Addresse",Addresse);

        return "visBy";
    }


}
