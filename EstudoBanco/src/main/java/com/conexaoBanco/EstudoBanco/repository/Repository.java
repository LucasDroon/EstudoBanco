package com.conexaoBanco.EstudoBanco.repository;

import com.conexaoBanco.EstudoBanco.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Model, Integer> {

}
