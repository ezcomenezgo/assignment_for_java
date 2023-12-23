package com.example.wholesale_system;

import com.example.wholesale_system.food_product.FoodProduct;
import com.example.wholesale_system.food_product.FoodProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/**
 * Entry point of the application
 */
@SpringBootApplication
public class WholesaleSystemApplication implements CommandLineRunner {

    private final FoodProductService foodProductService;

    public WholesaleSystemApplication(FoodProductService foodProductService) {
        this.foodProductService = foodProductService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WholesaleSystemApplication.class, args);
    }

    /**
     * implement console menu after the application running
     *
     * @param args: arguments
     * @throws Exception: if there's api exception it would be thrown
     */
    @Override
    public void run(String... args) throws Exception {
        String selection;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("--------------------");
            System.out.println("The Food Store");
            System.out.println("Choose from these options");
            System.out.println("--------------------");
            System.out.println("[1] List all products");
            System.out.println("[2] Search for product by ID");
            System.out.println("[3] Add a new product");
            System.out.println("[4] Update a product by ID");
            System.out.println("[5] Delete a product by ID");
            System.out.println("[6] Exit");

            selection = in.nextLine();
            switch (selection) {
                case "1":
                    getFoodList();
                    break;
                case "2":
                    System.out.println("\nEnter Product ID that you want to find");
                    int idToFind = Integer.parseInt(in.nextLine());
                    getFoodById(idToFind);
                    break;
                case "3":
                    System.out.println("\nPlease enter product SKU");
                    String skuToAdd = in.nextLine();
                    System.out.println("\nPlease enter product description");
                    String descriptionToAdd = in.nextLine();
                    System.out.println("\nPlease enter product category");
                    String categoryToAdd = in.nextLine();
                    System.out.println("\nPlease enter product price");
                    int priceToAdd = Integer.parseInt(in.nextLine());
                    addFoodProduct(skuToAdd, descriptionToAdd, categoryToAdd, priceToAdd);
                    break;
                case "4":
                    System.out.println("\nEnter Product ID that you want to update");
                    int idToUpdate = Integer.parseInt(in.nextLine());
                    try {
                        FoodProduct foodProduct = foodProductService.findFoodById(idToUpdate);
                        if (foodProduct != null) {
                            System.out.println("\nPlease enter product SKU");
                            String skuToUpdate = in.nextLine();
                            System.out.println("\nPlease enter product description");
                            String descriptionToUpdate = in.nextLine();
                            System.out.println("\nPlease enter product category");
                            String categoryToUpdate = in.nextLine();
                            System.out.println("\nPlease enter product price");
                            int priceToUpdate = Integer.parseInt(in.nextLine());
                            updateFood(foodProduct, skuToUpdate, descriptionToUpdate, categoryToUpdate, priceToUpdate);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    System.out.println("\n\nEnter Product ID that you want to delete");
                    int idToDelete = Integer.parseInt(in.nextLine());
                    deleteFoodById(idToDelete);
                    break;
                case "6":
                    System.out.println("Bye Bye! See you!");
                    break;
            }
        } while (!selection.equals("6"));
    }

    /**
     * get all food products
     */
    public void getFoodList() {
        try {
            Iterable<FoodProduct> foodProducts = foodProductService.getFoodProductList("");
            for (FoodProduct foodProduct : foodProducts) {
                System.out.println(foodProduct);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * find specific food product
     *
     * @param id: enter id of food to find the food product
     */
    public void getFoodById(int id) {
        try {
            FoodProduct foodProduct = foodProductService.findFoodById(id);
            if (foodProduct != null) {
                System.out.println(foodProduct);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * add a new food product
     *
     * @param sku:         food product's sku
     * @param description: food product's description
     * @param category:    food product's category
     * @param price:       food product's price
     */
    public void addFoodProduct(String sku, String description, String category, int price) {
        try {
            FoodProduct foodProduct = new FoodProduct();
            foodProduct.setSku(sku);
            foodProduct.setDescription(description);
            foodProduct.setCategory(category);
            foodProduct.setPrice(price);
            foodProductService.saveFoodProduct(foodProduct);
            System.out.println("added " + sku + " from database!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * update the food product
     *
     * @param foodProduct: the food product that user want to update
     * @param sku:         food product's sku
     * @param description: food product's description
     * @param category:    food product's category
     * @param price:       food product's price
     */
    public void updateFood(FoodProduct foodProduct, String sku, String description, String category, int price) {
        try {
            System.out.println("Before update: " + foodProduct.toString());
            foodProduct.setSku(sku);
            foodProduct.setDescription(description);
            foodProduct.setCategory(category);
            foodProduct.setPrice(price);
            foodProductService.saveFoodProduct(foodProduct);
            System.out.println("After update: " + foodProduct.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * delete the specific food product
     *
     * @param id: enter id of food to delete the food product
     */
    public void deleteFoodById(int id) {
        try {
            FoodProduct foodProduct = foodProductService.findFoodById(id);
            if (foodProduct != null) {
                foodProductService.deleteFoodProduct(id);
                System.out.println("delete " + foodProduct.getDescription() + " from database!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
