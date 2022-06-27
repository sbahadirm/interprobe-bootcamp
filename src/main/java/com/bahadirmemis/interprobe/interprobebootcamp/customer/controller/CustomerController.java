package com.bahadirmemis.interprobe.interprobebootcamp.customer.controller;

import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerResponseDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerSaveRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.dto.CustomerUpdateRequestDto;
import com.bahadirmemis.interprobe.interprobebootcamp.customer.service.CustomerService;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity findAll(){
        List<CustomerResponseDto> customerResponseDtoList = customerService.findAll();
        return ResponseEntity.ok(RestResponse.of(customerResponseDtoList));
    }

    /**
     * pathVariable: localhost:8080/customers/1
     * requestParam: localhost:8080/customers?id=1&name=bahadir
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        CustomerResponseDto customerResponseDto = customerService.findById(id);
        return ResponseEntity.ok(RestResponse.of(customerResponseDto));
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody CustomerSaveRequestDto customerSaveRequestDto){
        CustomerResponseDto customerResponseDto = customerService.save(customerSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(customerResponseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        customerService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto){
        CustomerResponseDto customerResponseDto = customerService.update(customerUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.of(customerResponseDto));
    }

    @PatchMapping("/cancel/{id}")
    public ResponseEntity cancel(@PathVariable Long id){
        CustomerResponseDto customerResponseDto = customerService.cancel(id);
        return ResponseEntity.ok(RestResponse.of(customerResponseDto));
    }
}
