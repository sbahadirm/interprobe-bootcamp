package com.bahadirmemis.interprobe.interprobebootcamp.customer.service;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.converter.CustomerConverter;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.converter.CustomerMapper;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerResponseDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerSaveRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.entity.Customer;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.enums.EnumStatus;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerEntityService customerEntityService;
    private final CustomerConverter customerConverter;

    public List<Customer> findAll(){
        return customerEntityService.findAll();
    }

    public Customer findById(Long id){
        return customerEntityService.findById(id).orElseThrow();
    }

    public CustomerResponseDto save(CustomerSaveRequestDto customerSaveRequestDto){

//        Customer customer = customerConverter.convertToCustomer(customerSaveRequestDto);
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(customerSaveRequestDto);
        customer.setStatus(EnumStatus.ACTIVE);
        customer = customerEntityService.save(customer);

//        CustomerResponseDto customerResponseDto = customerConverter.convertToCustomerResponseDto(customer);
        CustomerResponseDto customerResponseDto = CustomerMapper.INSTANCE.convertToCustomerResponseDto(customer);
        return customerResponseDto;
    }

    public void delete(Long id){
        customerEntityService.delete(id);
    }

    public void delete(Customer customer){
        customerEntityService.delete(customer);
    }

    public boolean isExist(Long id){
        return customerEntityService.isExist(id);
    }

    public Customer cancel(Long id){

        Customer customer = customerEntityService.findById(id).orElseThrow();
        customer.setStatus(EnumStatus.PASSIVE);
        customer.setCancelDate(new Date());

        return customerEntityService.save(customer);
    }

    public Customer update(Customer customer) {
        return null;//TODO:
    }
}
