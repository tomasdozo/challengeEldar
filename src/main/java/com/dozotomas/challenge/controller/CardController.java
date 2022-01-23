package com.dozotomas.challenge.controller;

import com.dozotomas.challenge.dto.CardDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @PostMapping("/echo")
    public String echo(@RequestBody String json) {
        return json;
    }

    @PostMapping("/rate")
    public String fee(@RequestBody CardDTO info) {
        return "info";
    }
}
