package com.bahadirmemis.interprobe.interprobebootcamp.kafka;

import com.bahadirmemis.interprobe.interprobebootcamp.resttemplate.MailSendRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class KafkaTestController {

    @Value("${interprobe.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, MailSendRequestDto> kafkaTemplate;

    @PostMapping("/send-mail")
    public void sendMail(@RequestBody MailSendRequestDto mailSendRequestDto){
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), mailSendRequestDto);
    }

}
