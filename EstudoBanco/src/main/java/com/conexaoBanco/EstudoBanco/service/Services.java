package com.conexaoBanco.EstudoBanco.service;

import com.conexaoBanco.EstudoBanco.model.Model;
import com.conexaoBanco.EstudoBanco.repository.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service

public class Services  {

    private final Repository repository;

    public Services(Repository repository){
        this.repository = repository;
    }


    public List<Model> listar(){
        return repository.findAll();
    }

    public Model inserir(Model model){
        return repository.save(model);
    }

}
