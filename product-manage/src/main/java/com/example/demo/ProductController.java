package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private final ProductRepository repo;

    ProductController(ProductRepository repo){
        this.repo = repo;
    }

    // Home Page
    @GetMapping("/")
    public String showMenu() {
        return "index";
    }

    // View all products
    @GetMapping("/catalog")
    public String showCatalog(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("allProducts", products);
        return "catalog";
    }

    // Show form to add product
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    // Save product
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        repo.save(product);
        return "redirect:/catalog";
    }
}