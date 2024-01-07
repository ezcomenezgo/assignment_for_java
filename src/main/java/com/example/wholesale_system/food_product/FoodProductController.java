// Student name: Jia-Wen Li  Student number: 23628542

package com.example.wholesale_system.food_product;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * controller of food product
 */
@Controller
public class FoodProductController {
    private final FoodProductService foodProductService;

    public FoodProductController(FoodProductService foodProductService) {
        this.foodProductService = foodProductService;
    }

    /**
     * go to add new food product page
     *
     * @param model: add an empty food product object to the interface
     * @return: show the form of adding a new food product
     */
    @GetMapping("/addNewFood")
    public String addNewFoodProduct(Model model) {
        FoodProduct foodProduct = new FoodProduct();
        model.addAttribute("foodProduct", foodProduct);
        model.addAttribute("pageTitle", "Add New Food Product");
        return "newFoodForm";
    }

    /**
     * go to update the food product page
     *
     * @param id:    specific food product to update
     * @param model: add data of food product that need to be updated to the interface
     * @return: show the form of updating the food product
     */
    @GetMapping("/updateFood/{id}")
    public String updateFoodProduct(@PathVariable(value = "id") Integer id, Model model) {
        FoodProduct foodProduct = foodProductService.findFoodById(id);
        System.out.println("Update: " + foodProduct);
        model.addAttribute("foodProduct", foodProduct);
        model.addAttribute("pageTitle", "Update Food Product");
        return "updateFoodForm";
    }

    /**
     * delete the food product
     *
     * @param id: specific food product to delete
     * @return: show the food product list after delete the food product
     */
    @PostMapping("/deleteFood/{id}")
    public String deleteFoodProduct(@PathVariable(value = "id") Integer id) {
        foodProductService.deleteFoodProduct(id);
        return "redirect:/foodList";
    }

    /**
     * save the food product
     *
     * @param foodProduct: a new food product or an updated food product
     * @return: show the food product list after adding/updating the food product
     */
    @PostMapping("/save")
    public String saveFood(@ModelAttribute("foodProduct") FoodProduct foodProduct) {
        foodProductService.saveFoodProduct(foodProduct);
        return "redirect:foodList";
    }

    /**
     * go to all food products page
     *
     * @param model:   add data of food product list to the interface
     * @param keyword: when users want to search food product, the value they enter will store in this variable
     * @return: show the food product list
     */
    @GetMapping("/foodList")
    public String getFoodList(Model model, @Param("keyword") String keyword) {
        Iterable<FoodProduct> foodList = foodProductService.getFoodProductList(keyword);
        model.addAttribute("foodList", foodList);
        model.addAttribute("keyword", keyword);
        return "foodList";
    }
}
