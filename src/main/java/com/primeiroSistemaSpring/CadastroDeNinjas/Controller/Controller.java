package com.primeiroSistemaSpring.CadastroDeNinjas.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/inicio")
    public String boasDeNinjas() {
        return "Bem Vindo Ninjas";
    }

}
