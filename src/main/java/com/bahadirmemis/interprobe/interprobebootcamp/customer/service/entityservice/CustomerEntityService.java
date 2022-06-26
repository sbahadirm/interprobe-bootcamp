package com.bahadirmemis.interprobe.interprobebootcamp.customer.service.entityservice;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.dao.CustomerDao;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class CustomerEntityService {

    private final CustomerDao customerDao;

    public List<Customer> findAll(){
        return customerDao.findAll();
    }

    public Optional<Customer> findById(Long id){
        return customerDao.findById(id);
    }

    public Customer save(Customer customer){
        return customerDao.save(customer);
    }

    public void delete(Long id){
        customerDao.deleteById(id);
    }

    public void delete(Customer customer){
        customerDao.delete(customer);
    }

    public boolean isExist(Long id){
        return customerDao.existsById(id);
    }
}
