package com.conexaoBanco.EstudoBanco.service;

import com.conexaoBanco.EstudoBanco.model.Model;
import com.conexaoBanco.EstudoBanco.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

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

    public Optional<Model> localizarPorID(int id){
        return repository.findById(id);
    }

    public String deletar(int id){
        repository.deleteById(id);
        return "";
    }

    public Optional<Model> atualizarTudoPorID(int id, Model dadosAtualizados){
        return repository.findById(id).map(model -> {
            model.setNome(dadosAtualizados.getNome());
            model.setIdade(dadosAtualizados.getIdade());
            return repository.save(model);
        });
    }

}
