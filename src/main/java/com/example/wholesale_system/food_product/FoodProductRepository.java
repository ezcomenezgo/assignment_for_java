package com.example.wholesale_system.food_product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO of food products
 */
@Repository
public interface FoodProductRepository extends CrudRepository<FoodProduct, Integer> {
    @Query("SELECT f FROM FoodProduct f WHERE CONCAT(f.category, f.description, f.price, f.sku) LIKE %?1%")
    public List<FoodProduct> search(String keyword);
}
