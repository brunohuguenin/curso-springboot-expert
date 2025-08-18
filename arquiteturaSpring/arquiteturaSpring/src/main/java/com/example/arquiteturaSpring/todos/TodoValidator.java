package com.example.arquiteturaSpring.todos;


import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo) {
        if (existeTodoComMesmaDesc(todo.getDescricao())) {
            throw new IllegalArgumentException("Já existe um TODO com está descroção!");

        }
    }


    private boolean existeTodoComMesmaDesc(String descricao) {
        return repository.existsByDescricao(descricao);
    }
}
