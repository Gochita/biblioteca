package com.example.biblioteca.service;


import com.example.biblioteca.model.BibliotecaModel;
import com.example.biblioteca.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    @Autowired
    BibliotecaRepository bibliotecaRepository;
    BibliotecaModel bibliotecaModel;

    public List<BibliotecaModel> traerRecursos() {
        return this.bibliotecaRepository.findAll();
    }

    public BibliotecaModel crearRecurso(BibliotecaModel bibliotecaModel){
        return this.bibliotecaRepository.save(bibliotecaModel);
    }
    public BibliotecaModel traerPorId(String id){
        return this.bibliotecaRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    public BibliotecaModel actualizar(BibliotecaModel bibliotecaModel){
        return bibliotecaRepository.findById(bibliotecaModel.getId()).orElseThrow(()-> new RuntimeException("No se puede actualizar"));
    }

    public void eliminarPorId(String id) {
        bibliotecaRepository.deleteById(id);
    }

    public BibliotecaModel findByName(String nombreLibro) {
        return bibliotecaRepository.findByName(nombreLibro);
    }
    public Boolean avaliable (String nombreLibro){
        var recurso = bibliotecaRepository.findByName(nombreLibro);
        return recurso.isPrestado();
    }
}

