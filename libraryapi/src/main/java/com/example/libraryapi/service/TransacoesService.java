package com.example.libraryapi.service;


import com.example.libraryapi.model.Autor;
import com.example.libraryapi.model.GeneroLivro;
import com.example.libraryapi.model.Livro;
import com.example.libraryapi.repository.AutorRepository;
import com.example.libraryapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransacoesService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;


    // livro (titulo, ...., nome_arquivo) -> id.png
    @Transactional
    public void salvarLivroComFoto() {
        // salva o livro
        // repository.save(livro);

        // pega o id do livro -> liro = livro.getId();
        // var id = livro.getId();

        // salvar foto do livro -> bucket na nuvem
        // bucketService.salvar(livro.getFoto(), id + ".png");

        // atualizar o nome arquivo que foi salvo
        // livro.setNomeArquivoFoto(id + ".png");
    }

    @Transactional
    public void atualizacaoSemAtualizar() {
        var livro = livroRepository.findById(UUID.fromString("121a5d4c-7c1d-4bb8-88c9-ff9a08586a5d")).orElse(null);
        livro.setDataPublicacao(LocalDate.of(2024, 8, 19));
    }

    @Transactional
    public void executar() {

        // Salva o Autor
        Autor autor = new Autor();
        autor.setNome("Francisco");
        autor.setNacionalidade("Americana");
        autor.setDataNascimento(LocalDate.of(1975, 3, 22));

        autorRepository.saveAndFlush(autor);



        // Salva o Autor
        Livro livro = new Livro();
        livro.setIsbn("1234-1234");
        livro.setPreco(BigDecimal.valueOf(300.00));
        livro.setGenero(GeneroLivro. BIOGRAFIA);
        livro.setTitulo("Livro do Francisco");
        livro.setDataPublicacao(LocalDate.of(2007, 11, 16));

        livro.setAutor(autor);
        livroRepository.saveAndFlush(livro);

        if (autor.getNome().equals("Francisco")) {
            throw new RuntimeException("Rollback!");
        }
    }
}
