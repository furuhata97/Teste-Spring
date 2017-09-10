package com.saude.clinica.com.saude.clinica.controller;


import com.saude.clinica.com.saude.clinica.repository.Pacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class MenuPrincipalController {


    @RequestMapping("/principal")
    public String principal(){
        return "principal";
    }

    @RequestMapping("/secretaria")
    public String secretaria(){
        return "secretariaView";
    }

}
