package com.app.vendas.domain.controller;

import com.app.vendas.domain.db.Produto;
import com.app.vendas.domain.repository.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProductRepository productRepository;

    public ProdutoController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto create(@RequestBody Produto produto ){
        return productRepository.save(produto);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Produto produto){
        productRepository.findById(id)
                .map(produtoExistente-> {
                    produto.setId(produtoExistente.getId());
                    productRepository.save(produto);
                    return produtoExistente;
                }).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existente"));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Produto delete(@PathVariable Integer id){
        return productRepository.findById(id)
                .map(produto1 -> {
                    productRepository.delete(produto1);
                    return produto1; })
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existente"));
    }

    @GetMapping ("/read/{id}")
    public Produto read(@PathVariable("id") Integer id){
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existente"));
    }

    @GetMapping("/read/all")
    public List<Produto> readAll(Produto produto){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(produto ,matcher);
        return productRepository.findAll(example);
    }
}
