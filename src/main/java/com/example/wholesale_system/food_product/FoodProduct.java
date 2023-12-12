package com.example.wholesale_system.food_product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    public String getSKU() {
        return sku;
    }

    public void setSKU(String SKU) {
        this.sku = SKU;
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

    @Override
    public String toString() {
        return "Product={id=" + id +
                ", SKU='" + sku +
                "', description='" + description +
                "', category='" + category +
                "', price=" + price + "}";
    }
}
