package com.bahadirmemis.interprobe.interprobebootcamp.customer.dao;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public interface CustomerDao extends JpaRepository<Customer, Long> {
}
