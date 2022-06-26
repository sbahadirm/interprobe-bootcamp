package com.bahadirmemis.interprobe.interprobebootcamp.customer.converter;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerResponseDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerSaveRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.entity.Customer;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.enums.EnumStatus;
import org.springframework.stereotype.Component;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Component
public class CustomerConverter {

    public CustomerResponseDto convertToCustomerResponseDto(Customer customer) {
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setId(customer.getId());
        customerResponseDto.setName(customer.getName());
        customerResponseDto.setSurname(customer.getSurname());
        customerResponseDto.setUsername(customer.getUsername());
        customerResponseDto.setEmail(customer.getEmail());
        customerResponseDto.setBirthDate(customer.getBirthDate());
        customerResponseDto.setPhoneNumber(customer.getPhoneNumber());
        customerResponseDto.setStatus(customer.getStatus());
        customerResponseDto.setCancelDate(customer.getCancelDate());
        return customerResponseDto;
    }

    public Customer convertToCustomer(CustomerSaveRequestDto customerSaveRequestDto) {
        Customer customer = new Customer();
        customer.setName(customerSaveRequestDto.getName());
        customer.setSurname(customerSaveRequestDto.getSurname());
        customer.setEmail(customerSaveRequestDto.getEmail());
        customer.setBirthDate(customerSaveRequestDto.getBirthDate());
        customer.setPassword(customerSaveRequestDto.getPassword());
        customer.setPhoneNumber(customerSaveRequestDto.getPhoneNumber());
        customer.setUsername(customerSaveRequestDto.getUsername());
        customer.setStatus(EnumStatus.ACTIVE);

        return customer;
    }
}
