// Student name: Jia-Wen Li  Student number: 23628542

package com.example.wholesale_system.customer;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * controller of customer
 */
@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * go to all customers page
     *
     * @param model:   add data of customers list to the interface
     * @param keyword: when users want to search customer, the value they enter will store in this variable
     * @return: show the customer list
     */
    @GetMapping("/customerList")
    public String getCustomerList(Model model) {
        Iterable<Customer> customerList = customerService.getCustomerList();
        model.addAttribute("customerList", customerList);

        return "customerList";
    }

    /**
     * go to add new customer page
     *
     * @param model: add an empty customer object to the interface
     * @return: show the form of adding a new customer
     */
    @GetMapping("/addNewCustomer")
    public String addNewCustomer(Model model) {
        Customer customer = new Customer();
        Address address = new Address();
        customer.setAddress(address);
        model.addAttribute("customer", customer);
        model.addAttribute("pageTitle", "Add New Customer");
        return "newCustomerForm";
    }

    /**
     * go to update the customer page
     *
     * @param id:    specific customer to update
     * @param model: add data of customer that need to be updated to the interface
     * @return: show the form of updating the customer
     */
    @GetMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable(value = "id") Integer id, Model model) {
        Customer customer = customerService.findCustomerById(id);
        System.out.println("Update: " + customer);
        model.addAttribute("customer", customer);
        model.addAttribute("pageTitle", "Update Customer");
        return "updateCustomerForm";
    }

    /**
     * delete the customer
     *
     * @param id: specific customer to delete
     * @return: show the customer list after delete the customer
     */
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") Integer id) {
        customerService.deleteCustomer(id);
        return "redirect:/customerList";
    }

    /**
     * save the customer
     *
     * @param customer: a new customer or an updated customer
     * @return: show the customer list after adding/updating the customer
     */
    @PostMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        System.out.println(customer.toString());
        customerService.saveCustomer(customer);
        return "redirect:customerList";
    }
}
