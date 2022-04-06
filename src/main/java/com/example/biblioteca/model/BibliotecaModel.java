package com.example.biblioteca.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;
@Document(collection = "Libros")
public class BibliotecaModel {

        @Id
        private String id;
        private String name;
        private String generoLiterario;
        private String autor;
        private String fecha;
        private String tipoRecurso;
        private boolean prestado;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombreLibro() {
            return name;
        }

        public void setNombreLibro(String nombreLibro) {
            this.name = nombreLibro;
        }

        public String getGeneroLiterario() {
            return generoLiterario;
        }

        public void setGeneroLiterario(String generoLiterario) {
            this.generoLiterario = generoLiterario;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getTipoRecurso() {
            return tipoRecurso;
        }

        public void setTipoRecurso(String tipoRecurso) {
            this.tipoRecurso = tipoRecurso;
        }

        public boolean isPrestado() {
            return prestado;
        }

        public void setPrestado(boolean prestado) {
            this.prestado = prestado;
        }


}



