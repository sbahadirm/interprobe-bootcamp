package com.bahadirmemis.interprobe.interprobebootcamp.customer.controller;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerResponseDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerSaveRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerUpdateRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.entity.Customer;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponseDto> findAll(){
        return customerService.findAll();
    }

    /**
     * pathVariable: localhost:8080/customers/1
     * requestParam: localhost:8080/customers?id=1&name=bahadir
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CustomerResponseDto findById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @PostMapping
    public CustomerResponseDto save(@RequestBody CustomerSaveRequestDto customerSaveRequestDto){
        return customerService.save(customerSaveRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        customerService.delete(id);
    }

    @PutMapping
    public CustomerResponseDto update(@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto){
        return customerService.update(customerUpdateRequestDto);
    }

    @PatchMapping("/cancel/{id}")
    public CustomerResponseDto cancel(@PathVariable Long id){
        return customerService.cancel(id);
    }
}
