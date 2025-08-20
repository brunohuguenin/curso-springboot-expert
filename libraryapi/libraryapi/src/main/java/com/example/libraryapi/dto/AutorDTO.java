package com.example.libraryapi.dto;

import com.example.libraryapi.model.Autor;

import java.time.LocalDate;

public record AutorDTO(String nome, LocalDate dataNascimento, String nacionalidade) {

    public Autor mapearAutor() {
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNascionalidade(this.nacionalidade);
        return autor;
    }
}
