package com.example.libraryapi.controller;


import com.example.libraryapi.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

}
