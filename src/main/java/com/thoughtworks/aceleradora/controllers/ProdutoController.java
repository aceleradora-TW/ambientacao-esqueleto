package com.thoughtworks.aceleradora.controllers;

import com.thoughtworks.aceleradora.dominio.Lista;
import com.thoughtworks.aceleradora.dominio.ListaRepository;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository repositorio;
    private ListaRepository listaRepo;

    public ProdutoController(ProdutoRepository repositorio, ListaRepository listaRepo) {
        this.repositorio = repositorio;
        this.listaRepo = listaRepo;
    }

    @GetMapping("/lista")
    @ResponseBody
    public String lista() {

        Optional<Lista> lista = listaRepo.findById(1L);

        if (lista.isEmpty()) {
            return "No lista";
        }

        String produtos = lista.get().getProdutos().stream().map(produto -> String.format("<li>%s</li>", produto.getNome())).collect(joining("\r\n"));

        return String.format("<h1>%s</h1><br><br><ul>%s</ul>", lista.get().getNome(), produtos);
    }

    @GetMapping("/cadastrar/{nome}")
    public String cadastrar(@PathVariable String nome) {
        repositorio.save(new Produto(nome));
        return "redirect:/produtos/listar";
    }

    @GetMapping("/listar")
    public String mostrarLista(Model model) {

        ArrayList<Produto> produtos2 = (ArrayList<Produto>) repositorio.findAll();
        System.out.println(produtos2);
        model.addAttribute("produtos", produtos2);
        return "produto/lista";
    }

}
