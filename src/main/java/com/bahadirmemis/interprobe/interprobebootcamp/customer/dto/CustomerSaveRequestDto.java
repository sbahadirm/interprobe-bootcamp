package com.bahadirmemis.interprobe.interprobebootcamp.customer.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
public class CustomerSaveRequestDto {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private Date birthDate;
}
