package com.conexaoBanco.EstudoBanco.controller;
import com.conexaoBanco.EstudoBanco.model.Model;
import com.conexaoBanco.EstudoBanco.service.Services;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.sql.ClientInfoStatus;
import java.util.Optional;

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

    @GetMapping("/id/{id}")
    public Optional<Model> localizarPorID(@PathVariable int id){
        return services.localizarPorID(id);
    }

    @GetMapping("/deletar/{id}")
    public String deletarPorID(@PathVariable int id){
        String string = "Registro " + services.localizarPorID(id) + " foi deletado com sucesso.";
        services.deletar(id);
        return string;
    }

    @PutMapping("/atualizarCompletamente/{id}")
    public ResponseEntity<Model> atualizarTudoPorID(@PathVariable int id, @RequestBody Model model){
        Optional<Model> dadosAtualizados = services.atualizarTudoPorID(id, model);
        return dadosAtualizados.map(ResponseEntity::ok)
                                .orElse(ResponseEntity.notFound().build());
    }

}
