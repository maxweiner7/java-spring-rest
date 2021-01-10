package com.estudo.java.rest.api.repository;

import com.estudo.java.rest.api.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
}
