package com.example.libraryapi.repository;

import com.example.libraryapi.service.TransacoesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransacoesTeste {
    @Autowired
    TransacoesService transacoesService;

    /**
     * Commit -> confirmar auterações
     * Rollback -> desfazer auterações
     */

    // salvar um livro
    // salvar o autor
    // alugar o livro
    // enviar email pro locatário
    // notificar que o livro saiu da livraria

    @Test
    void transacaoSimples() {
        transacoesService.executar();
    }

    @Test
    void transacaoEstadoManaged() {
        transacoesService.atualizacaoSemAtualizar();
    }
}
