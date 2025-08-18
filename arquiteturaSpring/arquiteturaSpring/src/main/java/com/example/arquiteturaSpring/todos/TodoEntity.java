package com.example.arquiteturaSpring.todos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_todo")
@Data
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "fl_concluido")
    private Boolean concluido;
}
