package com.company.vehicle_management.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {


    @GetMapping("/auth/test")
    public String publicTest() {
        return "Rota pública funcionando";
    }

    @GetMapping("/vehicles/test")
    public String privateTest() {
        return "Rota protegida funcionando";
    }
}
