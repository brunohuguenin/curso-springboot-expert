package com.example.arquiteturaSpring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {


    private TodoRepository todoRepository;
    private TodoValidator validator;
    private MailSender mailSender;


    public TodoService(TodoRepository todoRepository, TodoValidator todoValidator, MailSender mailSender) {
        this.todoRepository = todoRepository;
        this.validator = todoValidator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        validator.validar(novoTodo);
        return  todoRepository.save(novoTodo);
    }

    public void atualizarTodo(TodoEntity todo) {
        todoRepository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "CONCLUÍDO" : "NÃO CONCLUÍDO";
        mailSender.enviar("Todo " +  todo.getDescricao() + " foi atualizado para" + status);
    }

    public TodoEntity buscarPorId(Integer id) {
        return todoRepository.findById(id).orElse(null);
    }
}
