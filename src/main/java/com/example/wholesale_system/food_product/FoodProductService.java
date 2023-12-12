package com.example.wholesale_system.food_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodProductService {
    private final FoodProductRepository foodProductRepository;

    @Autowired
    public FoodProductService(FoodProductRepository foodProductRepository) {
        this.foodProductRepository = foodProductRepository;
    }

    public Iterable<FoodProduct> getFoodProductList() {
        return foodProductRepository.findAll();
    }

    public void saveFoodProduct(FoodProduct foodProduct) {
        foodProductRepository.save(foodProduct);
    }

    public void deleteFoodProduct(Integer id) {
        foodProductRepository.deleteById(id);
    }

    public FoodProduct findFoodById(Integer id) {
        FoodProduct foodProduct = null;
        Optional<FoodProduct> optional = foodProductRepository.findById(id);
        if (optional.isPresent()) {
            foodProduct = optional.get();
        } else {
            throw new RuntimeException(
                    "Food Product not found for id: " + id
            );
        }

        return foodProduct;
    }
}
