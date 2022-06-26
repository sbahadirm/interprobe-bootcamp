package com.bahadirmemis.interprobe.interprobebootcamp.customer.converter;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerResponseDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerSaveRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerResponseDto convertToCustomerResponseDto(Customer customer);

    Customer convertToCustomer(CustomerSaveRequestDto customerSaveRequestDto);
}
