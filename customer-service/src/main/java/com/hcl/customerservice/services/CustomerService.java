package com.hcl.customerservice.services;

import com.hcl.customerservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.customerservice.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        // return customerRepository.getAll();
        List<Customer> customerslist = customerRepository.findAll();
        customerslist.forEach(System.out::println);
        return customerslist;
    }

    public Customer getOneById(int id) {

        //  return customerRepository.getOneById(id);
        Optional<Customer> customer = customerRepository.findById(id);
      //  Optional<Optional<Customer>> optionalCustomer = Optional.ofNullable(customerRepository.findById(id));
        if (customer.isPresent()) {
            System.out.println(customer.get());
            return customer.get();
        }
        else {
                     //return new Customer(0,"DEFAULT",false);
            try {
                return customer.get();
            } catch (Exception e) {
                System.out.println("Message-> " + e.getMessage());
            }
        }
        return null;
    }

    public Customer create(Customer customer) {

        // return  customerRepository.create(customer);
         return customerRepository.save(customer);
     /**   if (customer != null) {
            customerRepository.save(customer);
            System.out.println("customer created successfully --> " + customer.getId() + " " +
                    customer.getName() + " " + customer.isActive());
        } else
            return null;
        return customer;**/
    }

    public Customer update(Customer customer) {


        //   delete(customer.getId());
        //  create(customer);
        //  return  getOneById(customer.getId());
        if (customer!=null)
        {
            customerRepository.save(customer);
            System.out.println("customer updated successfully --> " + customer.getId() + " " +
                    customer.getName() + " " + customer.isActive() );
        }
        else
            return null;
        return customer;
    }

    public void delete(int id) {
        System.out.println("customer with "  +  id + " deleted successfully");
        customerRepository.deleteById(id);
    }

}
