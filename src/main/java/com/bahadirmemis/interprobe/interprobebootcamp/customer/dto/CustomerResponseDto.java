package com.bahadirmemis.interprobe.interprobebootcamp.customer.dto;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.enums.EnumStatus;
import lombok.Data;

import java.util.Date;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
public class CustomerResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String phoneNumber;
    private String email;
    private Date birthDate;
    private EnumStatus status;
    private Date cancelDate;
}
