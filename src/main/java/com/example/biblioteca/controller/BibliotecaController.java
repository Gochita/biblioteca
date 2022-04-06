package com.example.biblioteca.controller;

import com.example.biblioteca.model.BibliotecaModel;
import com.example.biblioteca.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {


    @Autowired
    BibliotecaService bibliotecaService;

    @GetMapping()
    public ResponseEntity<List<BibliotecaModel>> findAll(){
        return new ResponseEntity<>(bibliotecaService.traerRecursos(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BibliotecaModel>findbyId(@PathVariable("id") String id) {
        return new ResponseEntity(bibliotecaService.traerPorId(id), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<BibliotecaModel>create(@RequestBody BibliotecaModel bibliotecaModel) {
        return new ResponseEntity(bibliotecaService.crearRecurso(bibliotecaModel), HttpStatus.CREATED);
    }
    @PutMapping("/actualizar")
    public ResponseEntity<BibliotecaModel> update(@RequestBody BibliotecaModel bibliotecaModel){
        if (bibliotecaModel.getId() != null){
            return new ResponseEntity(bibliotecaService.actualizar(bibliotecaModel),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/disponibilidad")
    public ResponseEntity<String> disponibilidad(@RequestBody BibliotecaModel bibliotecaModel){
        if(bibliotecaService.avaliable(bibliotecaModel.getNombreLibro())){
            return new ResponseEntity("Disponible para prestamo", HttpStatus.OK);
        }else{
            return new ResponseEntity("No disponible para prestamo", HttpStatus.NOT_FOUND);
        }

    }

}
