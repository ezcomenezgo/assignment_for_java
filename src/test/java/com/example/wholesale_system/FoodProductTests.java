package com.example.wholesale_system;

import com.example.wholesale_system.food_product.FoodProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodProductTests {
    @Test
    public void testGetterSetterOfId() {
        FoodProduct foodProduct = new FoodProduct();
        foodProduct.setId(1);
        Integer exp = 1;
        Integer act = foodProduct.getId();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfSKU() {
        FoodProduct foodProduct = new FoodProduct();
        foodProduct.setSku("AB001");
        String exp = "AB001";
        String act = foodProduct.getSku();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfDescription() {
        FoodProduct foodProduct = new FoodProduct();
        foodProduct.setDescription("test description");
        String exp = "test description";
        String act = foodProduct.getDescription();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfCategory() {
        FoodProduct foodProduct = new FoodProduct();
        foodProduct.setCategory("test category");
        String exp = "test category";
        String act = foodProduct.getCategory();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfPrice() {
        FoodProduct foodProduct = new FoodProduct();
        foodProduct.setPrice(10);
        Integer exp = 10;
        Integer act = foodProduct.getPrice();

        assertEquals(exp, act);
    }
}
