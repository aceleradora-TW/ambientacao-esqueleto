package com.thoughtworks.aceleradora.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
@Entity(name="listas")
public class Lista {

//    @Id
//    @GeneratedValue(strategy = IDENTITY)
    @Id@GeneratedValue@Access(value=AccessType.FIELD)
    private Long id;

    private String nome;

    public Lista(){

    }

    public Lista(String nome){
        this.nome = nome;

    }

    public void setId(Long id){
        this.id = id;

    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }


    @ManyToMany(mappedBy = "listas")
    @JsonIgnoreProperties("listas")
    private List<Produto> produtos;


    public List<Produto> getProdutos() {
        return produtos;
    }


}
