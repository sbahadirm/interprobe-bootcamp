package com.bahadirmemis.interprobe.interprobebootcamp.customer.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
public class CustomerSaveRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @Size(min = 3, max = 10)
    private String username;

    @Size(min = 8)
    private String password;
    private String phoneNumber;
    private String email;
    private Date birthDate;
}
