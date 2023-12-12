package com.example.wholesale_system.food_product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodProductRepository extends CrudRepository<FoodProduct, Integer> {}
