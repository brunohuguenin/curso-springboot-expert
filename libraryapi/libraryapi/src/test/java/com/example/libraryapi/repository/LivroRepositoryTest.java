package com.example.libraryapi.repository;


import com.example.libraryapi.model.Autor;
import com.example.libraryapi.model.GeneroLivro;
import com.example.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarLivroTeste() {
        Livro livro = new Livro();

        livro.setIsbn("1245-9658");
        livro.setPreco(BigDecimal.valueOf(120.99));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("1884");
        livro.setDataPublicacao(LocalDate.of(1956, 5, 23));

        Autor autor = autorRepository.findById(UUID.fromString("01e6eb55-f10d-4f79-983f-6607649958f0")).orElse(null);
        livro.setAutor(autor);

        livroRepository.save(livro);
    }

    @Test
    void salvarCascadeTeste() {
        Livro livro = new Livro();

        livro.setIsbn("1223-6593");
        livro.setPreco(BigDecimal.valueOf(75.99));
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setTitulo("Negocie como se sua vida dependesse disso");
        livro.setDataPublicacao(LocalDate.of(2015, 12, 16));

        Autor autor = new Autor();
        autor.setNome("Chris Voss");
        autor.setNascionalidade("Americana");
        autor.setDataNascimento(LocalDate.of(1980, 8, 27));

        autorRepository.save(autor);
        livro.setAutor(autor);
        livroRepository.save(livro);
    }

    @Test
    void atualizarAutorLivro() {
        UUID id = UUID.fromString("");
        var livroParaAtualizar = livroRepository.findById(id).orElse(null);

        UUID idAutor = UUID.fromString("");
        Autor autor = autorRepository.findById(idAutor).orElse(null);

        livroParaAtualizar.setAutor(autor);

        livroRepository.save(livroParaAtualizar);
    }

    @Test
    void deletarLivroTeste() {
        UUID id = UUID.fromString("dfcf6c73-0106-45ef-8e36-1217feb861f3");
        livroRepository.deleteById(id);
    }

    @Test
    void deletarCascadeLivroTeste() {
        UUID id = UUID.fromString("");
        livroRepository.deleteById(id);
    }

    @Test
    void buscarLivroTeste() {
        UUID id = UUID.fromString("4cbaac0e-9384-4bc3-97a0-b5e74e82e029");
        Livro livro = livroRepository.findById(id).orElse(null);
        System.out.println("Livro: ");
        System.out.println(livro.getTitulo());
        System.out.println("Autor: ");
        System.out.println(livro.getAutor().getNome());
    }

    @Test
    @Transactional
    void listarLivrosAutor() {
        var id = UUID.fromString("01e6eb55-f10d-4f79-983f-6607649958f0");
        var autor = autorRepository.findById(id).get();

        List<Livro> livrosLista = livroRepository.findByAutor(autor);
        autor.setLivros(livrosLista);


        autor.getLivros().forEach(System.out::println);
    }

    @Test
    void pesquisaPorTitutloTeste() {
        List<Livro> pesquisa = livroRepository.findByTitulo("Vida Líquida");
        pesquisa.forEach(System.out::println);
    }

    @Test
    void pesquisaPorIsbnTeste() {
        List<Livro> byISBN = livroRepository.findByIsbn("1245-9658");
        System.out.println(byISBN);
    }

    @Test
    void pesquisaPorTitutloEPreco() {
        var preco = BigDecimal.valueOf(200.00);

        List<Livro> lista = livroRepository.findByTituloAndPreco("Pai rico, Pai pobre", preco);
        lista.forEach(System.out::println);
    }

}