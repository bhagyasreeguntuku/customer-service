package com.hcl.customerservice.controllers;

import com.hcl.customerservice.model.Customer;
import com.hcl.customerservice.repositories.CustomerRepository;
import com.hcl.customerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customerService/v1/customers/")
public class CustomerController {
    @Autowired
    private CustomerService custservice;

    @Autowired
    private CustomerRepository repo;

    @GetMapping
    public List<Customer> getAll()
    {
       // System.out.println("get all customers");
      return  custservice.getAll();
    }
    @GetMapping("/{id}")
    public Customer getOneById(@PathVariable int id)
    {
       return custservice.getOneById(id);

    }
    @PostMapping
    public Customer create(@RequestBody Customer customer)
    {
        return custservice.create(customer);
    }
    @PutMapping
    public Customer update(@RequestBody Customer customer)
    {
        return custservice.update(customer);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        System.out.println("deletemapping customer");
       custservice.delete(id);


    }


}
