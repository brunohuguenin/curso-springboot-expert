package com.example.libraryapi.repository;


import com.example.libraryapi.model.Autor;
import com.example.libraryapi.model.GeneroLivro;
import com.example.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTeste {

    @Autowired
    AutorRepository autorRepository;
    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTeste() {
        Autor autor = new Autor();
        autor.setNome("George Orwell");
        autor.setNacionalidade("Britânica");
        autor.setDataNascimento(LocalDate.of(1903, 6, 25));

        var autorSalvo = autorRepository.save(autor);
        System.out.println("Autor Salvo: " + autorSalvo);
    }

    @Test
    public void atualizarTeste() {
        var id = UUID.fromString("777e0926-b741-4199-a8f0-a4a6b73b4895");
        Optional<Autor> possivelAutor = autorRepository.findById(id);

        if (possivelAutor.isPresent()) {
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor:");
            System.out.println(autorEncontrado);

            autorEncontrado.setNome("Luís de Camões");
            autorEncontrado.setNacionalidade("Portuguesa");
            autorEncontrado.setDataNascimento(LocalDate.of(1960, 1, 30));

            autorRepository.save(autorEncontrado);
        }
    }

    @Test
    public void listarTodosTeste() {
        List<Autor> all = autorRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void deletarPorIdTeste() {
        var id = UUID.fromString("41607e9e-6648-40fc-8b04-d70d69985792");
        autorRepository.deleteById(id);
    }

    @Test
    void salvarAutorComLivrosTeste() {
        Autor autor = new Autor();
        autor.setNome("Zygmunt Bauman");
        autor.setNacionalidade("Polonesa");
        autor.setDataNascimento(LocalDate.of(1925, 11, 19));

        Livro livro = new Livro();
        livro.setIsbn("1457-9862");
        livro.setPreco(BigDecimal.valueOf(99.99));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Modernidade Líquida");
        livro.setDataPublicacao(LocalDate.of(1999, 10, 13));
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setIsbn("2684-9517");
        livro2.setPreco(BigDecimal.valueOf(189.99));
        livro2.setGenero(GeneroLivro.FICCAO);
        livro2.setTitulo("Vida Líquida");
        livro2.setDataPublicacao(LocalDate.of(2001, 7, 21));
        livro2.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        autorRepository.save(autor);
        livroRepository.saveAll(autor.getLivros());
    }

}
