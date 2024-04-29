package com.example.demo.API.Services;
import com.example.demo.API.Repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.API.Models.ProductModel;
import java.util.*;

@Service
public class ProductServices {
    
    @Autowired
    private ProductRepo repository;

    public List<ProductModel> getAllProducts(){
        return repository.getAllProducts();
    }

    public List<ProductModel> getBestSellers(){
        return repository.getBestSellers();
    }

    public ProductModel addProduct(ProductModel product){
        return repository.save(product);
    }


    public ProductModel updateProduct(ProductModel product){
        return repository.save(product);
    }

    public List<ProductModel> findByProductName(String ProductName){
        return repository.findByProductName(ProductName);
    }

    public ProductModel findByProductId(long id){
        return repository.findByProductId(id);
    }

    public void deleteProduct(long id){
        repository.deleteById(id);
        System.out.println("product from id: "+id+" was deleted");
    }

}

