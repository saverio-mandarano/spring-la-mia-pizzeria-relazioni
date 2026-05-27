package org.lessons.java.crud.spring_la_mia_pizzeria_crud.controller;

import org.lessons.java.crud.spring_la_mia_pizzeria_crud.model.Promotion;
import org.lessons.java.crud.spring_la_mia_pizzeria_crud.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    private PromotionRepository repository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("promotion") Promotion formPromotion, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "promotions/create";
        }

        repository.save(formPromotion);
        return "redirect:/pizze";
    }

}
