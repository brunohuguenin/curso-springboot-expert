package com.example.ProdutosApi.controller;

import com.example.ProdutosApi.model.Produto;
import com.example.ProdutosApi.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.PreferencesEvent;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produtos")
public class ProdutoCrontroller {

    private ProdutoRepository produtoRepository;

    public ProdutoCrontroller(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody @Valid Produto produto) {
        System.out.println("Produto recebido: " + produto);
        return produtoRepository.save(produto);
    }

    @GetMapping("/{id}")
    public Produto obterProduto(@PathVariable("id") Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizarProduto(@PathVariable("id") Long id, @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }

//    @GetMapping
//    public List<Produto> buscarProduto(@RequestParam("nome") String nome) {
//        return produtoRepository.findByName(nome);
//    }

}
