package com.bahadirmemis.interprobe.interprobebootcamp.customer.entity;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.enums.EnumStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(generator = "Customer")
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Column(name = "USERNAME", length = 15, nullable = false, updatable = false)
    private String username;

    @Column(name = "PASSWORD", length = 400, nullable = false)
    private String password;

    @Column(name = "PHONE_NUMBER", length = 15)
    private String phoneNumber;

    @Email
    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "STATUS", length = 30)
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

    @Column(name = "CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;
}
