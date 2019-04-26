package com.thoughtworks.aceleradora.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="listas")
public class Lista {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    
    private List<Produto> produtos = new ArrayList<>();

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

    public List<Produto> getProdutos(){
        return produtos;
    }





}
