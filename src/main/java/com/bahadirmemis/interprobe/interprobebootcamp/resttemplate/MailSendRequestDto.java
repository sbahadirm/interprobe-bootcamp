package com.bahadirmemis.interprobe.interprobebootcamp.resttemplate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailSendRequestDto {

    private String emailAddress;
    private String subject;
    private String body;
}
