package com.bahadirmemis.interprobe.interprobebootcamp;

import com.bahadirmemis.interprobe.interprobebootcamp.generic.response.RestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class BaseTest {

    protected ObjectMapper objectMapper;

    protected boolean isSuccess(MvcResult result) throws Exception {

        RestResponse restResponse = getRestResponse(result);

        boolean isSuccess = restResponse.isSuccess();

        return isSuccess;
    }

    private RestResponse getRestResponse(MvcResult result) throws JsonProcessingException, UnsupportedEncodingException {
        RestResponse restResponse = objectMapper.readValue(result.getResponse().getContentAsString(), RestResponse.class);
        return restResponse;
    }
}
