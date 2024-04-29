package com.example.demo.API.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.API.Models.ProductModel;
import com.example.demo.API.Services.ProductServices;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
        @Autowired
    private ProductServices service;

    @GetMapping("/Products")
    public List<ProductModel> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/bestSellers")
    public List<ProductModel> getBestSellers() {
        return service.getBestSellers();
    }

    @GetMapping("/Products/{search}")
    public List<ProductModel> findByProductName(@PathVariable String search) {
        return service.findByProductName(search);
    }

    @GetMapping("/getProductFromId/{id}")
    public ProductModel findByProductId(@PathVariable long id) {
        return service.findByProductId(id);
    }

    @PostMapping("/setProduct")
    public void addProduct(@RequestBody ProductModel product){
        service.addProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable long id) {  
     service.deleteProduct(id);
}

    @PutMapping("/updateProduct/{id}")
    public void updateUser(@PathVariable long id,@RequestBody ProductModel product){
        product.setId(id);
        service.updateProduct(product);
    }
}
