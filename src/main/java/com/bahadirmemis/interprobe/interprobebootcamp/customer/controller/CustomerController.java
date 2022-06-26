package com.bahadirmemis.interprobe.interprobebootcamp.customer.controller;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.dao.CustomerDao;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.entity.Customer;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerEntityService customerEntityService;

    @GetMapping
    public List<Customer> findAll(){
        return customerEntityService.findAll();
    }

    /**
     * pathVariable: localhost:8080/customers/1
     * requestParam: localhost:8080/customers?id=1&name=bahadir
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id){
        Optional<Customer> customerOptional = customerEntityService.findById(id);

        return customerOptional.get();
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer){
        return customerEntityService.save(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        customerEntityService.delete(id);
    }
}
