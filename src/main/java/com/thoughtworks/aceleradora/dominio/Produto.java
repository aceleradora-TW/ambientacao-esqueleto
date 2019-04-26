package com.thoughtworks.aceleradora.dominio;


import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="produtos")
@Access(AccessType.FIELD)
public class Produto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;


    public Produto(){}

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @ManyToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
    @JoinTable(
            name = "lista_produtos",
            joinColumns = { @JoinColumn(name = "id_produto") },
            inverseJoinColumns = { @JoinColumn(name = "id_lista") }
    )
    private Set<Lista> listas;

    public Set<Lista> getListas() {
        return listas;
    }

    public void setListas(Set<Lista> listas) {
        this.listas = listas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

