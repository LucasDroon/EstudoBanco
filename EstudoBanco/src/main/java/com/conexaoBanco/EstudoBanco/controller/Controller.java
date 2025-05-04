package com.conexaoBanco.EstudoBanco.controller;
import com.conexaoBanco.EstudoBanco.model.Model;
import com.conexaoBanco.EstudoBanco.service.Services;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.sql.ClientInfoStatus;

@RestController
@RequestMapping("/estoque")
public class Controller {

    private final Services services;

    public Controller(Services services) {
        this.services = services;
    }

    @GetMapping("/teste")
    public String teste(){
        return "O PAI APRENDEU ADAJSHGDAYHSDFAJHTSGDFAJHSGD.";
    }

    @GetMapping("/listar")
    public List<Model> listar(){
        return services.listar();
    }
    
    @PostMapping("/inserir")
    public Model inserir(@RequestBody Model model){
        return services.inserir(model);
    }

}
