package com.example.wholesale_system.food_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * service of food product
 */
@Service
public class FoodProductService {
    private final FoodProductRepository foodProductRepository;

    @Autowired
    public FoodProductService(FoodProductRepository foodProductRepository) {
        this.foodProductRepository = foodProductRepository;
    }

    /**
     * get all food product
     *
     * @param keyword: when users want to search food product, the value they enter will store in this variable
     * @return: use food product's DAO to find all food product
     */
    public Iterable<FoodProduct> getFoodProductList(String keyword) {
        if (keyword != null) {
            return foodProductRepository.search(keyword);
        }
        return foodProductRepository.findAll();
    }

    /**
     * save food product
     *
     * @param foodProduct: the food product to save after adding/updating
     */
    public void saveFoodProduct(FoodProduct foodProduct) {
        foodProductRepository.save(foodProduct);
    }

    /**
     * delete the food product
     *
     * @param id: the specific food product id to delete
     */
    public void deleteFoodProduct(Integer id) {
        foodProductRepository.deleteById(id);
    }

    /**
     * find food product by id
     *
     * @param id: the specific food product id to find
     * @return: the food product after find by id
     */
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
