package com.bahadirmemis.interprobe.interprobebootcamp.customer.service;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.converter.CustomerConverter;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.converter.CustomerMapper;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerResponseDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerSaveRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerUpdateRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.entity.Customer;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.enums.CustomerErrorMessage;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.enums.EnumStatus;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.service.entityservice.CustomerEntityService;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.enums.GeneralErrorMessage;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.exceptions.BusinessException;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.exceptions.ItemNotFoundException;
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

    public List<CustomerResponseDto> findAll(){

        List<Customer> customerList = customerEntityService.findAll();

        List<CustomerResponseDto> customerResponseDtoList = CustomerMapper.INSTANCE.convertToCustomerResponseDtoList(customerList);

        return customerResponseDtoList;
    }

    public CustomerResponseDto findById(Long id){

        Customer customer = customerEntityService.findById(id).orElseThrow();

        CustomerResponseDto customerResponseDto = CustomerMapper.INSTANCE.convertToCustomerResponseDto(customer);

        return customerResponseDto;
    }

    public CustomerResponseDto save(CustomerSaveRequestDto customerSaveRequestDto){

        if (customerSaveRequestDto == null){
            throw new BusinessException(GeneralErrorMessage.VALUES_CANNOT_BE_NULL);
        }

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

    public CustomerResponseDto cancel(Long id){

        Customer customer = customerEntityService.findById(id).orElseThrow();
        customer.setStatus(EnumStatus.PASSIVE);
        customer.setCancelDate(new Date());

        customer = customerEntityService.save(customer);

        CustomerResponseDto customerResponseDto = CustomerMapper.INSTANCE.convertToCustomerResponseDto(customer);

        return customerResponseDto;

    }

    public CustomerResponseDto update(CustomerUpdateRequestDto customerUpdateRequestDto) {

        boolean isExist = customerEntityService.isExist(customerUpdateRequestDto.getId());
        if (!isExist){
            throw new ItemNotFoundException(CustomerErrorMessage.CUSTOMER_DOES_NOT_EXIST);
        }

        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(customerUpdateRequestDto);

        customer = customerEntityService.save(customer);

        return CustomerMapper.INSTANCE.convertToCustomerResponseDto(customer);
    }
}
