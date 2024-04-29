package com.example.demo.API.Models;

import java.math.BigDecimal;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@EntityScan
@Table(name = "Products")
public class ProductModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "ProductName")
    @JsonProperty("ProductName")
    private String ProductName;

    @Column(columnDefinition = "TEXT", name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "sales")
    private int sales;

    @Column(name = "Images", length = Integer.MAX_VALUE)
    @JsonProperty("Images")
    private String[] images;



    public ProductModel() {
    }

    public ProductModel(String ProductName, String description, BigDecimal price, String[] images, int sales) {
        this.ProductName = ProductName;
        this.description = description;
        this.price = price;
        this.images = images;
        this.sales = sales;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String[] getImages() {
        return images;
    }

    public void setImage(String[] images) {
        this.images = images;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}