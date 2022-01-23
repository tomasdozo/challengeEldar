package com.dozotomas.challenge.controller;

import com.dozotomas.challenge.dto.ExceptionDTO;
import com.dozotomas.challenge.dto.RequestDTO;
import com.dozotomas.challenge.dto.ResponseDTO;
import com.dozotomas.challenge.exceptions.BrandNotFoundException;
import com.dozotomas.challenge.exceptions.InvalidOperationException;
import com.dozotomas.challenge.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @PostMapping("/echo")
    public String echo(@RequestBody String json) {
        return json;
    }

    @PostMapping("/fee")
    public ResponseDTO fee(@RequestBody RequestDTO request) throws InvalidOperationException, BrandNotFoundException {
        return new ResponseDTO(Utils.fee(request.getBrand(), request.getValue()));
    }

    @ExceptionHandler({InvalidOperationException.class,BrandNotFoundException.class})
    public ResponseEntity<ExceptionDTO> exception(Exception e) {
        return new ResponseEntity<>(new ExceptionDTO(400,e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
