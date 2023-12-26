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
    public String getCustomerList(Model model, @Param("keyword") String keyword) {
        Iterable<Customer> customerList = customerService.getCustomerList(keyword);
        model.addAttribute("customerList", customerList);
        model.addAttribute("keyword", keyword);

        return "customerList";
    }

    @GetMapping("/addNewCustomer")
    public String addNewCustomer(Model model) {
        Customer customer = new Customer();
        Address address = new Address();
        customer.setAddress(address);
        model.addAttribute("customer", customer);
        model.addAttribute("pageTitle", "Add New Customer");
        return "newCustomerForm";
    }

    @GetMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable(value = "id") Integer id, Model model) {
        Customer customer = customerService.findCustomerById(id);
        System.out.println("Update: " + customer);
        model.addAttribute("customer", customer);
        model.addAttribute("pageTitle", "Update Customer");
        return "updateCustomerForm";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") Integer id) {
        customerService.deleteCustomer(id);
        return "redirect:/customerList";
    }

    @PostMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        System.out.println(customer.toString());
        customerService.saveCustomer(customer);
        return "redirect:customerList";
    }
}
