package com.example.arquiteturaSpring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService todoService) {
        this.service = todoService;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo) {

        try {
            return this.service.salvar(todo);
        } catch (IllegalArgumentException e) {
            var messagemErro = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, messagemErro);
        }
    }

    @PutMapping("/{id}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
        todo.setId(id);
        service.atualizarTodo(todo);
    }

    @GetMapping("/{id}")
    public TodoEntity buscar(@PathVariable("id") Integer id) {
        return service.buscarPorId(id);
    }
}
