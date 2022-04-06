package com.app.vendas.domain.controller;

import com.app.vendas.domain.db.Cliente;
import com.app.vendas.domain.repository.ClientRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {


    private final ClientRepository clientRepository;

    public ClienteController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/read/{id}")
    public Cliente read(@PathVariable("id")Integer id){
        return clientRepository.findById(id)
                               .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não existente"));

    }

    @GetMapping("/read/all")
    public List<Cliente> readAll(Cliente cliente) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(cliente, matcher);
        return clientRepository.findAll(example);

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clientRepository.save(cliente);

    }

    @DeleteMapping("/delete/{id}")  // usar post também funciona, mas melhor usar assim.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Cliente delete(@PathVariable Integer id ){
        return clientRepository.findById(id)
                .map(cliente -> {
                    clientRepository.delete(cliente);
                    return cliente;
                })
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não existente"));

    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @RequestBody Cliente cliente){

      clientRepository
                .findById(id)
                .map(clienteExiste -> {
                    cliente.setId(clienteExiste.getId());
                    clientRepository.save(cliente);
                    return clienteExiste;
                }).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não existente"));
    }



}
