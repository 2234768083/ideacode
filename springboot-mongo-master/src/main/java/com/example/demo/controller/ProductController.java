package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/{productId}")
    public String getProductById(@PathVariable String productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "product-details";
    }

    @PostMapping
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable String productId, @ModelAttribute Product product) {
        product.setId(productId);
        productService.updateProduct(product);
        return "redirect:/products";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return "redirect:/products";
    }
}
