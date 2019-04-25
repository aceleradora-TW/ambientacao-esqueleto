package com.thoughtworks.aceleradora.controllers;

import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();
    private ProdutoRepository repositorio;

    public ProdutoController(ProdutoRepository repositorio) {
        this.repositorio = repositorio;

    }

    @GetMapping("/listar")
    public String mostrarLista(Model model) {

        ArrayList<Produto> produtos2= (ArrayList<Produto>) repositorio.findAll();
        System.out.println(produtos2);
        model.addAttribute("produtos", produtos2);
        return "produto/lista";
    }

}
