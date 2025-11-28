package org.example.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "titor")
public class Titor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_titor")
    private Long id;

    @Column(length = 100,nullable = false)
    private String nome;

    @Column(length = 150,nullable = false)
    private String apelidos;

    @OneToMany(mappedBy = "tutor")
    private List<Alumno> alumnos;

    public Titor(Long id, String nome, String apelidos) {
        this.id = id;
        this.nome = nome;
        this.apelidos = apelidos;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Titor(String nome, String apelidos) {
        this.nome = nome;
        this.apelidos = apelidos;
    }

    public Titor() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }
}
