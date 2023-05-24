package rikkei.academy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rikkei.academy.model.Customer;
import rikkei.academy.service.CustomerService;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@Controller
public class CustomerServlet {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, HttpServletRequest request) {
        Customer customer = customerService.findOne(id);
        request.setAttribute("customer", customer);
        return "/customers/info";
    }
}