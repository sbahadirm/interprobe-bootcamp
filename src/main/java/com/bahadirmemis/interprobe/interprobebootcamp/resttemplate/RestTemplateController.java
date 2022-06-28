package com.bahadirmemis.interprobe.interprobebootcamp.resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/rest-template")
public class RestTemplateController {

    @GetMapping("/default-mail-address")
    public String getDefaultMailInfo(){

        String url = "http://localhost:8081/api/v1/mails/default-mail-address";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        String body = responseEntity.getBody();

        return body;
    }

    @GetMapping("/mail-info")
    public MailSendRequestDto getMailSendRequestDto(){

        String url = "http://localhost:8081/api/v1/mails/mail-info";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MailSendRequestDto> responseEntity = restTemplate.getForEntity(url,
                MailSendRequestDto.class);

        MailSendRequestDto body = responseEntity.getBody();

        System.out.println(body);

        return body;
    }

    @PostMapping
    public boolean sendMail(@RequestBody MailSendRequestDto mailSendRequestDto){

        String url = "http://localhost:8081/api/v1/mails";

//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity(url, mailSendRequestDto, Boolean.class);

        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());

        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(mailSendRequestDto), Boolean.class);

        return responseEntity.getBody();
    }

    public SimpleClientHttpRequestFactory getClientHttpRequestFactory(){

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);

        return factory;
    }
}
