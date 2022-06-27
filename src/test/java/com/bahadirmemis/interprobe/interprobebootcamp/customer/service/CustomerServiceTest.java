package com.bahadirmemis.interprobe.interprobebootcamp.customer.service;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerResponseDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerSaveRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.entity.Customer;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.service.entityservice.CustomerEntityService;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.enums.GeneralErrorMessage;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.exceptions.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerEntityService customerEntityService;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void shouldFindAll() {

        List<CustomerResponseDto> customerResponseDtoList = customerService.findAll();

        assertEquals(0, customerResponseDtoList.size());
    }

    @Test
    void shouldFindAllWhenReturnsCustomers() {

        Customer customer = mock(Customer.class);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        when(customerEntityService.findAll()).thenReturn(customerList);

        List<CustomerResponseDto> customerResponseDtoList = customerService.findAll();

        assertEquals(1, customerResponseDtoList.size());
    }

    @Test
    void shouldFindAllWhenCustomerListISNull() {

        when(customerEntityService.findAll()).thenReturn(null);

        List<CustomerResponseDto> customerResponseDtoList = customerService.findAll();

        assertNull(customerResponseDtoList);
    }

    @Test
    void shouldFindById() {

        Customer customer = mock(Customer.class);
        when(customer.getId()).thenReturn(1L);

        when(customerEntityService.findById(anyLong())).thenReturn(Optional.of(customer));

        CustomerResponseDto result = customerService.findById(1L);

        assertEquals(1L, result.getId());
    }

    @Test
    void shouldNotFindByIdWhenIdDoesNotExist() {

        when(customerEntityService.findById(anyLong())).thenThrow(NoSuchElementException.class);

        assertThrows(NoSuchElementException.class, () -> customerService.findById(-1L));

    }

    @Test
    void shouldSave() {

        CustomerSaveRequestDto customerSaveRequestDto = mock(CustomerSaveRequestDto.class);

        Customer customer = mock(Customer.class);
        when(customer.getId()).thenReturn(1L);

        when(customerEntityService.save(any())).thenReturn(customer);

        CustomerResponseDto result = customerService.save(customerSaveRequestDto);

        assertEquals(1L, result.getId());
    }

    @Test
    void shouldNotSaveWhenParameterIsNull() {

        BusinessException businessException = assertThrows(BusinessException.class, () -> customerService.save(null));

        assertEquals(GeneralErrorMessage.VALUES_CANNOT_BE_NULL, businessException.getBaseErrorMessage());

    }

    @Test
    void shouldDelete() {

        doNothing().when(customerEntityService).delete(anyLong());

        customerService.delete(1L);

        verify(customerEntityService).delete(anyLong());
    }

    @Test
    void shouldNotDelete() {

        doThrow(NoSuchElementException.class).when(customerEntityService).delete(anyLong());

        assertThrows(NoSuchElementException.class, () -> customerService.delete(anyLong()));

        verify(customerEntityService).delete(anyLong());
    }

    @Test
    void shouldTestDelete() {

        Customer customer = mock(Customer.class);

        doNothing().when(customerEntityService).delete(customer);

        customerService.delete(customer);

        verify(customerEntityService).delete(any(Customer.class));
    }

    @Test
    void shouldNotTestDelete() {

        Customer customer = mock(Customer.class);

        doThrow(NoSuchElementException.class).when(customerEntityService).delete(any(Customer.class));

        assertThrows(NoSuchElementException.class, () -> customerService.delete(customer));

        verify(customerEntityService).delete(any(Customer.class));
    }

    @Test
    void shouldExist() {

        when(customerEntityService.isExist(anyLong())).thenReturn(Boolean.TRUE);

        boolean isExist = customerService.isExist(1L);

        assertTrue(isExist);
    }

    @Test
    void shouldNotExist() {

        when(customerEntityService.isExist(anyLong())).thenReturn(Boolean.FALSE);

        boolean isExist = customerService.isExist(1L);

        assertFalse(isExist);
    }

    @Test
    void cancel() {
    }

    @Test
    void update() {
    }
}