// Student name: Jia-Wen Li  Student number: 23628542

package com.example.wholesale_system;

import com.example.wholesale_system.customer.Address;
import com.example.wholesale_system.customer.Customer;
import com.example.wholesale_system.customer.CustomerService;
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
    private final CustomerService customerService;

    public WholesaleSystemApplication(FoodProductService foodProductService, CustomerService customerService) {
        this.foodProductService = foodProductService;
        this.customerService = customerService;
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
            System.out.println("[6] List all customer");
            System.out.println("[7] Search for customer by ID");
            System.out.println("[8] Add a new customer");
            System.out.println("[9] Update a customer by ID");
            System.out.println("[10] Delete a customer by ID");
            System.out.println("[11] Exit");

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
                    System.out.println("\nEnter Product ID that you want to delete");
                    int idToDelete = Integer.parseInt(in.nextLine());
                    deleteFoodById(idToDelete);
                    break;
                case "6":
                    getAllCustomer();
                    break;
                case "7":
                    System.out.println("\nEnter Customer ID that you want to find");
                    int customerIdToFind = Integer.parseInt(in.nextLine());
                    getCustomerById(customerIdToFind);
                    break;
                case "8":
                    System.out.println("\nPlease enter customer name");
                    String nameToAdd = in.nextLine();
                    System.out.println("\nPlease enter customer address line 1");
                    String addressLine1ToAdd = in.nextLine();
                    System.out.println("\nPlease enter customer address line 2");
                    String addressLine2ToAdd = in.nextLine();
                    System.out.println("\nPlease enter customer address line 3");
                    String addressLine3ToAdd = in.nextLine();
                    System.out.println("\nPlease enter customer post code");
                    String postCodeToAdd = in.nextLine();
                    System.out.println("\nPlease enter customer country");
                    String countryToAdd = in.nextLine();
                    System.out.println("\nPlease enter customer telephone");
                    String telephoneToAdd = in.nextLine();
                    addCustomer(nameToAdd, addressLine1ToAdd, addressLine2ToAdd, addressLine3ToAdd, postCodeToAdd, countryToAdd, telephoneToAdd);
                    break;
                case "9":
                    System.out.println("\nEnter Customer ID that you want to update");
                    int customerIdToUpdate = Integer.parseInt(in.nextLine());
                    try {
                        Customer customer = customerService.findCustomerById(customerIdToUpdate);
                        if (customer != null) {
                            System.out.println("\nPlease enter customer name");
                            String nameToUpdate = in.nextLine();
                            System.out.println("\nPlease enter customer address line 1");
                            String addressLine1ToUpdate = in.nextLine();
                            System.out.println("\nPlease enter customer address line 2");
                            String addressLine2ToUpdate = in.nextLine();
                            System.out.println("\nPlease enter customer address line 3");
                            String addressLine3ToUpdate = in.nextLine();
                            System.out.println("\nPlease enter customer post code");
                            String postCodeToUpdate = in.nextLine();
                            System.out.println("\nPlease enter customer country");
                            String countryToUpdate = in.nextLine();
                            System.out.println("\nPlease enter customer telephone");
                            String telephoneToUpdate = in.nextLine();
                            updateCustomer(customer, nameToUpdate, addressLine1ToUpdate, addressLine2ToUpdate, addressLine3ToUpdate, postCodeToUpdate, countryToUpdate, telephoneToUpdate);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "10":
                    System.out.println("\nEnter Customer ID that you want to delete");
                    int customerIdToDelete = Integer.parseInt(in.nextLine());
                    deleteCustomerById(customerIdToDelete);
                    break;
                case "11":
                    System.out.println("Bye Bye! See you!");
                    break;
            }
        } while (!selection.equals("11"));
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

    /**
     * get all customers
     */
    public void getAllCustomer() {
        try {
            Iterable<Customer> customers = customerService.getCustomerList();
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * find specific customer
     *
     * @param id: enter id of customer to find the customer
     */
    public void getCustomerById(int id) {
        try {
            Customer customer = customerService.findCustomerById(id);
            if (customer != null) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * add a new customer
     *
     * @param businessName:    customer's name
     * @param addressLine1:    customer's address line 1
     * @param addressLine2:    customer's address line 2
     * @param addressLine3:    customer's address line 3
     * @param postCode:        customer's address post code
     * @param country:         customer's address country
     * @param telephoneNumber: customer's telephone number
     */
    public void addCustomer(
            String businessName,
            String addressLine1,
            String addressLine2,
            String addressLine3,
            String postCode,
            String country,
            String telephoneNumber
    ) {
        try {
            Customer newCustomer = new Customer();
            Address address = new Address();
            newCustomer.setAddress(address);
            saveCustomer(newCustomer, businessName, addressLine1, addressLine2, addressLine3, postCode, country, telephoneNumber);
            System.out.println("added " + businessName + " to database!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * update the new customer
     *
     * @param customer:        the customer that user want to update
     * @param businessName:    customer's name
     * @param addressLine1:    customer's address line 1
     * @param addressLine2:    customer's address line 2
     * @param addressLine3:    customer's address line 3
     * @param postCode:        customer's address post code
     * @param country:         customer's address country
     * @param telephoneNumber: customer's telephone number
     */
    public void updateCustomer(
            Customer customer,
            String businessName,
            String addressLine1,
            String addressLine2,
            String addressLine3,
            String postCode,
            String country,
            String telephoneNumber
    ) {
        try {
            System.out.println("Before update: " + customer.toString());
            saveCustomer(customer, businessName, addressLine1, addressLine2, addressLine3, postCode, country, telephoneNumber);
            System.out.println("After update: " + customer.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * save the customer
     *
     * @param customer:        the customer need to be saved
     * @param businessName:    customer's name
     * @param addressLine1:    customer's address line 1
     * @param addressLine2:    customer's address line 2
     * @param addressLine3:    customer's address line 3
     * @param postCode:        customer's address post code
     * @param country:         customer's address country
     * @param telephoneNumber: customer's telephone number
     */
    public void saveCustomer(
            Customer customer,
            String businessName,
            String addressLine1,
            String addressLine2,
            String addressLine3,
            String postCode,
            String country,
            String telephoneNumber
    ) {
        customer.setBusinessName(businessName);
        customer.getAddress().setAddressLine1(addressLine1);
        customer.getAddress().setAddressLine2(addressLine2);
        customer.getAddress().setAddressLine3(addressLine3);
        customer.getAddress().setPostCode(postCode);
        customer.getAddress().setCountry(country);
        customer.setTelephoneNumber(telephoneNumber);
        customerService.saveCustomer(customer);
    }

    /**
     * delete the specific customer
     *
     * @param id: enter id of customer to delete the customer
     */
    public void deleteCustomerById(int id) {
        try {
            Customer customer = customerService.findCustomerById(id);
            if (customer != null) {
                customerService.deleteCustomer(id);
                System.out.println("delete " + customer.getBusinessName() + " from database!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
