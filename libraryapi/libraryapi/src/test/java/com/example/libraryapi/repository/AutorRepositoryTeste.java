package com.example.libraryapi.repository;


import com.example.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTeste {

    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTeste() {
        Autor autor = new Autor();
        autor.setNome("George Orwell");
        autor.setNascionalidade("Britânica");
        autor.setDataNascimento(LocalDate.of(1903, 6, 25));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor Salvo: " + autorSalvo);
    }

    @Test
    public void atualizarTeste() {
        var id = UUID.fromString("777e0926-b741-4199-a8f0-a4a6b73b4895");
        Optional<Autor> possivelAutor = repository.findById(id);

        if (possivelAutor.isPresent()) {
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor:");
            System.out.println(autorEncontrado);

            autorEncontrado.setNome("Luís de Camões");
            autorEncontrado.setNascionalidade("Portuguesa");
            autorEncontrado.setDataNascimento(LocalDate.of(1960, 1, 30));

            repository.save(autorEncontrado);
        }
    }

    @Test
    public void listarTodosTeste() {
        List<Autor> all = repository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void deletarPorIdTeste() {
        var id = UUID.fromString("74d03eee-8bcb-481a-8294-2bd5f7391442");
        repository.deleteById(id);
    }

}
