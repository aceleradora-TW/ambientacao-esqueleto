package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity(name = "listas")
public class Lista {

    @Id
    @GeneratedValue
    @Access(value = AccessType.FIELD)
    private Long id;

    private String nome;

    public Lista() {

    }

    public Lista(String nome) {
        this.nome = nome;

    }

    public void setId(Long id) {
        this.id = id;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    //    @ManyToMany(mappedBy = "listas")
    @JsonIgnoreProperties("listas")
    @ManyToMany(fetch = LAZY, cascade = {ALL})
    @JoinTable(
            name = "lista_produtos",
            joinColumns = {@JoinColumn(name = "id_lista")},
            inverseJoinColumns = {@JoinColumn(name = "id_produto")}
    )
    private List<Produto> produtos;


    public List<Produto> getProdutos() {
        return produtos;
    }

}
