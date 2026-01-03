package com.primeiroSistemaSpring.CadastroDeNinjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/inicio")
    public String boasDeNinjas() {
        return "Bem Vindo Ninjas";
    }

}
