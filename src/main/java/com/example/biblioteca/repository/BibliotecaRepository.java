package com.example.biblioteca.repository;

import com.example.biblioteca.model.BibliotecaModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends MongoRepository<BibliotecaModel, String> {
    BibliotecaModel findByName(String nombreLibro);
}
