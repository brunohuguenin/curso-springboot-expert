package com.example.arquiteturaSpring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {


    @Autowired
    private TodoValidator validator;

    @Autowired
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar() {
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    @Autowired
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }
}
