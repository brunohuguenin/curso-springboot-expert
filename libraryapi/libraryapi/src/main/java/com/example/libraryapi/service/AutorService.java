package com.example.libraryapi.service;

import com.example.libraryapi.dto.AutorDTO;
import com.example.libraryapi.model.Autor;
import com.example.libraryapi.repository.AutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public Optional<Autor> obterPorId(UUID id) {
        return autorRepository.findById(id);
    }
}
