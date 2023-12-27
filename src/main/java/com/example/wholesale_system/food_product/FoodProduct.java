// Student name: Jia-Wen Li  Student number: 23628542

package com.example.wholesale_system.food_product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * class of food product
 * the properties contain id, sku, description, category, price
 * also there are setter and getter of properties
 */
@Entity
public class FoodProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sku;
    private String description;
    private String category;
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Override toString() to print food product
     *
     * @return: information of food product in string
     */
    @Override
    public String toString() {
        return "Product={id=" + id +
                ", SKU='" + sku +
                "', description='" + description +
                "', category='" + category +
                "', price=" + price + "}";
    }
}
