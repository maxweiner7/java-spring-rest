package com.estudo.java.rest.api.controller;

import com.estudo.java.rest.api.model.UsuarioModel;
import com.estudo.java.rest.api.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository){
        this.repository = repository;
    }

    @GetMapping(path = "/api/usuario/todos")
    public List<UsuarioModel> findAll() {
        return repository.findAll();
    }


    @GetMapping(path = "/api/usuario/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/usuario/novo")
    public UsuarioModel salvaUsaurio(@Valid @RequestBody UsuarioModel usuario, BindingResult bindingResult) {
        return repository.save(usuario);

    }

    @DeleteMapping(path = "/api/usuario/delete")
    public void deletaUsuario(@Valid @RequestBody UsuarioModel usuario, BindingResult bindingResult) {
        repository.delete(usuario);

    }

    @PutMapping(path = "/api/usuario/atualiza")
    public UsuarioModel atualizaUsaurio(@Valid @RequestBody UsuarioModel usuario, BindingResult bindingResult) {
        return repository.save(usuario);

    }

}
