package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long id;

    @Column(length = 100,nullable = false)
    private String nome;

    @Column(length = 150,nullable = false)
    private String apelidos;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "titor",referencedColumnName = "id_titor")
    @JsonBackReference
    private Titor titor;

    public Alumno(Long id, String nome, String apelidos, Titor titor) {
        this.id = id;
        this.nome = nome;
        this.apelidos = apelidos;
        this.titor = titor;
    }

    public Alumno(String apelidos, Titor titor, String nome) {
        this.apelidos = apelidos;
        this.titor = titor;
        this.nome = nome;
    }

    public Alumno() {}

    public Titor getTitor() {
        return titor;
    }

    public void setTitor(Titor titor) {
        this.titor = titor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }
}
