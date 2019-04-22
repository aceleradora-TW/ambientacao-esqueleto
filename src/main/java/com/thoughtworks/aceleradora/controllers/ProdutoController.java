package com.thoughtworks.aceleradora.controllers;

import com.thoughtworks.aceleradora.dominio.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    @GetMapping("/listar")
    public String mostrarLista() {
        Produto banana = new Produto("banana");
        Produto uva = new Produto("uva");
        Produto maca= new Produto("maçã");
        Produto laranja = new Produto("laranja");
        produtos.add(banana);
        produtos.add(uva);
        produtos.add(maca);
        produtos.add(laranja);
        return "produto/lista";
    }
}
