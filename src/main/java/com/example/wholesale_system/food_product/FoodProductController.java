package com.example.wholesale_system.food_product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodProductController {
    private final FoodProductService foodProductService;

    public FoodProductController(FoodProductService foodProductService) {
        this.foodProductService = foodProductService;
    }

    @GetMapping("/addNewFood")
    public String addNewFoodProduct(Model model) {
        FoodProduct foodProduct = new FoodProduct();
        model.addAttribute("foodProduct", foodProduct);
        model.addAttribute("pageTitle", "Add New Food Product");
        return "newFoodForm";
    }

    @GetMapping("/updateFood/{id}")
    public String updateFoodProduct(@PathVariable(value = "id") Integer id, Model model) {
        FoodProduct foodProduct = foodProductService.findFoodById(id);
        System.out.println("Update: " + foodProduct);
        model.addAttribute("foodProduct", foodProduct);
        model.addAttribute("pageTitle", "Update Food Product");
        return "updateFoodForm";
    }

    @GetMapping("/deleteFood/{id}")
    public String deleteFoodProduct(@PathVariable(value = "id") Integer id) {
        foodProductService.deleteFoodProduct(id);
        return "redirect:/foodList";
    }

    @PostMapping("/save")
    public String saveFood(@ModelAttribute("foodProduct") FoodProduct foodProduct) {
        foodProductService.saveFoodProduct(foodProduct);
        return "redirect:foodList";
    }

    @GetMapping ("/foodList")
    public String getFoodList(Model model) {
        Iterable<FoodProduct> foodList = foodProductService.getFoodProductList();
        model.addAttribute("foodList", foodList);
        System.out.println(foodProductService.getFoodProductList().toString());
        return "foodList";
    }
}
