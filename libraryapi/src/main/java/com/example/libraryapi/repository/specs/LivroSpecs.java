package com.example.libraryapi.repository.specs;

import com.example.libraryapi.model.GeneroLivro;
import com.example.libraryapi.model.Livro;
import org.springframework.data.jpa.domain.Specification;

public class LivroSpecs {

    public static Specification<Livro> isbnEqual(String isbn) {
        return (root, query, cb) -> cb.equal(root.get("isbn"), isbn);
    }

    public static Specification<Livro> tituloLike(String titulo) {
        return (root, query, cb) -> cb.like(cb.upper(root.get("titulo")),
                "%" + titulo.toUpperCase() + "%");
    }

    public static Specification<Livro> generoEqual(GeneroLivro generoLivro) {
        return (root, query, cb) -> cb.equal(root.get("genero"), generoLivro);
    }

    public static Specification<Livro> anoPublicacaoEqual(Integer anoPublicacao) {
        // select to_char(data_publicacao, 'DD/MM/YYYY') as ano_publicacao from livro;
        return (root, query, cb) -> cb.equal(cb.function(
                "to_char",
                String.class,
                root.get("dataPublicacao"),
                cb.literal("YYYY")), anoPublicacao.toString()
        );
    }
}
