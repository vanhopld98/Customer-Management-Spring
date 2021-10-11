package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/customers/list");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/customers/{id}")

    public ModelAndView showCustomer(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/customers/{id}")

    public ModelAndView updateCustomer(@PathVariable Long id ,
                                       @RequestParam("name") String name ,
                                       @RequestParam("email") String email,
                                       @RequestParam("address") String address){
        Customer customer = customerService.findOne(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        ModelAndView modelAndView = new ModelAndView("/customers/list");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
}
