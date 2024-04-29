package com.example.demo.API.Repos;

import java.util.List;
import com.example.demo.API.Models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel, Long> {

    @Query("SELECT i FROM ProductModel i")
    List<ProductModel> getAllProducts();

    @Query("SELECT i FROM ProductModel i ORDER BY sales DESC LIMIT 3")
    List<ProductModel> getBestSellers();

    @Query("SELECT i FROM ProductModel i WHERE i.ProductName LIKE %:ProductName%")
    List<ProductModel> findByProductName(@Param("ProductName") String ProductName);

    @Query("SELECT i FROM ProductModel i WHERE i.id=:id")
    ProductModel findByProductId(@Param("id") long id);
}

