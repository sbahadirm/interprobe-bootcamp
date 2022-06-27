package com.bahadirmemis.interprobe.interprobebootcamp.customer.controller;

import com.bahadirmemis.interprobe.interprobebootcamp.BaseTest;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerSaveRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerUpdateRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.response.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CustomerControllerTest extends BaseTest {

    private static final String BASE_PATH = "/api/v1/customers";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Test
    void findAll() throws Exception {

        MvcResult result = mockMvc.perform(
                get(BASE_PATH).content("").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertTrue(isSuccess);
    }

    @Test
    void findById() throws Exception {

        MvcResult result = mockMvc.perform(
                get(BASE_PATH + "/1").content("").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertTrue(isSuccess);
    }

    @Test
    void save() throws Exception {

        String body = "{\n" +
                "  \"name\": \"Integration\",\n" +
                "  \"surname\": \"Test\",\n" +
                "  \"username\": \"itest\",\n" +
                "  \"password\": \"1231231234\",\n" +
                "  \"phoneNumber\": \"122334343\",\n" +
                "  \"email\": \"integration@test.com\",\n" +
                "  \"birthDate\": \"2022-06-27T17:48:06.261Z\"\n" +
                "}";

        MvcResult result = mockMvc.perform(
                post(BASE_PATH).content(body).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertTrue(isSuccess);
    }

    @Test
    void save2() throws Exception {

        CustomerSaveRequestDto customerSaveRequestDto = CustomerSaveRequestDto.builder()
                .name("integration2")
                .surname("test2")
                .username("itest2")
                .password("1231231234")
                .phoneNumber("12122323")
                .email("sgdsd@dfhdf.com")
                .birthDate(new Date())
                .build();

        String body = objectMapper.writeValueAsString(customerSaveRequestDto);

        MvcResult result = mockMvc.perform(
                post(BASE_PATH).content(body).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertTrue(isSuccess);
    }

    @Test
    void delete() throws Exception {

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.delete(BASE_PATH + "/302").content("302").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertTrue(isSuccess);
    }

    @Test
    void update() throws Exception {

        String body = "{\n" +
                "  \"id\": 252,\n" +
                "  \"name\": \"string\",\n" +
                "  \"surname\": \"string\",\n" +
                "  \"username\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phoneNumber\": \"string\",\n" +
                "  \"email\": \"string@str.com\",\n" +
                "  \"birthDate\": \"2022-06-27T17:57:20.661Z\"\n" +
                "}";

        MvcResult result = mockMvc.perform(
                put(BASE_PATH).content(body).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertTrue(isSuccess);
    }

    @Test
    void cancel() throws Exception {

        MvcResult result = mockMvc.perform(
                patch(BASE_PATH+ "/cancel/252").content("252").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        boolean isSuccess = isSuccess(result);

        assertTrue(isSuccess);
    }
}