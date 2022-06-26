package com.bahadirmemis.interprobe.interprobebootcamp.customer.service.entityservice;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.dao.CustomerDao;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.entity.Customer;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.service.BaseEntityService;
import org.springframework.stereotype.Service;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerDao> {

    public CustomerEntityService(CustomerDao dao) {
        super(dao);
    }
}
